package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class DepartmentShowOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return EntityOperationUtils.listDepartmentsToString(ApplicationContext.departmentDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (ApplicationContext.departmentDao.showById(
                                Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return EntityOperationUtils.listDepartmentsToString(
                            ApplicationContext.departmentDao.showByName(parseCommands[3]));
                case "chiefId":
                    try {
                        return EntityOperationUtils.listDepartmentsToString(
                                ApplicationContext.departmentDao.showByChiefId(
                                Integer.parseInt(parseCommands[3])));
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
