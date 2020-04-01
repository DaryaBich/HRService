package org.controllers;

import org.dao.*;

public class AddOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        if (parseCommands.length == 6) {
            String name = "", chiefId = "";
            if (parseCommands[2].equalsIgnoreCase("name")) {
                name = parseCommands[3];
                chiefId = parseCommands[5];
            } else {
                name = parseCommands[5];
                chiefId = parseCommands[3];
            }
            try {
                if (departmentDao.addDepartment(name, Integer.parseInt(chiefId))) {
                    return "\nDepartment успешно добавлен";
                } else {
                    return "\nУже существует";
                }
            } catch (NumberFormatException e) {
                return "\nЗначение в неверном формате";
            }
        } else {
            return "\nНедостаточно аргументов";
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        if (parseCommands.length == 12) {
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
                    case "position":
                        position = parseCommands[i + 1];
                        break;
                    default:
                        return "\nПоле " + parseCommands[i] + " отсутствует";
                }
            }
            try {
                if (employeeDao.addEmployee(fio, Integer.parseInt(idDeparment),
                        phoneNumber, Integer.parseInt(seniority), Integer.parseInt(position))) {
                    return "\nEmployee успешно добавлен";
                } else {
                    return "\nУже существует";
                }
            } catch (NumberFormatException e) {
                return "\nЗначение в неверном формате";
            }
        } else {
            return "\nНедостаточно аргументов";
        }
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        if (parseCommands.length == 6) {
            String name = "", salary = "";
            if (parseCommands[2].equalsIgnoreCase("name")) {
                name = parseCommands[3];
                salary = parseCommands[5];
            } else {
                name = parseCommands[5];
                salary = parseCommands[3];
            }
            try {
                if (positionDao.addPosition(name, Double.parseDouble(salary))) {
                    return "\nPosition успешно добавлен";
                } else {
                    return "\nУже существует";
                }
            } catch (NumberFormatException e) {
                return "\nЗначение в неверном формате";
            }
        } else {
            return "\nНедостаточно аргументов";
        }
    }
}

