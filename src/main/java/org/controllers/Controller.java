package org.controllers;

import org.dao.EmployeeDao;
import org.entities.Employee;
import org.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private Map<String, String> controllerCommands = new HashMap<String, String>();
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

    public String parsing(String command) {
        //pars command
        String s = controllerCommands.get(command);
//        if (s == "emplAll") {
//            List<Employee> all = emploerDao.getAll();
//        }
        return "result";
    }
    private String parser(String command){
        StringBuilder sB = new StringBuilder();
        return command;
    }
    public void addShow() {
        // employee
        controllerCommands.put("show all employees", "showEmpAll");
        controllerCommands.put("show employee: id =", "showEmpId");
        controllerCommands.put("show employee: name =", "showEmpName");
        controllerCommands.put("show employee: id department =", "showEmpDep");
        controllerCommands.put("show employee: phone =", "showEmpPhone");
        controllerCommands.put("show employee: seniority =", "showEmpSen");
        controllerCommands.put("show employee: id position =", "showEmpPos");
        // department
        controllerCommands.put("show all departments", "showDepAll");
        controllerCommands.put("show department: id =", "showDepId");
        controllerCommands.put("show department: name =", "showDepName");
        controllerCommands.put("show department: id chief =", "showDepIdChief");
        // position
        controllerCommands.put("show all positions", "showPosAll");
        controllerCommands.put("show position: id =", "showPosId");
        controllerCommands.put("show position: name =", "showPosName");
        controllerCommands.put("show position: salary =", "showPosSal");
    }

    public void addPut() {
        controllerCommands.put("add employee:", "addEmp");
        controllerCommands.put("add department:", "addDep");
        controllerCommands.put("add position:", "addPos");
    }

    public void addRemove() {
        // employee
        controllerCommands.put("remove all employees", "remEmpAll");
        controllerCommands.put("remove employee: id =", "remEmpId");
        controllerCommands.put("remove employee: name =", "remEmpName");
        controllerCommands.put("remove employee: id department =", "remEmpDep");
        controllerCommands.put("remove employee: phone =", "remEmpPhone");
        controllerCommands.put("remove employee: seniority =", "remEmpSen");
        controllerCommands.put("remove employee: id position =", "remEmpPos");
        // department
        controllerCommands.put("remove all departments", "remDepAll");
        controllerCommands.put("remove department: id =", "remDepId");
        controllerCommands.put("remove department: name =", "remDepName");
        controllerCommands.put("remove department: id chief =", "remDepIdChief");
        // position
        controllerCommands.put("remove all positions", "remPosAll");
        controllerCommands.put("remove position: id =", "remPosId");
        controllerCommands.put("remove position: name =", "remPosName");
        controllerCommands.put("remove position: salary =", "remPosSal");
    }

    public void addUpdate() {
        // employee
        controllerCommands.put("update all employees", "updEmpAll");
        controllerCommands.put("update employee with id =", "updEmpId");
        controllerCommands.put("update employee with name =", "updEmpName");
        controllerCommands.put("update employee with id department =", "updEmpDep");
        controllerCommands.put("update employee with phone =", "updEmpPhone");
        controllerCommands.put("update employee with seniority =", "updEmpSen");
        controllerCommands.put("update employee with id position =", "updEmpPos");
        // department
        controllerCommands.put("update all departments", "updDepAll");
        controllerCommands.put("update department with id =", "updDepId");
        controllerCommands.put("update department with name =", "updDepName");
        controllerCommands.put("update department with id chief =", "updDepIdChief");
        // position
        controllerCommands.put("update all positions", "updPosAll");
        controllerCommands.put("update position with id =", "updPosId");
        controllerCommands.put("update position with name =", "updPosName");
        controllerCommands.put("update position with salary =", "updPosSal");
    }

    public void addGetByTemplate() {
        // employee
        controllerCommands.put("get employee: template id =", "getEmpIdTemp");
        controllerCommands.put("get employee: template name =", "getEmpNameTemp");
        controllerCommands.put("get employee: template id department =", "getEmpDepTemp");
        controllerCommands.put("get employee: template phone =", "getEmpPhoneTemp");
        controllerCommands.put("get employee: template seniority =", "getEmpSenTemp");
        controllerCommands.put("get employee: template id position =", "getEmpPosTemp");
        // department
        controllerCommands.put("get department: template id =", "getDepIdTemp");
        controllerCommands.put("get department: template name =", "getShowDepNameTemp");
        controllerCommands.put("get department: template id chief =", "getDepIdChiefTemp");
        // position
        controllerCommands.put("get position: template id =", "getPosIdTemp");
        controllerCommands.put("get position: template name =", "getPosNameTemp");
        controllerCommands.put("get position: template salary =", "getPosSalTemp");
    }
}
