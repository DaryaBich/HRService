package org.dao;

import org.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    // add
    List<Employee> addEmployee(String FIO, int idDepartment,
                               String phoneNumber, int seniority, int position);

    // remove
    List<Employee> removeAll();

    List<Employee> removeById(int id);

    List<Employee> removeByName(String Name);

    List<Employee> removeByDepartmentId(int idDepartment);

    List<Employee> removeByPhoneNumber(String phoneNumber);

    List<Employee> removeBySeniority(int seniority);

    List<Employee> removeByPositionId(int positionId);

    // update
    List<Employee> updateAll ();
    List<Employee> updateId(int id, Employee... employees);

    List<Employee> updateName(String FIO, Employee... employees);

    List<Employee> updateDepartment(int idDepartment, Employee... employees);

    List<Employee> updatePhoneNumber(String phoneNumber, Employee... employees);

    List<Employee> updateSeniority(int seniority, Employee... employees);

    List<Employee> updatePositionId(int positionId, Employee... employees);

    // show
    Employee showById(int id);

    List<Employee> showAll();

    List<Employee> showByName(String FIO);

    List<Employee> showByDepartment(int idDepartment);

    List<Employee> showByPhoneNumber(String phoneNumber);

    List<Employee> showBySeniority(int seniority);

    List<Employee> showByPositionId(int positionId);

    // get by template
    Employee getByIdTemplate(String id);

    List<Employee> getAllTemplate();

    List<Employee> getByNameTemplate(String FIO);

    List<Employee> getByDepartmentTemplate(String idDepartment);

    List<Employee> getByPhoneNumberTemplate(String phoneNumber);

    List<Employee> getBySeniorityTemplate(String seniority);

    List<Employee> getByPositionIdTemplate(String positionId);
}
