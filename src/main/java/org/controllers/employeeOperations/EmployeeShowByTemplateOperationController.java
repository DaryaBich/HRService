package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class EmployeeShowByTemplateOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    return (ApplicationContext.employeeDao.showByIdTemplate(parseCommands[3])).toString();
                case "fio":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showByNameTemplate(parseCommands[3]));
                case "idDepartment":
                    return (ApplicationContext.employeeDao.showByDepartmentTemplate(parseCommands[3])).toString();
                case "phoneNumber":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showByPhoneNumberTemplate(parseCommands[3]));
                case "seniority":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showBySeniorityTemplate(parseCommands[3]));
                case "idPosition":
                    return EntityOperationUtils.listEmployeesToString(
                            ApplicationContext.employeeDao.showByPositionIdTemplate(parseCommands[3]));
                default:
                    return "\nПоле" + parseCommands[2] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
