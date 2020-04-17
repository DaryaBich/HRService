package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class PositionAddOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length != 6) {
            return "\nНедостаточно аргументов";
        }
        String name = "", salary = "";
        if (parseCommands[2].equalsIgnoreCase("name")) {
            name = parseCommands[3];
            salary = parseCommands[5];
        } else {
            name = parseCommands[5];
            salary = parseCommands[3];
        }
        try {
            if (ApplicationContext.positionDao.addPosition(name, Double.parseDouble(salary))) {
                return "\nPosition успешно добавлен";
            } else {
                return "\nPosition уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }
}
