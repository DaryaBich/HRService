package org.controllers;

import org.Application;
import org.ApplicationContext;
import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.JsonUtilsDataExtractor;
import org.utils.XmlUtilsDataExtractor;

import java.util.List;

public class AddFromFileOperationController implements OperationTypeController {
    // add from file/department/cite
    @Override
    public String execute(String[] parseCommands, DepartmentDao departmentDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Department> departments = ApplicationContext.getDataAccessor().getProperties().getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractDepartments(parseCommands[2]) :
                JsonUtilsDataExtractor.extractDepartments(parseCommands[2]);
        for (Department department : departments) {
            if (departmentDao.addDepartment(department.getName(), department.getChiefId())) {
                added.append(department.getId());
            } else {
                notAdded.append(department.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }

    @Override
    public String execute(String[] parseCommands, EmployeeDao employeeDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Employee> employees = ApplicationContext.getDataAccessor().getProperties().getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractEmployees(parseCommands[2]) :
                JsonUtilsDataExtractor.extractEmployees(parseCommands[2]);
        for (Employee employee : employees) {
            if (employeeDao.addEmployee(employee.getFIO(), employee.getIdDepartment(), employee.getPhoneNumber(),
                    employee.getSeniority(), employee.getIdPosition())) {
                added.append(employee.getId());
            } else {
                notAdded.append(employee.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }

    @Override
    public String execute(String[] parseCommands, PositionDao positionDao) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Position> positions = ApplicationContext.getDataAccessor().getProperties().getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractPositions(parseCommands[2]) :
                JsonUtilsDataExtractor.extractPositions(parseCommands[2]);
        for (Position position : positions) {
            if (positionDao.addPosition(position.getName(), position.getSalary())) {
                added.append(position.getId());
            } else {
                notAdded.append(position.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }

}
