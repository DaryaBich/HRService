package org.dao;

import org.entities.Employee;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeDaoImpl implements EmployeeDao {
private String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.xml";
    @Override
    public boolean addEmployee(String FIO, int idDepartment, String phoneNumber, int seniority, int position) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int maxId = employees.size() + 1;
        Employee employee = new Employee(employees.size() + 1, FIO, idDepartment, phoneNumber, seniority, position);
        for (Employee emp : employees) {
            if (emp.equals(employee)) {
                return false;
            }
            if (emp.getId() > maxId) {
                maxId = emp.getId();
            }
        }
        employee.setId(maxId + 1);
        employees.add(employee);
        XmlUtilsDataUpdater.updateEmployees(employees);
        return true;
    }

    @Override
    public void removeAll() {
        XmlUtilsDataUpdater.updateEmployees(new ArrayList<>());
    }

    @Override
    public boolean removeById(int id) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getId() == id);
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(String Name) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getFIO().equals(Name));
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByDepartmentId(int idDepartment) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getIdDepartment() == idDepartment);
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByPhoneNumber(String phoneNumber) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getPhoneNumber().equals(phoneNumber));
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeBySeniority(int seniority) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getSeniority() == seniority);
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByPositionId(int positionId) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getIdPosition() == positionId);
        if (count != employees.size()) {
            XmlUtilsDataUpdater.updateEmployees(employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateAll() {
        return updateXml(dep -> true);
    }

    @Override
    public String updateId(int id) {
        return updateXml(dep -> dep.getId() == id);
    }

    @Override
    public String updateName(String FIO) {
        return updateXml((emp) -> emp.getFIO().equals(FIO));
    }

    @Override
    public String updateDepartment(int idDepartment) {
        return updateXml((emp) -> emp.getIdDepartment() == idDepartment);
    }

    @Override
    public String updatePhoneNumber(String phoneNumber) {
        return updateXml((emp) -> emp.getPhoneNumber().equals(phoneNumber));
    }

    @Override
    public String updateSeniority(int seniority) {
        return updateXml((emp) -> emp.getSeniority() == seniority);
    }

    @Override
    public String updatePositionId(int positionId) {
        return updateXml((emp) -> emp.getIdPosition() == positionId);
    }

    @Override
    public Employee showById(int id) {
        List<Employee> employees = XmlUtilsDataExtractor.extractEmployees(filepath);
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> showAll() {
        return XmlUtilsDataExtractor.extractEmployees(filepath);
    }

    @Override
    public List<Employee> showByName(String FIO) {
        return removeEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getFIO().equals(FIO));
    }

    @Override
    public List<Employee> showByDepartment(int idDepartment) {
        return removeEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getIdDepartment() == idDepartment);
    }

    @Override
    public List<Employee> showByPhoneNumber(String phoneNumber) {
        return removeEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getPhoneNumber().equals(phoneNumber));
    }

    @Override
    public List<Employee> showBySeniority(int seniority) {
        return removeEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getSeniority() == seniority);
    }

    @Override
    public List<Employee> showByPositionId(int positionId) {
        return removeEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getIdPosition() == positionId);
    }

    @Override
    public List<Employee> showByIdTemplate(String id) {
        String template = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> String.valueOf(emp.getId()).matches(template));
    }


    @Override
    public List<Employee> showByNameTemplate(String FIO) {
        String template = FIO.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getFIO().matches(template));
    }

    @Override
    public List<Employee> showByDepartmentTemplate(String idDepartment) {
        String template = idDepartment.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> String.valueOf(emp.getIdDepartment()).matches(template));
    }

    @Override
    public List<Employee> showByPhoneNumberTemplate(String phoneNumber) {
        String template = phoneNumber.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> emp.getPhoneNumber().matches(template));
    }

    @Override
    public List<Employee> showBySeniorityTemplate(String seniority) {
        String template = seniority.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> String.valueOf(emp.getSeniority()).matches(template));
    }

    @Override
    public List<Employee> showByPositionIdTemplate(String positionId) {
        String template = positionId.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(XmlUtilsDataExtractor.extractEmployees(filepath),
                (emp) -> String.valueOf(emp.getIdPosition()).matches(template));
    }

    private List<Employee> removeEmployee(List<Employee> employees, Predicate<Employee> condition) {
        for (int i = 0; i < employees.size(); i++) {
            if (condition.test(employees.get(i))) {
                employees.remove(i);
            }
        }
        return employees;
    }

    private List<Employee> showEmployee(List<Employee> employees, Predicate<Employee> condition) {
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (condition.test(employees.get(i))) {
                result.add(employees.get(i));
            }
        }
        return result;
    }

    private String updateXml(Predicate<Employee> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Employee> employeeList = XmlUtilsDataExtractor.extractEmployees(filepath);
        for (String str : arguments) {
            String[] fieldValue = str.split("=");
            switch (fieldValue[0]) {
                case "FIO":
                    employeeList = updateFields(employeeList, condition, (emp) -> emp.setFIO(fieldValue[1]));
                    break;
                case "phoneNumber":
                    employeeList = updateFields(employeeList, condition, (emp) -> emp.setPhoneNumber(fieldValue[1]));
                    break;
                case "idDepartment":
                    try {
                        int argument = Integer.parseInt(fieldValue[1]);
                        employeeList = updateFields(employeeList, condition, (emp) -> emp.setIdDepartment(argument));
                        break;
                    } catch (NumberFormatException e) {
                        return "isn`t a digit!";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return "not enough arguments!";
                    }
                case "seniority":
                    try {
                        int argument = Integer.parseInt(fieldValue[1]);
                        employeeList = updateFields(employeeList, condition, (emp) -> emp.setSeniority(argument));
                        break;
                    } catch (NumberFormatException e) {
                        return "isn`t a digit!";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return "not enough arguments!";
                    }
                case "idPosition":
                    try {
                        int argument = Integer.parseInt(fieldValue[1]);
                        employeeList = updateFields(employeeList, condition, (emp) -> emp.setIdPosition(argument));
                        break;
                    } catch (NumberFormatException e) {
                        return "isn`t a digit!";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return "not enough arguments!";
                    }
            }
        }
        XmlUtilsDataUpdater.updateEmployees(employeeList);
        return "departments update";
    }

    private List<Employee> updateFields(List<Employee> employees, Predicate<Employee> condition1,
                                        Consumer<Employee> condition2) {
        for (Employee emp : employees) {
            if (condition1.test(emp)) {
                condition2.accept(emp);
            }
        }
        return employees;
    }
}
