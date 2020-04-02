package org.dao;

import org.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    // add
    boolean addEmployee(boolean fileType, String FIO, int idDepartment,
                               String phoneNumber, int seniority, int position);

    // remove
    void removeAll(boolean fileType);

    boolean removeById(boolean fileType, int id);

    boolean removeByName(boolean fileType, String Name);

    boolean removeByDepartmentId(boolean fileType, int idDepartment);

    boolean removeByPhoneNumber(boolean fileType, String phoneNumber);

    boolean removeBySeniority(boolean fileType, int seniority);

    boolean removeByPositionId(boolean fileType, int positionId);

    // update
    String updateAll(boolean fileType);
    String updateId(boolean fileType, int id);

    String updateName(boolean fileType, String FIO);

    String updateDepartment(boolean fileType, int idDepartment);

    String updatePhoneNumber(boolean fileType, String phoneNumber);

    String updateSeniority(boolean fileType, int seniority);

    String updatePositionId(boolean fileType, int positionId);

    // show
    Employee showById(boolean fileType, int id);

    List<Employee> showAll(boolean fileType);

    List<Employee> showByName(boolean fileType, String FIO);

    List<Employee> showByDepartment(boolean fileType, int idDepartment);

    List<Employee> showByPhoneNumber(boolean fileType, String phoneNumber);

    List<Employee> showBySeniority(boolean fileType, int seniority);

    List<Employee> showByPositionId(boolean fileType, int positionId);

    // get by template
    List<Employee> showByIdTemplate(boolean fileType, String id);


    List<Employee> showByNameTemplate(boolean fileType, String FIO);

    List<Employee> showByDepartmentTemplate(boolean fileType, String idDepartment);

    List<Employee> showByPhoneNumberTemplate(boolean fileType, String phoneNumber);

    List<Employee> showBySeniorityTemplate(boolean fileType, String seniority);

    List<Employee> showByPositionIdTemplate(boolean fileType, String positionId);
}
