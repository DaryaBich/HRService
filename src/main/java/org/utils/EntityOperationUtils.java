package org.utils;

import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

import java.util.List;

public class EntityOperationUtils {
    public static String listEmployeesToString(List<Employee> employees) {
        StringBuilder sBEmployee = new StringBuilder();
        for (Employee empl : employees) {
            sBEmployee.append(empl.toString());
        }
        return sBEmployee.toString();
    }

    public static String listDepartmentsToString(List<Department> departments) {
        StringBuilder sBDepartment = new StringBuilder();
        for (Department dep : departments) {
            sBDepartment.append(dep.toString());
        }
        return sBDepartment.toString();
    }

    public static String listPositionsToString(List<Position> positions) {
        StringBuilder sBPosition = new StringBuilder();
        for (Position pos : positions) {
            sBPosition.append(pos.toString());
        }
        return sBPosition.toString();
    }
}
