package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

public class ShowByTemplateOperationController implements OperationTypeController {

    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    return (departmentDao.showByIdTemplate(equalFileType, parseCommands[4])).toString();
                case "name":
                    return Department.listDepartmentsToString(departmentDao.showByNameTemplate(equalFileType,
                            parseCommands[4]));
                case "chiefId":
                    return Department.listDepartmentsToString(departmentDao.showByChiefIdTemplate(equalFileType,
                            parseCommands[4]));
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
        if (parseCommands.length == 5) {
            switch (parseCommands[3]) {
                case "id":
                    return (employeeDao.showByIdTemplate(equalFileType, parseCommands[4])).toString();
                case "fio":
                    return Employee.listEmployeesToString(employeeDao.showByNameTemplate(equalFileType,
                            parseCommands[4]));
                case "idDepartment":
                    return (employeeDao.showByDepartmentTemplate(equalFileType, parseCommands[4])).toString();
                case "phoneNumber":
                    return Employee.listEmployeesToString(employeeDao.showByPhoneNumberTemplate(equalFileType,
                            parseCommands[4]));
                case "seniority":
                    return Employee.listEmployeesToString(employeeDao.showBySeniorityTemplate(equalFileType,
                            parseCommands[4]));
                case "idPosition":
                    return Employee.listEmployeesToString(employeeDao.showByPositionIdTemplate(equalFileType,
                            parseCommands[4]));
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
                    return positionDao.showByIdTemplate(equalFileType, parseCommands[4]).toString();
                case "name":
                    return Position.listPositionsToString(positionDao.showByNameTemplate(equalFileType,
                            parseCommands[4]));
                case "salary":
                    return Position.listPositionsToString(positionDao.showBySalaryTemplate(equalFileType,
                            parseCommands[4]));
                default:
                    return "\nПоле" + parseCommands[3] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
