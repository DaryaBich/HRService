package org.dao;

import org.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    // add
    boolean addEmployee(String FIO, int idDepartment, String phoneNumber, int seniority, int position);

    // remove
    void removeAll();

    boolean removeById(int id);

    boolean removeByName(String Name);

    boolean removeByDepartmentId(int idDepartment);

    boolean removeByPhoneNumber(String phoneNumber);

    boolean removeBySeniority(int seniority);

    boolean removeByPositionId(int positionId);

    // update
    String updateAll();
    String updateId(int id);

    String updateName(String FIO);

    String updateDepartment(int idDepartment);

    String updatePhoneNumber(String phoneNumber);

    String updateSeniority(int seniority);

    String updatePositionId(int positionId);

    // show
    Employee showById(int id);

    List<Employee> showAll();

    List<Employee> showByName(String FIO);

    List<Employee> showByDepartment(int idDepartment);

    List<Employee> showByPhoneNumber(String phoneNumber);

    List<Employee> showBySeniority(int seniority);

    List<Employee> showByPositionId(int positionId);

    // get by template
    List<Employee> showByIdTemplate(String id);


    List<Employee> showByNameTemplate(String FIO);

    List<Employee> showByDepartmentTemplate(String idDepartment);

    List<Employee> showByPhoneNumberTemplate(String phoneNumber);

    List<Employee> showBySeniorityTemplate(String seniority);

    List<Employee> showByPositionIdTemplate(String positionId);
}
