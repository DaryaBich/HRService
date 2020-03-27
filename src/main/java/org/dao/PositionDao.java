package org.dao;

import org.entities.Position;

import java.util.List;

public interface PositionDao {
    // add
    List<Position> addPosition(Position position);

    // remove
    List<Position> removeAll();

    List<Position> removeById(int id);

    List<Position> removeByName(String name);

    List<Position> removeBySalary(double salary);

    // update
    List<Position> updateId(int id, Position... positions);

    List<Position> updateName(String name, Position... positions);

    List<Position> updateSalary(double salary, Position... positions);

    // show
    Position showById(int id);

    List<Position> showAll();

    List<Position> showByName(String name);

    List<Position> showBySalary(double salary);

    // get by template
    List<Position> getByIdTemplate(int id);

    List<Position> getByNameTemplate(String name);

    List<Position> getBySalaryTemplate(double salary);
}
