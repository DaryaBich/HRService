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
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[3].equals("all")) {
            departmentDao.removeAll(equalFileType);
            return "\nВсе department удалены";
        } else if (parseCommands.length == 5) {
            String result, department = "\nDepartment ";
            switch (parseCommands[3]) {
                case "id":
                    try {
                        result = departmentDao.removeById(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удален" : " не найден";
                        return department + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = departmentDao.removeByName(equalFileType, parseCommands[4]) ? " удалены" : " не найдены";
                    return department + result;
                case "chiefId":
                    try {
                        result = departmentDao.removeByChiefId(equalFileType, Integer.parseInt(parseCommands[4])) ?
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
        boolean equalFileType = parseCommands[2].equals("xml");
        if (!equalFileType && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается";
        }
        if (parseCommands[3].equals("all")) {
            employeeDao.removeAll(equalFileType);
            return "\nВсе employee удалены";
        } else if (parseCommands.length == 5) {
            String result, employee = "\nEmployee ";
            switch (parseCommands[3]) {
                case "id":
                    try {
                        result = employeeDao.removeById(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удален" : " не найден";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "fio":
                    result = employeeDao.removeByName(equalFileType, parseCommands[4]) ? " удалены" : " не найдены";
                    return employee + result;
                case "idDepartment":
                    try {
                        result = employeeDao.removeByDepartmentId(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "phoneNumber":
                    result = employeeDao.removeByPhoneNumber(equalFileType, parseCommands[4]) ? " удалены" : " не найдены";
                    return employee + result;
                case "seniority":
                    try {
                        result = employeeDao.removeBySeniority(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удалены" : " не найдены";
                        return employee + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "idPosition":
                    try {
                        result = employeeDao.removeByPositionId(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удалены" : " не найдены";
                        return employee + result;
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
            positionDao.removeAll(equalFileType);
            return "\nВсе position удалены";
        } else if (parseCommands.length == 5) {
            String result, position = "\nPosition " + parseCommands[3];
            switch (parseCommands[3]) {
                case "id":
                    try {
                        result = positionDao.removeById(equalFileType, Integer.parseInt(parseCommands[4])) ?
                                " удаленa" : " не найденa";
                        return position + result;
                    } catch (NumberFormatException e) {
                        return "\nНеверное значение";
                    }
                case "name":
                    result = positionDao.removeByName(equalFileType, parseCommands[4]) ?
                            " удалены" : " не найдены";
                    return position + result;
                case "salary":
                    try {
                        result = positionDao.removeBySalary(equalFileType, Double.parseDouble(parseCommands[4])) ?
                                " удалены" : " не найдены";
                        return position + result;
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
