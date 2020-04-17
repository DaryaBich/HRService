package org.controllers;

import org.dao.*;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final Map<String, OperationTypeController> stringOperationTypeControllerMap = getControllersMap();
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    PositionDao positionDao = new PositionDaoImpl();

    public Controller() {
    }

    public String parse(String inputCommand) {
        String[] parseCommand = inputCommand.split("/");
        if (parseCommand.length > 0) {
            if (stringOperationTypeControllerMap.containsKey(parseCommand[0])) {
               return stringOperationTypeControllerMap.get(parseCommand[0]).execute(parseCommand);
            } else {
                return "\nОтсутствует команда " + parseCommand[0];
            }
        } else {
            return "\nСлишком короткая команда";
        }
    }

    public static Map<String, OperationTypeController> getControllersMap() {
        Map<String, OperationTypeController> stringOperationTypeControllerMap = new HashMap<>();
        stringOperationTypeControllerMap.put("show", new ShowOperationController());
        stringOperationTypeControllerMap.put("show by template", new ShowByTemplateOperationController());
        stringOperationTypeControllerMap.put("remove", new RemoveOperationController());
        stringOperationTypeControllerMap.put("update", new UpdateOperationController());
        stringOperationTypeControllerMap.put("add", new AddOperationController());
        stringOperationTypeControllerMap.put("add from file", new AddFromFileOperationController());
        return stringOperationTypeControllerMap;
    }
}
