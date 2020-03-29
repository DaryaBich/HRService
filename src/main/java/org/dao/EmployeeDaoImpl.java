package org.dao;

import org.entities.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

private List<Employee> employees;
public int getLength(){
    return employees.size();
}
    @Override
    public List<Employee> addEmployee(String FIO, int idDepartment,
                                      String phoneNumber, int seniority, int position) {
        return null;
    }

    @Override
    public List<Employee> removeAll() {
        return null;
    }

    @Override
    public List<Employee> removeById(int id) {
        return null;
    }

    @Override
    public List<Employee> removeByName(String Name) {
        return null;
    }

    @Override
    public List<Employee> removeByDepartmentId(int idDepartment) {
        return null;
    }

    @Override
    public List<Employee> removeByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public List<Employee> removeBySeniority(int seniority) {
        return null;
    }

    @Override
    public List<Employee> removeByPositionId(int positionId) {
        return null;
    }

    @Override
    public List<Employee> updateAll() {
        return null;
    }

    @Override
    public List<Employee> updateId(int id, Employee... employees) {
        return null;
    }

    @Override
    public List<Employee> updateName(String FIO, Employee... employees) {
        return null;
    }

    @Override
    public List<Employee> updateDepartment(int idDepartment, Employee... employees) {
        return null;
    }

    @Override
    public List<Employee> updatePhoneNumber(String phoneNumber, Employee... employees) {
        return null;
    }

    @Override
    public List<Employee> updateSeniority(int seniority, Employee... employees) {
        return null;
    }

    @Override
    public List<Employee> updatePositionId(int positionId, Employee... employees) {
        return null;
    }

    @Override
    public Employee showById(int id) {
        return null;
    }

    @Override
    public List<Employee> showAll() {
        return null;
    }

    @Override
    public List<Employee> showByName(String FIO) {
        return null;
    }

    @Override
    public List<Employee> showByDepartment(int idDepartment) {
        return null;
    }

    @Override
    public List<Employee> showByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public List<Employee> showBySeniority(int seniority) {
        return null;
    }

    @Override
    public List<Employee> showByPositionId(int positionId) {
        return null;
    }

    @Override
    public Employee getByIdTemplate(String id) {
        return null;
    }

    @Override
    public List<Employee> getAllTemplate() {
        return null;
    }

    @Override
    public List<Employee> getByNameTemplate(String FIO) {
        return null;
    }

    @Override
    public List<Employee> getByDepartmentTemplate(String idDepartment) {
        return null;
    }

    @Override
    public List<Employee> getByPhoneNumberTemplate(String phoneNumber) {
        return null;
    }

    @Override
    public List<Employee> getBySeniorityTemplate(String seniority) {
        return null;
    }

    @Override
    public List<Employee> getByPositionIdTemplate(String positionId) {
        return null;
    }
}
