package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.view.View;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private Map<String, String> controllerCommands = new HashMap<String, String>();
    EmployeeDao employeeDao;
    DepartmentDao departmentDao;
    PositionDao positionDao;

    static {
        (new View()).welcome();
    }

    public Controller() {
        addShow();
        addPut();
        addRemove();
        addUpdate();
        addGetByTemplate();
    }

    public String parsing(String inputCommand) {
        String result = "";
        String command;
        // если вся строка - запрос без аргументов
        if (controllerCommands.containsKey(inputCommand)) {
            result = switchAllStringCommand(controllerCommands.get(inputCommand));
        } else {
            command = inputCommand.substring(0, inputCommand.indexOf("=") + 1);
            String[] arguments = inputCommand.substring(inputCommand.indexOf("=") + 1)
                    .split(",");
            for (String arg:arguments) {
                arg.trim();
            }
            if (controllerCommands.containsKey(command)) {
                result = switchCommand(command, arguments);
            } else {
                return "didn`t search"; // если запрос не найден
            }
        }
        return result;
    }

    private String switchAllStringCommand(String command) {
//        switch (command) {
//            case ("showAllDep"):
//                return listDepartmentsToString(departmentDao.showAll());
//            case ("showAllEmp"):
//                return listEmployeesToString(employeeDao.showAll());
//            case ("showAllPos"):
//                return listPositionsToString(positionDao.showAll());
//            case ("remAllEmp"):
//                return "Empty list of Employees";
//            case ("remAllDep"):
//                return "Empty list of Departments";
//            case ("remAllPos"):
//                return "Empty list of Positions";
//            case ("updAllEmp"):
//                return listEmployeesToString(employeeDao.updateAll());
////            case ("updAllDep"):
////                return listDepartmentsToString(departmentDao.updateAll());
//            case ("updAllPos"):
//                return listPositionsToString(positionDao.updateAll());
//            default:
                return "No result";
        //}
    }

    private String switchCommand(String command, String[] arguments) {
        String result;
//        switch (command) {
//            case ("showEmpId"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    (employeeDao.showById(Integer.parseInt(arguments[0]))).toString();
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showEmpName"):
//                if (arguments.length == 1){
//                    return listEmployeesToString(employeeDao.showByName(arguments[0]));
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
//            case ("showEmpDep"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return listEmployeesToString(employeeDao.showByDepartment(Integer.parseInt(arguments[0])));
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showEmpPhone"):
//                if (arguments.length == 1){
//                    return listEmployeesToString(employeeDao.showByPhoneNumber(arguments[0]));
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
//            case ("showEmpSen"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return listEmployeesToString(employeeDao.showBySeniority(Integer.parseInt(arguments[0])));
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showEmpPos"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return listEmployeesToString(employeeDao.showByPositionId(Integer.parseInt(arguments[0])));
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showDepId"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return (departmentDao.showById(Integer.parseInt(arguments[0]))).toString();
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showDepName"):
//                if (arguments.length == 1){
//                    return listDepartmentsToString(departmentDao.showByName(arguments[0]));
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
//            case ("showDepIdChief"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return (departmentDao.showByChiefId(Integer.parseInt(arguments[0]))).toString();
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showPosId"):
//                try {
//                    Integer.parseInt(arguments[0]);
//                    return (positionDao.showById(Integer.parseInt(arguments[0]))).toString();
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("showPosName"):
//                if (arguments.length == 1){
//                    return listPositionsToString(positionDao.showByName(arguments[0]));
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
//            case ("showPosSal"):
//                try {
//                    double res = Double.parseDouble(arguments[0]);
//                    return  listPositionsToString(positionDao.showBySalary(res));
//                } catch (NumberFormatException e) {
//                    return "id not a digit!";
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    return "not enough arguments!";
//                }
//            case ("addEmp"):
//                if (arguments.length == 5){
//                    try{
//                        int idDep = Integer.parseInt(arguments[1]);
//                        int seniority = Integer.parseInt(arguments[3]);
//                        int idPos = Integer.parseInt(arguments[4]);
//                        return listEmployeesToString(employeeDao.addEmployee(arguments[0],
//                                idDep, arguments[2], seniority, idPos));
//                    } catch(NumberFormatException e){
//                        return "incorrect data or incorrect order!";
//                    }
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
////            case ("addDep"):
////                if (arguments.length == 2){
////                    try{
////                        int idChief = Integer.parseInt(arguments[1]);
////                        return listDepartmentsToString(departmentDao.addDepartment(arguments[0], idChief));
////                    } catch(NumberFormatException e){
////                        return "incorrect data or incorrect order!";
////                    }
////                }
////                else {
////                    return "not enough/too much arguments!";
////                }
//            case ("addPos"):
//                if (arguments.length == 2){
//                    try{
//                        double salary = Double.parseDouble(arguments[1]);
//                        return listPositionsToString(positionDao.addPosition(arguments[0], salary));
//                    } catch(NumberFormatException e){
//                        return "incorrect data or incorrect order!";
//                    }
//                }
//                else {
//                    return "not enough/too much arguments!";
//                }
//            case ("remEmpId"):
//                return "res";
//            case ("remEmpName"):
//                return "res";
//            case ("remEmpDep"):
//                return "res";
//            case ("remEmpPhone"):
//                return "res";
//            case ("remEmpSen"):
//                return "res";
//            case ("remEmpPos"):
//                return "res";
//            case ("remDepId"):
//                return "res";
//            case ("remDepName"):
//                return "res";
//            case ("remDepIdChief"):
//                return "res";
//            case ("remPosId"):
//                return "res";
//            case ("remPosName"):
//                return "res";
//            case ("remPosSal"):
//                return "res";
//            case ("updEmpId"):
//                return "res";
//            case ("updEmpName"):
//                return "res";
//            case ("updEmpDep"):
//                return "res";
//            case ("updEmpPhone"):
//                return "res";
//            case ("updEmpSen"):
//                return "res";
//            case ("updEmpPos"):
//                return "res";
//            case ("updDepId"):
//                return "res";
//            case ("updDepName"):
//                return "res";
//            case ("updDepIdChief"):
//                return "res";
//            case ("updPosId"):
//                return "res";
//            case ("updPosName"):
//                return "res";
//            case ("updPosSal"):
//                return "res";
//            case ("getEmpNameTemp"):
//                return "res";
//            case ("getEmpDepTemp"):
//                return "res";
//            case ("getEmpPhoneTemp"):
//                return "res";
//            case ("getEmpSenTemp"):
//                return "res";
//            case ("getEmpPosTemp"):
//                return "res";
//            case ("getDepIdTemp"):
//                return "res";
//            case ("getDepNameTemp"):
//                return "res";
//            case ("getDepIdChiefTemp"):
//                return "res";
//            case ("getPosIdTemp"):
//                return "res";
//            case ("getPosNameTemp"):
//                return "res";
//            case ("getPosSalTemp"):
//                return "res";
//        }
        return "res";
    }
