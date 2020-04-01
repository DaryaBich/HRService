package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.XmlUtilsDataExtractor;

import java.util.List;

public class AddFromFileOperationController implements OperationTypeController {
    @Override
    // add from file/department/xml/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\dep.xml
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        if (parseCommands[2].equals("xml")) {
            List<Department> departments = XmlUtilsDataExtractor.extractDepartments(parseCommands[3]);
            if (departments != null) {
                for (Department department : departments) {
                    if (departmentDao.addDepartment(department.getName(), department.getChiefId())) {
                        added.append(department.getId());
                    } else {
                        notAdded.append(department.getId());
                    }
                }
                return added.toString() + "\n" + notAdded.toString();
            } else {
                return "\nНе удалось открыть файл";
            }
        } else if (parseCommands[2].equals("json")) {
            return "";
        } else {
            return "\nТакой тип файлов не поддерживается";
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        if (parseCommands[2].equals("xml")) {
            List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(parseCommands[3]);
            if (employees != null) {
                for (Employee employee : employees) {
                    if (employeeDao.addEmployee(employee.getFIO(), employee.getIdDepartment(),
                            employee.getPhoneNumber(), employee.getSeniority(), employee.getIdPosition())) {
                        added.append(employee.getId());
                    } else {
                        notAdded.append(employee.getId());
                    }
                }
                return added.toString() + "\n" + notAdded.toString();
            } else {
                return "\nНе удалось открыть файл";
            }
        } else if (parseCommands[2].equals("json")) {
            return "";
        } else {
            return "\nТакой тип файлов не поддерживается";
        }
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        if (parseCommands[2].equals("xml")) {
            List<Position> positions = XmlUtilsDataExtractor.extractPositions(parseCommands[3]);
            if (positions != null) {
                for (Position position : positions) {
                    if (positionDao.addPosition(position.getName(), position.getSalary())) {
                        added.append(position.getId());
                    } else {
                        notAdded.append(position.getId());
                    }
                }
                return added.toString() + "\n" + notAdded.toString();
            } else {
                return "\nНе удалось открыть файл";
            }
        } else if (parseCommands[2].equals("json")) {
            return "";
        } else {
            return "\nТакой тип файлов не поддерживается";
        }
    }
}
