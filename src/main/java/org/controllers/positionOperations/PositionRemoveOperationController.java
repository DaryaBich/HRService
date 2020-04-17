package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class PositionRemoveOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            ApplicationContext.positionDao.removeAll();
            return "\nВсе position удалены";
        } else if (parseCommands.length == 4) {
            String result, position = "\nPosition " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result = ApplicationContext.positionDao.removeById(Integer.parseInt(parseCommands[3])) ?
                                " удаленa" : " не найденa";
                        return position + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = ApplicationContext.positionDao.removeByName(parseCommands[3]) ? " удалены" : " не найдены";
                    return position + result;
                case "salary":
                    try {
                        result = ApplicationContext.positionDao.removeBySalary(Double.parseDouble(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return position + result;
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
