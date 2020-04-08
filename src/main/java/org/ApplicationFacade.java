package org;

import org.controllers.Controller;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationFacade {
    private Controller controller = new Controller();

    public void startApplication(String... args) {
        View.instruction(); // вывод инструкции
        startAutoTests();
        Scanner input = new Scanner(System.in);
        do {
            View.inputData();
            String command = input.nextLine();
            if (command.equalsIgnoreCase("end")) {
                break;
            } else {
                System.out.println(controller.parse(command));
            }
        } while (true);
    }

    public void startAutoTests() {
        List<String> commands = new ArrayList<>();
//        String filepathXml = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml";
//        String filepathJson = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.json";
//        commands.add("add/employee/json/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
        //      commands.add("add/department/name/HR/chiefId/2");
        //     commands.add("add/position/name/middle/salary/48500.9");

//        commands.add("add/employee/xml/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
//        commands.add("add from file/position/xml/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.json");
//        commands.add("add from file/department/xml/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\department.json");
//
        commands.add("show/position/all");
        commands.add("show/department/all");
//
//        commands.add("show/position/json/all");
//        commands.add("show/department/json/all");
//
        commands.add("show by template/employee/fio/В*");
        commands.add("remove/department/id/3");
        commands.add("show/department/all");
//        commands.add("remove/position/json/all");
//        commands.add("update/position/xml/id/1");
//        commands.add("update/department/xml/id/4");
//
//
//        commands.add("add/employee/json/fio/Роман/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
//        commands.add("add/employee/json/fio/Николай/idDepartment/2/phoneNumber/892779/seniority/4/idPosition/2");
//
//        commands.add("add/position/json/name/Dev/salary/23459.9");
//        commands.add("add/department/json/name/devs/chiefId/2");
//
//        commands.add("show/employee/json/all");
//        commands.add("show by template/employee/xml/fio/В*");
//        commands.add("show by template/employee/xml/idDepartment/1*");
//        commands.add("add from file/department/xml/C:\\\\Users\\\\Darya\\\\Desktop\\\\Java\\\\HRApp\\\\departments.json");
//        commands.add("update/employee/xml/idDepartment/1");
        for (String s : commands) {
            System.out.println(controller.parse(s));
        }
    }
}
