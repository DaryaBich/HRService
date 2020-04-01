package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

public class RemoveOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        if (parseCommands[2].equals("all")) {
            departmentDao.removeAll();
            return "\nВсе отделы удалены";
        } else if (parseCommands.length == 4) {
            String result, department = "\nDepartment " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result = departmentDao.removeById(Integer.parseInt(parseCommands[3])) ? " удален" : " не найден";
                        return department + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = departmentDao.removeByName(parseCommands[3]) ? " удалены" : " не найдены";
                    return department + result;
                case "chiefId":
                    try {
                        result = departmentDao.removeByChiefId(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return department + result;
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
            String result, employee = "\nEmployee " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result = employeeDao.removeById(Integer.parseInt(parseCommands[3])) ? " удален" : " не найден";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    result = employeeDao.removeByName(parseCommands[3]) ? " удалены" : " не найдены";
                    return employee + result;
                case "idDepartment":
                    try {
                        result = employeeDao.removeByDepartmentId(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    result = employeeDao.removeByPhoneNumber(parseCommands[3]) ? " удалены" : " не найдены";
                    return employee + result;
                case "seniority":
                    try {
                        result = employeeDao.removeBySeniority(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        result = employeeDao.removeByPositionId(Integer.parseInt(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return employee + result;
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
            String result, position = "\nPosition " + parseCommands[3];
            switch (parseCommands[2]) {
                case "id":
                    try {
                        result = positionDao.removeById(Integer.parseInt(parseCommands[3])) ?
                                " удаленa" : " не найденa";
                        return position + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = positionDao.removeByName(parseCommands[3]) ?
                            " удалены" : " не найдены";
                    return position + result;
                case "salary":
                    try {
                        result = positionDao.removeBySalary(Double.parseDouble(parseCommands[3])) ?
                                " удалены" : " не найдены";
                        return position + result;
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