private String listEmployeesToString(List<Employee> employees){
        StringBuilder sBEmployee = new StringBuilder();
    for (Employee empl:employees) {
        sBEmployee.append(empl.toString());
    }
   return sBEmployee.toString();
}
    private String listDepartmentsToString(List<Department> departments){
        StringBuilder sBDepartment = new StringBuilder();
        for (Department dep : departments) {
            sBDepartment.append(dep.toString());
        }
        return sBDepartment.toString();
    }
    private String listPositionsToString(List<Position> positions){
        StringBuilder sBPosition = new StringBuilder();
        for (Position pos : positions) {
            sBPosition.append(pos.toString());
        }
        return sBPosition.toString();
    }

    public void addShow() {
        // employee
        controllerCommands.put("show all employees", "showAllEmp");
        controllerCommands.put("show employee with id =", "showEmpId");
        controllerCommands.put("show employee with name =", "showEmpName");
        controllerCommands.put("show employee with id department =", "showEmpDep");
        controllerCommands.put("show employee with phone =", "showEmpPhone");
        controllerCommands.put("show employee with seniority =", "showEmpSen");
        controllerCommands.put("show employee with id position =", "showEmpPos");
        // department
        controllerCommands.put("show all departments", "showAllDep");
        controllerCommands.put("show department with id =", "showDepId");
        controllerCommands.put("show department with name =", "showDepName");
        controllerCommands.put("show department with id chief =", "showDepIdChief");
        // position
        controllerCommands.put("show all positions", "showAllPos");
        controllerCommands.put("show position with id =", "showPosId");
        controllerCommands.put("show position with name =", "showPosName");
        controllerCommands.put("show position with salary =", "showPosSal");
    }

    public void addPut() {
        controllerCommands.put("add employee =", "addEmp");
        controllerCommands.put("add department =", "addDep");
        controllerCommands.put("add position =", "addPos");
    }

    public void addRemove() {
        // employee
        controllerCommands.put("remove all employees", "remAllEmp");
        controllerCommands.put("remove employee with id =", "remEmpId");
        controllerCommands.put("remove employee with name =", "remEmpName");
        controllerCommands.put("remove employee with id department =", "remEmpDep");
        controllerCommands.put("remove employee with phone =", "remEmpPhone");
        controllerCommands.put("remove employee with seniority =", "remEmpSen");
        controllerCommands.put("remove employee with id position =", "remEmpPos");
        // department
        controllerCommands.put("remove all departments", "remAllDep");
        controllerCommands.put("remove department with id =", "remDepId");
        controllerCommands.put("remove department with name =", "remDepName");
        controllerCommands.put("remove department with id chief =", "remDepIdChief");
        // position
        controllerCommands.put("remove all positions", "remAllPos");
        controllerCommands.put("remove position with id =", "remPosId");
        controllerCommands.put("remove position with name =", "remPosName");
        controllerCommands.put("remove position with salary =", "remPosSal");
    }

    public void addUpdate() {
        // employee
        controllerCommands.put("update all employees", "updAllEmp");
        controllerCommands.put("update employee with id =", "updEmpId");
        controllerCommands.put("update employee with name =", "updEmpName");
        controllerCommands.put("update employee with id department =", "updEmpDep");
        controllerCommands.put("update employee with phone =", "updEmpPhone");
        controllerCommands.put("update employee with seniority =", "updEmpSen");
        controllerCommands.put("update employee with id position =", "updEmpPos");
        // department
        controllerCommands.put("update all departments", "updAllDep");
        controllerCommands.put("update department with id =", "updDepId");
        controllerCommands.put("update department with name =", "updDepName");
        controllerCommands.put("update department with id chief =", "updDepIdChief");
        // position
        controllerCommands.put("update all positions", "updAllPos");
        controllerCommands.put("update position with id =", "updPosId");
        controllerCommands.put("update position with name =", "updPosName");
        controllerCommands.put("update position with salary =", "updPosSal");
    }

    public void addGetByTemplate() {
        // employee
        controllerCommands.put("get employee with template id =", "getEmpIdTemp");
        controllerCommands.put("get employee with template name =", "getEmpNameTemp");
        controllerCommands.put("get employee with template id department =", "getEmpDepTemp");
        controllerCommands.put("get employee with template phone =", "getEmpPhoneTemp");
        controllerCommands.put("get employee with template seniority =", "getEmpSenTemp");
        controllerCommands.put("get employee with template id position =", "getEmpPosTemp");
        // department
        controllerCommands.put("get department with template id =", "getDepIdTemp");
        controllerCommands.put("get department with template name =", "getShowDepNameTemp");
        controllerCommands.put("get department with template id chief =", "getDepIdChiefTemp");
        // position
        controllerCommands.put("get position with template id =", "getPosIdTemp");
        controllerCommands.put("get position with template name =", "getPosNameTemp");
        controllerCommands.put("get position with template salary =", "getPosSalTemp");
    }
}
