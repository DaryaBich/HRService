package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;

public class UpdateOperationController implements OperationTypeController {

    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[2].equals("all")) {
            return departmentDao.updateAll(equalFileType);
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return departmentDao.updateID(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return departmentDao.updateName(equalFileType, parseCommands[4]);
                case "chiefId":
                    try {
                        return departmentDao.updateChiefId(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                default:
                    return "\nПоле" + parseCommands[3] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[3].equals("all")) {
            return employeeDao.updateAll(equalFileType);
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return employeeDao.updateId(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return employeeDao.updateName(equalFileType, parseCommands[4]);
                case "idDepartment":
                    try {
                        return employeeDao.updateDepartment(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return employeeDao.updatePhoneNumber(equalFileType, parseCommands[4]);
                case "seniority":
                    try {
                        return employeeDao.updateSeniority(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return employeeDao.updatePositionId(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                default:
                    return "\nПоле" + parseCommands[3] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[3].equals("all")) {
            return positionDao.updateAll(equalFileType);
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return positionDao.updateId(equalFileType, Integer.parseInt(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return positionDao.updateName(equalFileType, parseCommands[4]);
                case "salary":
                    try {
                        return positionDao.updateSalary(equalFileType, Double.parseDouble(parseCommands[4]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                default:
                    return "\nПоле" + parseCommands[3] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
