package org.controllers.departmentOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.entities.Department;
import org.utils.JsonUtilsDataExtractor;
import org.utils.XmlUtilsDataExtractor;

import java.util.List;

public class DepartmentAddFromFileOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Department> departments = ApplicationContext.INSTANCE.getDataAccessor().getProperties()
                .getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractDepartments(parseCommands[2]) :
                JsonUtilsDataExtractor.extractDepartments(parseCommands[2]);
        for (Department department : departments) {
            if (ApplicationContext.departmentDao.addDepartment(department.getName(), department.getChiefId())) {
                added.append(department.getId());
            } else {
                notAdded.append(department.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }
}
