package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class DepartmentShowByTemplateOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    return (ApplicationContext.departmentDao.showByIdTemplate(parseCommands[3])).toString();
                case "name":
                    return EntityOperationUtils.listDepartmentsToString(
                            ApplicationContext.departmentDao.showByNameTemplate(parseCommands[3]));
                case "chiefId":
                    return EntityOperationUtils.listDepartmentsToString(
                            ApplicationContext.departmentDao.showByChiefIdTemplate(parseCommands[3]));
                default:
                    return "\nПоле" + parseCommands[3] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
