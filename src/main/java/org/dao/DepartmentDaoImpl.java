package org.dao;

import org.entities.Department;
import org.entities.Employee;
import org.utils.XmlUtilsDataExtractor;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public boolean addDepartment(String name, int chiefIdEmployee) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        Department department = new Department(departments.size() + 1, name, chiefIdEmployee);
        for (Department dep : departments) {
            if (dep.equals(department)) {
                return false;
            }
        }
        departments.add(department);
        XmlUtilsDataExtractor.updateDepartments(departments);
        return true;
    }

    @Override
    public void removeAll() {
        XmlUtilsDataExtractor.updateDepartments(new ArrayList<Department>());
    }

    @Override
    public boolean removeById(int id) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getId() == id);
        if (departments.size() != count) {
            XmlUtilsDataExtractor.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean removeByName(String name) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getName().equals(name));
        if (departments.size() != count) {
            XmlUtilsDataExtractor.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByChiefId(int chiefId) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getChiefIdEmployee() == chiefId);
        if (departments.size() != count) {
            XmlUtilsDataExtractor.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateName(String name) {
        return updateXml((dep) -> dep.getName().equals(name));
    }

    @Override
    public String updateChiefId(int chiefId) {
        return updateXml((dep) -> dep.getChiefIdEmployee() == chiefId);
    }

    @Override
    public Department showById(int id) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        for (Department dep : departments) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }

    @Override
    public List<Department> showAll() {
        return XmlUtilsDataExtractor.extractDepartments();
    }

    @Override
    public List<Department> showByName(String name) {
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(),
                (dep) -> dep.getName().equals(name));
    }

    @Override
    public List<Department> showByChiefId(int chiefId) {
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(),
                (dep) -> dep.getChiefIdEmployee() == chiefId);
    }

    @Override
    public List<Department> showByIdTemplate(String id) {
        String strId = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(),
                (dep) -> String.valueOf(dep.getId()).matches(strId));
    }

    @Override
    public List<Department> showByNameTemplate(String name) {
        String argument = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(),
                (dep) -> dep.getName().matches(argument));
    }

    @Override
    public List<Department> showByChiefIdTemplate(String chiefId) {
        String strId = chiefId.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(),
                (dep) -> String.valueOf(dep.getChiefIdEmployee()).matches(strId));
    }

    private List<Department> removeDepartment(List<Department> departments, Predicate<Department> condition) {
        for (int i = 0; i < departments.size(); i++) {
            if (condition.test(departments.get(i))) {
                departments.remove(i);
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
    private String updateXml(Predicate<Department> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments();
        for (String str : arguments) {
            String[] fieldValue = str.split("=");
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
                                department.setChiefIdEmployee(argument);
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
        XmlUtilsDataExtractor.updateDepartments(departments);
        return "departments update";
    }
}
