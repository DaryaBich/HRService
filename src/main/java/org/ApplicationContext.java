package org;

import org.dao.*;
import org.entities.Department;

public enum ApplicationContext {INSTANCE; // используем singleton
    private final DataAccessor dataAccessor = new DataAccessor();
    public static DepartmentDao departmentDao = new DepartmentDaoImpl();
    public static EmployeeDao employeeDao = new EmployeeDaoImpl();
    public static PositionDao positionDao = new PositionDaoImpl();
    private ApplicationContext() {
    }
    public DataAccessor getDataAccessor(){
        return dataAccessor;
    }
}
