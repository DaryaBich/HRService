package org.controllers;

import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

public class ShowOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        if (parseCommands[2].equals("all")) {
            return Department.listDepartmentsToString(departmentDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (departmentDao.showById(Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return Department.listDepartmentsToString(departmentDao.showByName(parseCommands[3]));
                case "chiefId":
                    try {
                        return Department.listDepartmentsToString(departmentDao.showByChiefId
                                (Integer.parseInt(parseCommands[3])));
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
            return Employee.listEmployeesToString(employeeDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (employeeDao.showById(Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    return Employee.listEmployeesToString(employeeDao.showByName(parseCommands[3]));
                case "idDepartment":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showByDepartment
                                (Integer.parseInt(parseCommands[3])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    return Employee.listEmployeesToString(employeeDao.showByPhoneNumber(parseCommands[3]));
                case "seniority":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showBySeniority
                                (Integer.parseInt(parseCommands[3])));
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        return Employee.listEmployeesToString(employeeDao.showByPositionId
                                (Integer.parseInt(parseCommands[3])));
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
            return Position.listPositionsToString(positionDao.showAll());
        } else if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    try {
                        return (positionDao.showById(Integer.parseInt(parseCommands[3]))).toString();
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    return Position.listPositionsToString(positionDao.showByName(parseCommands[3]));
                case "salary":
                    try {
                        return Position.listPositionsToString(positionDao.showBySalary
                                (Double.parseDouble(parseCommands[3])));
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
