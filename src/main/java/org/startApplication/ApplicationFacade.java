package org.startApplication;

import org.controllers.Controller;
import org.view.View;

public class ApplicationFacade {
    private Controller controller = new Controller();
    private View view = new View();

    public void startApplication(String... args) {
        view.instruction(); // вывод инструкции
        //start console
        String command = "show all employees";
        String result = controller.parsing(command);
        System.out.println(String.format("result : %s",command));
    }
}
