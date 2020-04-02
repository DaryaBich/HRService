package org.dao;

import org.entities.Employee;
import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean addEmployee(boolean fileType, String FIO, int idDepartment, String phoneNumber, int seniority,
                               int position) {
        List<Employee> employees = Employee.chooseFile(fileType);
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
        Employee.updateChoosingFile(fileType, employees);
        return true;
    }

    @Override
    public void removeAll(boolean fileType) {
        Employee.updateChoosingFile(fileType, new ArrayList<Employee>());
    }

    @Override
    public boolean removeById(boolean fileType, int id) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getId() == id);
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(boolean fileType, String Name) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getFIO().equals(Name));
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByDepartmentId(boolean fileType, int idDepartment) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getIdDepartment() == idDepartment);
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByPhoneNumber(boolean fileType, String phoneNumber) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getPhoneNumber().equals(phoneNumber));
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeBySeniority(boolean fileType, int seniority) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getSeniority() == seniority);
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByPositionId(boolean fileType, int positionId) {
        List<Employee> employees = Employee.chooseFile(fileType);
        int count = employees.size();
        employees = removeEmployee(employees, (emp) -> emp.getIdPosition() == positionId);
        if (count != employees.size()) {
            Employee.updateChoosingFile(fileType, employees);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateAll(boolean fileType) {
        return updater(dep -> true,fileType);
    }

    @Override
    public String updateId(boolean fileType, int id) {
        return updater(dep -> dep.getId() == id, fileType);
    }

    @Override
    public String updateName(boolean fileType, String FIO) {
        return updater((emp) -> emp.getFIO().equals(FIO), fileType);
    }

    @Override
    public String updateDepartment(boolean fileType, int idDepartment) {
        return updater((emp) -> emp.getIdDepartment() == idDepartment, fileType);
    }

    @Override
    public String updatePhoneNumber(boolean fileType, String phoneNumber) {
        return updater((emp) -> emp.getPhoneNumber().equals(phoneNumber), fileType);
    }

    @Override
    public String updateSeniority(boolean fileType, int seniority) {
        return updater((emp) -> emp.getSeniority() == seniority, fileType);
    }

    @Override
    public String updatePositionId(boolean fileType, int positionId) {
        return updater((emp) -> emp.getIdPosition() == positionId, fileType);
    }

    @Override
    public Employee showById(boolean fileType, int id) {
        List<Employee> employees = Employee.chooseFile(fileType);
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> showAll(boolean fileType) {
        return Employee.chooseFile(fileType);
    }

    @Override
    public List<Employee> showByName(boolean fileType, String FIO) {
        return removeEmployee(Employee.chooseFile(fileType),
                (emp) -> emp.getFIO().equals(FIO));
    }

    @Override
    public List<Employee> showByDepartment(boolean fileType, int idDepartment) {
        return removeEmployee(Employee.chooseFile(fileType), (emp) -> emp.getIdDepartment() == idDepartment);
    }

    @Override
    public List<Employee> showByPhoneNumber(boolean fileType, String phoneNumber) {
        return removeEmployee(Employee.chooseFile(fileType), (emp) -> emp.getPhoneNumber().equals(phoneNumber));
    }

    @Override
    public List<Employee> showBySeniority(boolean fileType, int seniority) {
        return removeEmployee(Employee.chooseFile(fileType), (emp) -> emp.getSeniority() == seniority);
    }

    @Override
    public List<Employee> showByPositionId(boolean fileType, int positionId) {
        return removeEmployee(Employee.chooseFile(fileType), (emp) -> emp.getIdPosition() == positionId);
    }

    @Override
    public List<Employee> showByIdTemplate(boolean fileType, String id) {
        String template = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(Employee.chooseFile(fileType), (emp) -> String.valueOf(emp.getId()).matches(template));
    }


    @Override
    public List<Employee> showByNameTemplate(boolean fileType, String FIO) {
        String template = FIO.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showEmployee(Employee.chooseFile(fileType), (emp) -> emp.getFIO().matches(template));
    }

    @Override
    public List<Employee> showByDepartmentTemplate(boolean fileType, String idDepartment) {
        String template = idDepartment.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(Employee.chooseFile(fileType),
                (emp) -> String.valueOf(emp.getIdDepartment()).matches(template));
    }

    @Override
    public List<Employee> showByPhoneNumberTemplate(boolean fileType, String phoneNumber) {
        String template = phoneNumber.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(Employee.chooseFile(fileType), (emp) -> emp.getPhoneNumber().matches(template));
    }

    @Override
    public List<Employee> showBySeniorityTemplate(boolean fileType, String seniority) {
        String template = seniority.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(Employee.chooseFile(fileType),
                (emp) -> String.valueOf(emp.getSeniority()).matches(template));
    }

    @Override
    public List<Employee> showByPositionIdTemplate(boolean fileType, String positionId) {
        String template = positionId.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showEmployee(Employee.chooseFile(fileType),
                (emp) -> String.valueOf(emp.getIdPosition()).matches(template));
    }

    private List<Employee> removeEmployee(List<Employee> employees, Predicate<Employee> condition) {
        for (int i = 0; i < employees.size(); i++) {
            if (condition.test(employees.get(i))) {
                employees.remove(i);
                i = -1;
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

    private String updater(Predicate<Employee> condition, boolean fileType) {
        String[] arguments = View.inputUpdateArguments();
        List<Employee> employeeList = Employee.chooseFile(fileType);
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
        Employee.updateChoosingFile(fileType, employeeList);
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
