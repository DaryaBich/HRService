package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class DepartmentRemoveOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            ApplicationContext.departmentDao.removeAll();
            return "\nВсе department удалены";
        } else if (parseCommands.length == 4) {
            String result, department = "\nDepartment " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result =  ApplicationContext.departmentDao.removeById(Integer.parseInt(parseCommands[3])) ?
                                " удален" : " не найден";
                        return department + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = ApplicationContext.departmentDao.removeByName(parseCommands[3]) ? " удалены" :
                            " не найдены";
                    return department + result;
                case "chiefId":
                    try {
                        result = ApplicationContext.departmentDao.removeByChiefId(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return department + result;
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
