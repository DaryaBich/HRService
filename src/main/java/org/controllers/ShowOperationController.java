package org.controllers;

import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

public class ShowOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[3].equals("all")) {
            return Department.listDepartmentsToString(departmentDao.showAll(equalFileType));
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return (departmentDao.showById(equalFileType, Integer.parseInt(parseCommands[4]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return Department.listDepartmentsToString(departmentDao.showByName(equalFileType,
                            parseCommands[4]));
                case "chiefId":
                    try {
                        return Department.listDepartmentsToString(departmentDao.showByChiefId(equalFileType,
                                Integer.parseInt(parseCommands[4])));
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
            return Employee.listEmployeesToString(employeeDao.showAll(equalFileType));
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return (employeeDao.showById(equalFileType, Integer.parseInt(parseCommands[4]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return Employee.listEmployeesToString(employeeDao.showByName(equalFileType, parseCommands[4]));
                case "idDepartment":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showByDepartment(equalFileType,
                                Integer.parseInt(parseCommands[4])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return Employee.listEmployeesToString(employeeDao.showByPhoneNumber(equalFileType,
                            parseCommands[4]));
                case "seniority":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showBySeniority(equalFileType,
                                Integer.parseInt(parseCommands[4])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showByPositionId(equalFileType,
                                Integer.parseInt(parseCommands[4])));
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
            return Position.listPositionsToString(positionDao.showAll(equalFileType));
        } else if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    try {
                        return (positionDao.showById(equalFileType, Integer.parseInt(parseCommands[4]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return Position.listPositionsToString(positionDao.showByName(equalFileType, parseCommands[4]));
                case "salary":
                    try {
                        return Position.listPositionsToString(positionDao.showBySalary(equalFileType,
                                Double.parseDouble(parseCommands[4])));
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
