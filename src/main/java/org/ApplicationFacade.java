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
        commands.add("show/position/all");
        commands.add("show/department/all");
        commands.add("show/employee/all");

        commands.add("add/employee/fio/Дюжин Роман Витальевич/idDepartment/2/phoneNumber/892799/seniority/4/idPosition/3");
        commands.add("add/position/name/Helper/salary/23000");
        commands.add("add/department/name/newDepartment/chiefId/16");

        commands.add("show by template/employee/idPosition/*3");
        commands.add("show by template/department/name/P*");

        commands.add("remove/department/id/1");
        commands.add("remove/employee/idDepartment/1");
        commands.add("remove/position/id/2");

        commands.add("update/position/id/1");
        commands.add("update/department/id/4");
        commands.add("update/employee/id/14");
        commands.add("add from file/department/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.json");
        commands.add("add from file/employee/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.json");
        commands.add("add from file/position/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.json");
        for (String s : commands) {
            System.out.println(controller.parse(s));
        }
    }
}
