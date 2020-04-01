package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;

public class UpdateOperationController implements OperationTypeController {

    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        if (parseCommands[2].equals("all")) {
            return departmentDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return departmentDao.updateID(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return departmentDao.updateName(parseCommands[3]);
                case "chiefId":
                    try {
                        return departmentDao.updateChiefId(Integer.parseInt(parseCommands[3]));
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

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        if (parseCommands[2].equals("all")) {
            return employeeDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return employeeDao.updateId(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return employeeDao.updateName(parseCommands[3]);
                case "idDepartment":
                    try {
                        return employeeDao.updateDepartment(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return employeeDao.updatePhoneNumber(parseCommands[3]);
                case "seniority":
                    try {
                        return employeeDao.updateSeniority(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return employeeDao.updatePositionId(Integer.parseInt(parseCommands[3]));
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

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        if (parseCommands[2].equals("all")) {
            return positionDao.updateAll();
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return positionDao.updateId(Integer.parseInt(parseCommands[3]));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return positionDao.updateName(parseCommands[3]);
                case "salary":
                    try {
                        return positionDao.updateSalary(Double.parseDouble(parseCommands[3]));
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
