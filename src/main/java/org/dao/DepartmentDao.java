package org.dao;

import org.entities.Department;

import java.util.List;

public interface DepartmentDao {
    // add
    boolean addDepartment(String name, int chiefIdEmployee);
    // remove
    void removeAll();
    boolean removeById(int id);
    boolean removeByName(String name);
    boolean removeByChiefId(int chiefId);
    // update
    String updateAll();
    String updateID( int id);
   String updateName(String name);
   String updateChiefId(int chiefId);
    // show
   Department showById(int id);
   List<Department> showAll();
   List<Department> showByName(String name);
   List<Department> showByChiefId( int chiefId);
    // get by template
    List<Department> showByIdTemplate(String id);
    List<Department> showByNameTemplate(String name);
    List<Department> showByChiefIdTemplate(String chiefId);
}
