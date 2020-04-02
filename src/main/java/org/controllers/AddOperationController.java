package org.controllers;

import org.dao.*;

public class AddOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands.length != 7) {
            return "\nНедостаточно аргументов";
        }
        String name = "", chiefId = "";
        if (parseCommands[3].equalsIgnoreCase("name")) {
            name = parseCommands[4];
            chiefId = parseCommands[6];
        } else {
            name = parseCommands[6];
            chiefId = parseCommands[4];
        }
        try {
            if (departmentDao.addDepartment(equalFileType, name, Integer.parseInt(chiefId))) {
                return "\nDepartment успешно добавлен";
            } else {
                return "\nDepartment уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands.length != 13) {
            return "\nНедостаточно аргументов";
        }
        String fio = "", idDeparment = "", phoneNumber = "", seniority = "", position = "";
        for (int i = 3; i < parseCommands.length; i += 2) {
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
            if (employeeDao.addEmployee(equalFileType, fio, Integer.parseInt(idDeparment),
                    phoneNumber, Integer.parseInt(seniority), Integer.parseInt(position))) {
                return "\nEmployee успешно добавлен";
            } else {
                return "\nEmployee уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands.length != 7) {
            return "\nНедостаточно аргументов";
        }
        String name = "", salary = "";
        if (parseCommands[3].equalsIgnoreCase("name")) {
            name = parseCommands[4];
            salary = parseCommands[6];
        } else {
            name = parseCommands[6];
            salary = parseCommands[4];
        }
        try {
            if (positionDao.addPosition(equalFileType, name, Double.parseDouble(salary))) {
                return "\nPosition успешно добавлен";
            } else {
                return "\nPosition уже существует";
            }
        } catch (NumberFormatException e) {
            return "\nЗначение в неверном формате";
        }
    }
}

