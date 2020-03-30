package org.dao;

import org.entities.Position;

import java.util.List;

public interface PositionDao {
    // add
    boolean addPosition(String name, double salary);

    // remove
    void removeAll();

    boolean removeById(int id);

    boolean removeByName(String name);

    boolean removeBySalary(double salary);

    // update
    String updateId(int id, Position... positions);

    String updateName(String name, Position... positions);

    String updateSalary(double salary, Position... positions);

    // show
    Position showById(int id);

    List<Position> showAll();

    List<Position> showByName(String name);

    List<Position> showBySalary(double salary);

    // get by template
    List<Position> showByIdTemplate(String id);

    List<Position> showByNameTemplate(String name);

    List<Position> showBySalaryTemplate(String salary);
}
