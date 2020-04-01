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
        if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    return (departmentDao.showByIdTemplate(parseCommands[3])).toString();
                case "name":
                    return Department.listDepartmentsToString(departmentDao.showByNameTemplate(parseCommands[3]));
                case "chiefId":
                    return Department.listDepartmentsToString(departmentDao.showByChiefIdTemplate(parseCommands[3]));
                default:
                    return "\nПоле" + parseCommands[2] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        if (parseCommands.length == 4) {
            switch (parseCommands[2]) {
                case "id":
                    return (employeeDao.showByIdTemplate(parseCommands[3])).toString();
                case "fio":
                    return Employee.listEmployeesToString(employeeDao.showByNameTemplate(parseCommands[3]));
                case "idDepartment":
                    return (employeeDao.showByDepartmentTemplate(parseCommands[3])).toString();
                case "phoneNumber":
                    return Employee.listEmployeesToString(employeeDao.showByPhoneNumberTemplate(parseCommands[3]));
                case "seniority":
                    return Employee.listEmployeesToString(employeeDao.showBySeniorityTemplate(parseCommands[3]));
                case "idPosition":
                    return Employee.listEmployeesToString(employeeDao.showByPositionIdTemplate(parseCommands[3]));
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
                    return positionDao.showByIdTemplate(parseCommands[3]).toString();
                case "name":
                    return Position.listPositionsToString(positionDao.showByNameTemplate(parseCommands[3]));
                case "salary":
                    return Position.listPositionsToString(positionDao.showBySalaryTemplate(parseCommands[3]));
                default:
                    return "\nПоле" + parseCommands[2] + " не существует";
            }
        } else {
            return "\nНедостаточно/много аргументов";
        }
    }
}
