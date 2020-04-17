package org.controllers;

import org.controllers.departmentOperations.DepartmentRemoveOperationController;
import org.controllers.employeeOperations.EmployeeRemoveOperationController;
import org.controllers.positionOperations.PositionRemoveOperationController;

import java.util.HashMap;
import java.util.Map;

public class RemoveOperationController implements OperationTypeController {
    // remove/department/all
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
        operationTypeControllerMap.put("department", new DepartmentRemoveOperationController());
        operationTypeControllerMap.put("employee", new EmployeeRemoveOperationController());
        operationTypeControllerMap.put("position", new PositionRemoveOperationController());
        return operationTypeControllerMap;
    }

}
