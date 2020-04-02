package org.dao;

import org.entities.Position;

import java.util.List;

public interface PositionDao {
    // add
    boolean addPosition(boolean fileType, String name, double salary);

    // remove
    void removeAll(boolean fileType);

    boolean removeById(boolean fileType, int id);

    boolean removeByName(boolean fileType, String name);

    boolean removeBySalary(boolean fileType, double salary);

    // update
    String updateAll(boolean fileType);
    String updateId(boolean fileType, int id);

    String updateName(boolean fileType, String name);

    String updateSalary(boolean fileType, double salary);

    // show
    Position showById(boolean fileType, int id);

    List<Position> showAll(boolean fileType);

    List<Position> showByName(boolean fileType, String name);

    List<Position> showBySalary(boolean fileType, double salary);

    // get by template
    List<Position> showByIdTemplate(boolean fileType, String id);

    List<Position> showByNameTemplate(boolean fileType, String name);

    List<Position> showBySalaryTemplate(boolean fileType, String salary);
}
