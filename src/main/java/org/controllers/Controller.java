package org.controllers;

import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private Map<String, OperationTypeController> stringOperationTypeControllerMap = getControllersMap();
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    PositionDao positionDao = new PositionDaoImpl();

    public Controller() {
    }

    public String parse(String inputCommand) {
        String[] parseCommand = inputCommand.split("/");
        if (parseCommand.length > 2) {
            OperationTypeController operationTypeController = stringOperationTypeControllerMap.get(parseCommand[0]);
            if (operationTypeController != null) {
                String entity = parseCommand[1];
                if (entity.equalsIgnoreCase("employee")) {
                    return operationTypeController.execute(parseCommand, employeeDao);
                } else if (entity.equalsIgnoreCase("department")) {
                    return operationTypeController.execute(parseCommand, departmentDao);
                } else if (entity.equalsIgnoreCase("position")) {
                    return operationTypeController.execute(parseCommand, positionDao);
                } else {
                    return "\nТаблица " + entity + " не существует";
                }
            } else {
                return "\nОтсутствует команда " + parseCommand[0];
            }
        } else {
            return "\nНеверная команда";
        }
    }

    public static final Map<String, OperationTypeController> getControllersMap() {
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
