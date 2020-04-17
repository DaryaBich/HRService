package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class DepartmentAddOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length != 6) {
            return "\nНедостаточно аргументов";
        }
        String name = "", chiefId = "";
        if (parseCommands[2].equalsIgnoreCase("name")) {
            name = parseCommands[3];
            chiefId = parseCommands[5];
        } else {
            name = parseCommands[5];
            chiefId = parseCommands[3];
        }
        try {
            if (ApplicationContext.departmentDao.addDepartment(name, Integer.parseInt(chiefId))) {
                return "\nDepartment успешно добавлен";
            } else {
                return "\nDepartment уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }
}
