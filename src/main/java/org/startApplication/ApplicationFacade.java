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

public class ApplicationFacade {
    private Controller controller = new Controller();
    private View view = new View();

    public void startApplication(String... args) {
        view.instruction(); // вывод инструкции
        //start console
        String command = "show all employees";
        String result = controller.parse(command);
        System.out.println(String.format("result : %s",command));
        if (args.length>0){
            if (args[0].equals("console")){
                startConsoleApplication();
            }
            else if (args[0].equals("tests")){
                startAutoTests();
            }
        }
    }
    public void startConsoleApplication(){

    }
    public void startAutoTests(){
    }
}
