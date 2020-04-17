package org.controllers;

import org.controllers.departmentOperations.DepartmentShowByTemplateOperationController;
import org.controllers.employeeOperations.EmployeeShowByTemplateOperationController;
import org.controllers.positionOperations.PositionShowByTemplateOperationController;

import java.util.HashMap;
import java.util.Map;

public class ShowByTemplateOperationController implements OperationTypeController {
// show by template/department/id/*5
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
        operationTypeControllerMap.put("department", new DepartmentShowByTemplateOperationController());
        operationTypeControllerMap.put("employee", new EmployeeShowByTemplateOperationController());
        operationTypeControllerMap.put("position", new PositionShowByTemplateOperationController());
        return operationTypeControllerMap;
    }
}
