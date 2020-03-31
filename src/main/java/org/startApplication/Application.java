package org.startApplication;

import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
       // ApplicationFacade appFacade = new ApplicationFacade();
       // appFacade.startApplication(args);
        // employee
        List<Employee> lst = new ArrayList<>();
        lst.add(new Employee(4, "Валентин", 1, "378543", 1,2));
        lst.add(new Employee(5, "Валя", 1, "379543", 1,2));
       XmlUtilsDataUpdater.updateEmployees(lst);
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees();
        // department
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "hrs", 5));
        departments.add(new Department(3, "he", 4));
        XmlUtilsDataUpdater.updateDepartments(departments);
        departments = XmlUtilsDataExtractor.extractDepartments();
        // position
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(1, "senior", 123.500));
        positions.add(new Position(2, "middle", 70.800));
        XmlUtilsDataUpdater.updatePositions(positions);
        positions = XmlUtilsDataExtractor.extractPositions();

        DepartmentDao departmentDao = new DepartmentDaoImpl();
        List<Department> dep = departmentDao.showAll();
        departmentDao.addDepartment("this", 3);

        EmployeeDao empDao = new EmployeeDaoImpl();
        List<Employee> employees1 = empDao.showAll();

        PositionDao posDao  = new PositionDaoImpl();
        List<Position> poslst = posDao.showAll();
    }
}
