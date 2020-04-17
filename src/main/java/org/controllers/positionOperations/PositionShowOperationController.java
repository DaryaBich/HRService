package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class PositionShowOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands[2].equals("all")) {
            return EntityOperationUtils.listPositionsToString(ApplicationContext.positionDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (ApplicationContext.positionDao.showById(Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return EntityOperationUtils.listPositionsToString(
                            ApplicationContext.positionDao.showByName(parseCommands[3]));
                case "salary":
                    try {
                        return EntityOperationUtils.listPositionsToString(ApplicationContext.positionDao.showBySalary(
                                Double.parseDouble(parseCommands[3])));
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
