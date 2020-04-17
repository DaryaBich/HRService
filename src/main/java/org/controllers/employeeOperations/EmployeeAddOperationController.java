package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;

public class EmployeeAddOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        if (parseCommands.length != 12) {
            return "\nНедостаточно аргументов";
        }
        String fio = "", idDeparment = "", phoneNumber = "", seniority = "", position = "";
        for (int i = 2; i < parseCommands.length; i += 2) {
            switch (parseCommands[i]) {
                case "fio":
                    fio = parseCommands[i + 1];
                    break;
                case "idDepartment":
                    idDeparment = parseCommands[i + 1];
                    break;
                case "phoneNumber":
                    phoneNumber = parseCommands[i + 1];
                    break;
                case "seniority":
                    seniority = parseCommands[i + 1];
                    break;
                case "idPosition":
                    position = parseCommands[i + 1];
                    break;
                default:
                    return "\nПоле " + parseCommands[i] + " отсутствует";
            }
        }
        try {
            if (ApplicationContext.employeeDao.addEmployee(fio, Integer.parseInt(idDeparment), phoneNumber,
                    Integer.parseInt(seniority), Integer.parseInt(position))) {
                return "\nEmployee успешно добавлен";
            } else {
                return "\nEmployee уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }
}
