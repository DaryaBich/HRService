package org.controllers;
import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.view.View;

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
        String result = new String();
        String command;
        // если вся строка - запрос без аргументов
        if (controllerCommands.containsKey(inputCommand)){
            command = controllerCommands.get(inputCommand);
            if ("showAllEmp".equals(command)) {
                List<Employee> employees = employeeDao.showAll();
            } else if ("showAllDep".equals(command)) {
                List<Department> departments = departmentDao.showAll();
            } else if ("showAllPos".equals(command)) {
                List<Position> positions = positionDao.showAll();
            } else if ("remAllEmp".equals(command)) {
            } else if ("remAllDep".equals(command)) {
            } else if ("remAllPos".equals(command)) {
            } else if ("updAllEmp".equals(command)) {
            } else if ("updAllDep".equals(command)) {
            } else if ("updAllPos".equals(command)) {
            }
        }
        else {
            command = inputCommand.substring(0, inputCommand.indexOf("=") + 1);
            if (controllerCommands.containsKey(command)){

            }
            else {
                return "didn`t search"; // если запрос не найден
            }
        }

//        if (s == "emplAll") {
//            List<Employee> all = emploerDao.getAll();
//        }
        return result;//.toString();
    }
    private String parser(String command){
        StringBuilder sB = new StringBuilder();
        return command;
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
