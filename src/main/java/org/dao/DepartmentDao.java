package org.dao;

import org.entities.Department;

import java.util.List;

public interface DepartmentDao {
    // add
    boolean addDepartment(boolean fileType, String name, int chiefIdEmployee);
    // remove
    void removeAll(boolean fileType);
    boolean removeById(boolean fileType, int id);
    boolean removeByName(boolean fileType, String name);
    boolean removeByChiefId(boolean fileType, int chiefId);
    // update
    String updateAll(boolean fileType);
    String updateID(boolean fileType, int id);
   String updateName(boolean fileType, String name);
   String updateChiefId(boolean fileType, int chiefId);
    // show
   Department showById(boolean fileType, int id);
   List<Department> showAll(boolean fileType);
   List<Department> showByName(boolean fileType, String name);
   List<Department> showByChiefId(boolean fileType, int chiefId);
    // get by template
    List<Department> showByIdTemplate(boolean fileType, String id);
    List<Department> showByNameTemplate(boolean fileType, String name);
    List<Department> showByChiefIdTemplate(boolean fileType, String chiefId);
}
