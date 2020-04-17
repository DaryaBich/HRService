package org.controllers;

import org.controllers.departmentOperations.DepartmentUpdateOperationController;
import org.controllers.employeeOperations.EmployeeUpdateOperationController;
import org.controllers.positionOperations.PositionUpdateOperationController;

import java.util.HashMap;
import java.util.Map;

public class UpdateOperationController implements OperationTypeController {
// update/department/id/3
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
        operationTypeControllerMap.put("department", new DepartmentUpdateOperationController());
        operationTypeControllerMap.put("employee", new EmployeeUpdateOperationController());
        operationTypeControllerMap.put("position", new PositionUpdateOperationController());
        return operationTypeControllerMap;
    }
}
