package org.startApplication;

import org.controllers.Controller;
import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ApplicationFacade {
    private Controller controller = new Controller();
    private View view = new View();

    public void startApplication(String... args) {
       View.instruction(); // вывод инструкции
        //start console
//        String command = "show all employees";
//        String result = controller.parse(command);
//        System.out.println(String.format("result : %s",command));
//        if (args.length>0){
//            if (args[0].equals("console")){
//                startConsoleApplication();
//            }
//            else if (args[0].equals("tests")){
//                startAutoTests();
//            }
//        }
        startAutoTests();
    }
    public void startConsoleApplication(){

    }
    public void startAutoTests(){
        List<String> commands = new ArrayList<>();
//        String filepathXml = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml";
//        String filepathJson = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.json";
//        commands.add("add/employee/json/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
//        commands.add("add/department/json/name/HR/chiefId/2");
        commands.add("add/position/json/name/middle/salary/48500.9");

//        commands.add("add/employee/xml/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
//        commands.add("add from file/position/xml/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.json");
//        commands.add("add from file/department/xml/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\department.json");
//
//        commands.add("show/position/xml/all");
//        commands.add("show/department/xml/all");
//
//        commands.add("show/position/json/all");
//        commands.add("show/department/json/all");
//
//        commands.add("show by template/employee/xml/fio/В*");
//        commands.add("remove/department/xml/id/1");
//        commands.add("remove/position/json/all");
//        commands.add("update/position/xml/id/1");
//        commands.add("update/department/xml/id/4");
//
//
//        commands.add("add/employee/json/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
//        commands.add("add/employee/json/fio/Николай/idDepartment/2/phoneNumber/892779/seniority/4/idPosition/2");
//        commands.add("add/employee/json/fio/Святослав/idDepartment/2/phoneNumber/762799/seniority/6/idPosition/3");
//
//        commands.add("add/position/json/name/Dev/salary/23459.9");
//        commands.add("add/department/json/name/devs/chiefId/2");
//
//        commands.add("show/employee/json/all");
//        commands.add("show by template/employee/xml/fio/В*");
//        commands.add("show by template/employee/xml/idDepartment/1*");
//        commands.add("add from file/department/xml/C:\\\\Users\\\\Darya\\\\Desktop\\\\Java\\\\HRApp\\\\departments.json");
//        commands.add("update/employee/xml/idDepartment/1");
        for (String s:commands ) {
            System.out.println(controller.parse(s));
        }
    }
}
