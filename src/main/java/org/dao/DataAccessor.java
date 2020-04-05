package org.dao;

import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataAccessor {
    private final Properties properties = new Properties();

    public DataAccessor() {
        try {
            properties.load(new FileInputStream(new File("DataSource.properties")));
        } catch (IOException e) {
            System.out.println("no file");
        }

    }

    public Properties getProperties() {
        return properties;
    }

    public List<Department> extractDepartments() {
        List<Department> departments;
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")) {
            departments = XmlUtilsDataExtractor.extractDepartments(properties.getProperty("department.path") +
                    suffix);
        } else {
            departments = JsonUtilsDataExtractor.extractDepartments(properties.getProperty("department.path") +
                    suffix);
        }
        return departments;
    }

    public void updateDepartments(List<Department> departments) {
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")) {
            XmlUtilsDataUpdater.updateDepartments(departments, properties.getProperty("department.path") +
                    suffix);
        } else {
            JsonUtilsDataUpdater.updateDepartments(departments, properties.getProperty("department.path") +
                    suffix);
        }
    }

    public List<Employee> extractEmployees() {
        List<Employee> employees;
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")) {
            employees = XmlUtilsDataExtractor.extractEmployees(properties.getProperty("employee.path") +
                    suffix);
        } else{
            employees = JsonUtilsDataExtractor.extractEmployees(properties.getProperty("employee.path") +
                    suffix);
        }
        return employees;
    }
    public void updateEmployees(List<Employee> employees){
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")){
            XmlUtilsDataUpdater.updateEmployees(employees, properties.getProperty("employee.path") + suffix);
        } else{
            JsonUtilsDataUpdater.updateEmployees(employees, properties.getProperty("employee.path") + suffix);
        }
    }
    public List<Position> extractPositions(){
        List<Position> positions;
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")){
            positions = XmlUtilsDataExtractor.extractPositions(properties.getProperty("position.path") +
                    suffix);
        } else{
            positions = JsonUtilsDataExtractor.extractPositions(properties.getProperty("position.path") +
                    suffix);
        }
        return positions;
    }
    public void updatePositions(List<Position> positions){
        String suffix = properties.getProperty("suffix");
        if (suffix.equals("xml")){
            XmlUtilsDataUpdater.updatePositions(positions, properties.getProperty("position.path") + suffix);
        } else{
            JsonUtilsDataUpdater.updatePositions(positions, properties.getProperty("position.path") + suffix);
        }
    }
}
