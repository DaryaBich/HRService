package org.controllers;

import org.dao.DepartmentDao;
import org.dao.EmployeeDao;
import org.dao.PositionDao;
import org.entities.Position;

public interface OperationTypeController {
    public String execute(String[] parseCommands, DepartmentDao departmentDao);
    public String execute(String[] parseCommands, EmployeeDao employeeDao);
    public String execute(String[] parseCommands, PositionDao positionDao);
}
