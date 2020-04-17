package org.controllers.employeeOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.entities.Employee;
import org.utils.JsonUtilsDataExtractor;
import org.utils.XmlUtilsDataExtractor;

import java.util.List;

public class EmployeeAddFromFileOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Employee> employees = ApplicationContext.INSTANCE.getDataAccessor().getProperties().getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractEmployees(parseCommands[2]) :
                JsonUtilsDataExtractor.extractEmployees(parseCommands[2]);
        for (Employee employee : employees) {
            if (ApplicationContext.employeeDao.addEmployee(employee.getFIO(), employee.getIdDepartment(),
                    employee.getPhoneNumber(), employee.getSeniority(), employee.getIdPosition())) {
                added.append(employee.getId());
            } else {
                notAdded.append(employee.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }
}
