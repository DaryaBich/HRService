package org.dao;

import org.entities.Department;

import java.util.List;

public interface DepartmentDao {
    // add
    List<Department> addDepartment(Department department);
    // remove
   List<Department> removeAll();
   List<Department> removeById(int id);
   List<Department> removeByName(String name);
   List<Department> removeByChiefId(int chiefId);
    // update
   List<Department> updateId(int id, Department... departments);
   List<Department> updateName(String name, Department... departments);
   List<Department> updateChiefId(int chiefId, Department... departments);
    // show
   Department showById(int id);
   List<Department> showAll();
   List<Department> showByName(String name);
   List<Department> showByChiefId(int chiefId);
    // get by template
    List<Department> showByIdTemplate(int id);
    List<Department> showByNameTemplate(String name);
    List<Department> showByChiefIdTemplate(int chiefId);
}
