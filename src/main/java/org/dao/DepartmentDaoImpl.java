package org.dao;

import org.entities.Department;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DepartmentDaoImpl implements DepartmentDao {
private String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml";
    @Override
    // вводить
    public boolean addDepartment(String name, int chiefIdEmployee) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
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
        XmlUtilsDataUpdater.updateDepartments(departments);
        return true;
    }

    @Override
    public void removeAll() {
        XmlUtilsDataUpdater.updateDepartments(new ArrayList<Department>());
    }

    @Override
    public boolean removeById(int id) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getId() == id);
        if (departments.size() != count) {
            XmlUtilsDataUpdater.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean removeByName(String name) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getName().equals(name));
        if (departments.size() != count) {
            XmlUtilsDataUpdater.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByChiefId(int chiefId) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
        int count = departments.size();
        departments = removeDepartment(departments, (dep) -> dep.getChiefId() == chiefId);
        if (departments.size() != count) {
            XmlUtilsDataUpdater.updateDepartments(departments);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String updateAll(){
        return updateXml((dep) -> true);
    }
    @Override
    public String updateID(int id){
        return updateXml((dep) -> dep.getId() == id);
    }
    @Override
    public String updateName(String name) {
        return updateXml((dep) -> dep.getName().equals(name));
    }

    @Override
    public String updateChiefId(int chiefId) {
        return updateXml((dep) -> dep.getChiefId() == chiefId);
    }

    @Override
    public Department showById(int id) {
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
        for (Department dep : departments) {
            if (dep.getId() == id) {
                return dep;
            }
        }
        return null;
    }

    @Override
    public List<Department> showAll() {
        return XmlUtilsDataExtractor.extractDepartments(filepath);
    }

    @Override
    public List<Department> showByName(String name) {
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(filepath),
                (dep) -> dep.getName().equals(name));
    }

    @Override
    public List<Department> showByChiefId(int chiefId) {
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(filepath),
                (dep) -> dep.getChiefId() == chiefId);
    }

    @Override
    public List<Department> showByIdTemplate(String id) {
        String strId = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(filepath),
                (dep) -> String.valueOf(dep.getId()).matches(strId));
    }

    @Override
    public List<Department> showByNameTemplate(String name) {
        String argument = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(filepath),
                (dep) -> dep.getName().matches(argument));
    }

    @Override
    public List<Department> showByChiefIdTemplate(String chiefId) {
        String strId = chiefId.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showDepartment(XmlUtilsDataExtractor.extractDepartments(filepath),
                (dep) -> String.valueOf(dep.getChiefId()).matches(strId));
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
        List<Department> departments = XmlUtilsDataExtractor.extractDepartments(filepath);
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
        XmlUtilsDataUpdater.updateDepartments(departments);
        return "departments update";
    }
}
