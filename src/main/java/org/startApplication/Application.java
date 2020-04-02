package org.startApplication;

import org.dao.*;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
       ApplicationFacade appFacade = new ApplicationFacade();
       appFacade.startApplication(args);
    }
}
