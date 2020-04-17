package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class EmployeeShowOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return EntityOperationUtils.listEmployeesToString(ApplicationContext.employeeDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (ApplicationContext.employeeDao.showById(Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showByName(parseCommands[3]));
                case "idDepartment":
                    try {
                        return EntityOperationUtils.listEmployeesToString(
                                ApplicationContext.employeeDao.showByDepartment(Integer.parseInt(parseCommands[3])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showByPhoneNumber(parseCommands[3]));
                case "seniority":
                    try {
                        return EntityOperationUtils.listEmployeesToString(
                                ApplicationContext.employeeDao.showBySeniority(
                                Integer.parseInt(parseCommands[3])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return EntityOperationUtils.listEmployeesToString(
                                ApplicationContext.employeeDao.showByPositionId(Integer.parseInt(parseCommands[3])));
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
