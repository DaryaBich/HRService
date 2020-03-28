package org.dao;

import org.entities.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
private List<Employee> employees;
    // add
    public List<Employee> addEmployee(Employee employee) {
        return null;
    }
    //remove

    public List<Employee> removeAll() {
        return null;
    }

    public List<Employee> removeById(int id) {
        return null;
    }

    public List<Employee> removeByName(String Name) {
        return null;
    }

    public List<Employee> removeByDepartmentId(int idDepartment) {
        return null;
    }

    public List<Employee> removeByPhoneNumber(String phoneNumber) {
        return null;
    }

    public List<Employee> removeBySeniority(int seniority) {
        return null;
    }

    public List<Employee> removeByPositionId(int positionId) {
        return null;
    }
    //update

    public List<Employee> updateId(int id, Employee... employees) {
        return null;
    }

    public List<Employee> updateName(String FIO, Employee... employees) {
        return null;
    }

    public List<Employee> updateDepartment(int idDepartment, Employee... employees) {
        return null;
    }

    public List<Employee> updatePhoneNumber(String phoneNumber, Employee... employees) {
        return null;
    }

    public List<Employee> updateSeniority(int seniority, Employee... employees) {
        return null;
    }

    public List<Employee> updatePositionId(int positionId, Employee... employees) {
        return null;
    }
    //show

    public Employee showById(int id) {
        return null;
    }

    public List<Employee> showAll() {

        return employees;
    }

    public List<Employee> showByName(String FIO) {
        return null;
    }

    public List<Employee> showByDepartment(int idDepartment) {
        return null;
    }

    public List<Employee> showByPhoneNumber(String phoneNumber) {
        return null;
    }

    public List<Employee> showBySeniority(int seniority) {
        return null;
    }

    public List<Employee> showByPositionId(int positionId) {
        return null;
    }
    // get template

    public Employee getByIdTemplate(String id) {
        return null;
    }

    public List<Employee> getAllTemplate() {
        return null;
    }

    public List<Employee> getByNameTemplate(String FIO) {
        return null;
    }

    public List<Employee> getByDepartmentTemplate(String idDepartment) {
        return null;
    }

    public List<Employee> getByPhoneNumberTemplate(String phoneNumber) {
        return null;
    }

    public List<Employee> getBySeniorityTemplate(String seniority) {
        return null;
    }

    public List<Employee> getByPositionIdTemplate(String positionId) {
        return null;
    }
}
