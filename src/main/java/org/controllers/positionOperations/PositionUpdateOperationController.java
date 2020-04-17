package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class PositionUpdateOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return ApplicationContext.positionDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return ApplicationContext.positionDao.updateId(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return ApplicationContext.positionDao.updateName(parseCommands[3]);
                case "salary":
                    try {
                        return ApplicationContext.positionDao.updateSalary(Double.parseDouble(parseCommands[3]));
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
