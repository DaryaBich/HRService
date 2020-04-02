package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

import java.util.List;

public class AddFromFileOperationController implements OperationTypeController {
    @Override
    // add from file/department/json/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\dep.xml
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        boolean equalXmlOutputFile = parseCommands[2].equals("xml");
        if (!equalXmlOutputFile && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[2];
        }
        List<Department> departments = Department.chooseFile(equalXmlOutputFile);
        if (departments == null) {
            return "\nНе удалось открыть файл для записи";
        }
        String filepath = parseCommands[3];
        if (filepath.substring(filepath.length() - 3).equals("xml") ||
                filepath.substring(filepath.length() - 4).equals("json")) {
            for (Department department:departments) {
                if (departmentDao.addDepartment(filepath.substring(filepath.length() - 3).equals("xml"),
                        department.getName(), department.getChiefId())) {
                    added.append(department.getId());
                } else {
                    notAdded.append(department.getId());
                }

            }
            return added.toString() + "\n" + notAdded.toString();
        }  else {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[3];
        }
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        boolean equalXmlOutputFile = parseCommands[2].equals("xml");
        if (!equalXmlOutputFile && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[2];
        }
        List<Employee> employees = Employee.chooseFile(equalXmlOutputFile);
        if (employees == null) {
            return "\nНе удалось открыть файл для записи";
        }
        String filepath = parseCommands[3];
        if (filepath.substring(filepath.length() - 3).equals("xml") ||
                filepath.substring(filepath.length() - 4).equals("json")) {
            for (Employee employee:employees) {
                if (employeeDao.addEmployee(filepath.substring(filepath.length() - 3).equals("xml"), employee.getFIO(),
                        employee.getIdDepartment(), employee.getPhoneNumber(), employee.getSeniority(),
                        employee.getIdPosition())) {
                    added.append(employee.getId());
                } else {
                    notAdded.append(employee.getId());
                }

            }
            return added.toString() + "\n" + notAdded.toString();
        }  else {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[3];
        }
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        boolean equalXmlOutputFile = parseCommands[2].equals("xml");
        if (!equalXmlOutputFile && !parseCommands[2].equals("json")) {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[2];
        }
        List<Position> positions = Position.chooseFile(equalXmlOutputFile);
        if (positions == null) {
            return "\nНе удалось открыть файл для записи";
        }
        String filepath = parseCommands[3];
        if (filepath.substring(filepath.length() - 3).equals("xml") ||
                filepath.substring(filepath.length() - 4).equals("json")) {
            for (Position position : positions) {
                if (positionDao.addPosition(filepath.substring(filepath.length() - 3).equals("xml"),
                        position.getName(), position.getSalary())) {
                    added.append(position.getId());
                } else {
                    notAdded.append(position.getId());
                }

            }
            return added.toString() + "\n" + notAdded.toString();
        }  else {
            return "\nТакой тип файлов не поддерживается: " + parseCommands[3];
        }
    }

}
