package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class DepartmentUpdateOperationController implements OperationTypeController
{
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return ApplicationContext.departmentDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return ApplicationContext.departmentDao.updateID(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return ApplicationContext.departmentDao.updateName(parseCommands[3]);
                case "chiefId":
                    try {
                        return ApplicationContext.departmentDao.updateChiefId(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                default:
                    return "\nПоле" + parseCommands[2] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
