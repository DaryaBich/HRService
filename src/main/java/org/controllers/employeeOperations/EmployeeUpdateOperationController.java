package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class EmployeeUpdateOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return ApplicationContext.employeeDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return ApplicationContext.employeeDao.updateId(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return ApplicationContext.employeeDao.updateName(parseCommands[3]);
                case "idDepartment":
                    try {
                        return ApplicationContext.employeeDao.updateDepartment(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return ApplicationContext.employeeDao.updatePhoneNumber(parseCommands[3]);
                case "seniority":
                    try {
                        return ApplicationContext.employeeDao.updateSeniority(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return ApplicationContext.employeeDao.updatePositionId(Integer.parseInt(parseCommands[3]));
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
