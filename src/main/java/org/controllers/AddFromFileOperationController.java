package org.controllers;

import org.controllers.departmentOperations.DepartmentAddFromFileOperationController;
import org.controllers.employeeOperations.EmployeeAddFromFileOperationController;
import org.controllers.positionOperations.PositionAddFromFileOperationController;

import java.util.HashMap;
import java.util.Map;

public class AddFromFileOperationController implements OperationTypeController {
    // add from file/department/cite
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
        operationTypeControllerMap.put("department", new DepartmentAddFromFileOperationController());
        operationTypeControllerMap.put("employee", new EmployeeAddFromFileOperationController());
        operationTypeControllerMap.put("position", new PositionAddFromFileOperationController());
        return operationTypeControllerMap;
    }
}
