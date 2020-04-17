package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class EmployeeRemoveOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            ApplicationContext.employeeDao.removeAll();
            return "\nВсе employee удалены";
        } else if (parseCommands.length == 4) {
            String result, employee = "\nEmployee " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result = ApplicationContext.employeeDao.removeById(Integer.parseInt(parseCommands[3])) ?
                                " удален" : " не найден";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    result = ApplicationContext.employeeDao.removeByName(parseCommands[3]) ? " удалены" : " не найдены";
                    return employee + result;
                case "idDepartment":
                    try {
                        result = ApplicationContext.employeeDao.removeByDepartmentId(Integer.parseInt
                                (parseCommands[3])) ? " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    result = ApplicationContext.employeeDao.removeByPhoneNumber(parseCommands[3]) ? " удалены" :
                            " не найдены";
                    return employee + result;
                case "seniority":
                    try {
                        result = ApplicationContext.employeeDao.removeBySeniority(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        result = ApplicationContext.employeeDao.removeByPositionId(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return employee + result;
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
