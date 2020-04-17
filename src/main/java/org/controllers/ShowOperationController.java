package org.controllers;

import org.controllers.departmentOperations.DepartmentShowOperationController;
import org.controllers.employeeOperations.EmployeeShowOperationController;
import org.controllers.positionOperations.PositionShowOperationController;

import java.util.HashMap;
import java.util.Map;

public class ShowOperationController implements OperationTypeController {
    // show/department/all
    private final Map<String, OperationTypeController> operationTypeControllerMap = createMap();

    @Override
    public String execute(String[] parseCommands) {
        if (operationTypeControllerMap.containsKey(parseCommands[1])){
            return operationTypeControllerMap.get(parseCommands[1]).execute(parseCommands);
        }
        else{
            return "\nТаблица " + parseCommands[1]+ " не существует";
        }
    }

    private Map<String, OperationTypeController> createMap() {
        Map<String, OperationTypeController> operationTypeControllerMap = new HashMap<>();
        operationTypeControllerMap.put("department", new DepartmentShowOperationController());
        operationTypeControllerMap.put("employee", new EmployeeShowOperationController());
        operationTypeControllerMap.put("position", new PositionShowOperationController());
        return operationTypeControllerMap;
    }

}
