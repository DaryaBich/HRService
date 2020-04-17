package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.utils.EntityOperationUtils;

public class PositionShowByTemplateOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    return ApplicationContext.positionDao.showByIdTemplate(parseCommands[3]).toString();
                case "name":
                    return EntityOperationUtils.listPositionsToString(
                            ApplicationContext.positionDao.showByNameTemplate(parseCommands[3]));
                case "salary":
                    return EntityOperationUtils.listPositionsToString(
                            ApplicationContext.positionDao.showBySalaryTemplate(parseCommands[3]));
                default:
                    return "\nПоле" + parseCommands[2] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
