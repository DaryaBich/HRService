package org.dao;

import org.entities.Department;
import org.entities.Position;
import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    // вводить
    public boolean addDepartment(boolean fileType, String name, int chiefIdEmployee) {
        List<Department> departments = Department.chooseFile(fileType);
        Department department = new Department(departments.size() + 1, name, chiefIdEmployee);
        int maxId = departments.size() + 1;
        for (Department dep : departments) {
            if (dep.equals(department)) {
                return false;
            }
            if (dep.getId() > maxId){
                maxId = dep.getId();
            }
        }
        department.setId(maxId + 1);
        departments.add(department);
        Department.updateChoosingFile(fileType, departments);
        return true;
    }

    @Override
    public void removeAll(boolean fileType) {
        Department.updateChoosingFile(fileType, new ArrayList<>());
    }

    @Override
    public boolean removeById(boolean fileType, int id) {
        List<Department> departments = Department.chooseFile(fileType);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getId() == id);
        if (departments.size() != count) {
            Department.updateChoosingFile(fileType, departments);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean removeByName(boolean fileType, String name) {
        List<Department> departments = Department.chooseFile(fileType);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getName().equals(name));
        if (departments.size() != count) {
            Department.updateChoosingFile(fileType, departments);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByChiefId(boolean fileType, int chiefId) {
        List<Department> departments = Department.chooseFile(fileType);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getChiefId() == chiefId);
        if (departments.size() != count) {
            Department.updateChoosingFile(fileType, departments);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String updateAll(boolean fileType){
        return updater(fileType, (dep) -> true);
    }
    @Override
    public String updateID(boolean fileType, int id){
        return updater(fileType, (dep) -> dep.getId() == id);
    }
    @Override
    public String updateName(boolean fileType, String name) {
        return updater(fileType, (dep) -> dep.getName().equals(name));
    }

    @Override
    public String updateChiefId(boolean fileType, int chiefId) {
        return updater(fileType, (dep) -> dep.getChiefId() == chiefId);
    }

    @Override
    public Department showById(boolean fileType, int id) {
        List<Department> departments =Department.chooseFile(fileType);
        for (Department dep : departments) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }

    @Override
    public List<Department> showAll(boolean fileType) {
        return Department.chooseFile(fileType);
    }

    @Override
    public List<Department> showByName(boolean fileType, String name) {
        return showDepartment(Department.chooseFile(fileType),
                (dep) -> dep.getName().equals(name));
    }

    @Override
    public List<Department> showByChiefId(boolean fileType, int chiefId) {
        return showDepartment(Department.chooseFile(fileType),
                (dep) -> dep.getChiefId() == chiefId);
    }

    @Override
    public List<Department> showByIdTemplate(boolean fileType, String id) {
        String strId = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(Department.chooseFile(fileType),
                (dep) -> String.valueOf(dep.getId()).matches(strId));
    }

    @Override
    public List<Department> showByNameTemplate(boolean fileType, String name) {
        String argument = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showDepartment(Department.chooseFile(fileType),
                (dep) -> dep.getName().matches(argument));
    }

    @Override
    public List<Department> showByChiefIdTemplate(boolean fileType, String chiefId) {
        String strId = chiefId.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(Department.chooseFile(fileType),
                (dep) -> String.valueOf(dep.getChiefId()).matches(strId));
    }

    private List<Department> removeDepartment(List<Department> departments, Predicate<Department> condition) {
        for (int i = 0; i < departments.size(); i++) {
            if (condition.test(departments.get(i))) {
                departments.remove(i);
                i = -1;
            }
        }
        return departments;
    }

    private List<Department> showDepartment(List<Department> departments, Predicate<Department> condition) {
        List<Department> result = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            if (condition.test(departments.get(i))) {
                result.add(departments.get(i));
            }
        }
        return result;
    }
    private String updater(boolean fileType, Predicate<Department> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Department> departments = Department.chooseFile(fileType);
        for (String str : arguments) {
            String[] fieldValue = str.split("/");
            switch (fieldValue[0]){
                case "name":
                    for (Department department: departments) {
                        if (condition.test(department)){
                            department.setName(fieldValue[1]);
                        }
                    }
                    break;
                case "chiefId":
                    try {
                        int argument = Integer.parseInt(fieldValue[1]);
                        for (Department department: departments) {
                            if (condition.test(department)){
                                department.setChiefId(argument);
                            }
                        }
                        break;
                    } catch (NumberFormatException e) {
                        return "isn`t a digit!";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return "not enough arguments!";
                    }
            }
        }
        Department.updateChoosingFile(fileType, departments);
        return "departments обновлены";
    }

}
