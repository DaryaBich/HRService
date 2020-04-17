package org.controllers;

import org.controllers.departmentOperations.DepartmentAddOperationController;
import org.controllers.employeeOperations.EmployeeAddOperationController;
import org.controllers.positionOperations.PositionAddOperationController;

import java.util.HashMap;
import java.util.Map;

public class AddOperationController implements OperationTypeController {
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
        operationTypeControllerMap.put("department", new DepartmentAddOperationController());
        operationTypeControllerMap.put("employee", new EmployeeAddOperationController());
        operationTypeControllerMap.put("position", new PositionAddOperationController());
        return operationTypeControllerMap;
    }
}

