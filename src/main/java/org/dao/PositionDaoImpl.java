package org.dao;
import org.entities.Position;
import org.utils.XmlUtilsDataExtractor;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PositionDaoImpl implements PositionDao {

    @Override
    public boolean addPosition(String name, double salary) {
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        Position position = new Position(positions.size() + 1, name, salary);
        for (Position pos : positions) {
            if (pos.equals(position)) {
                return false;
            }
        }
        positions.add(position);
        XmlUtilsDataExtractor.updatePositions(positions);
        return true;
    }

    @Override
    public void removeAll() {
        XmlUtilsDataExtractor.updatePositions(new ArrayList<>());
    }

    @Override
    public boolean removeById(int id) {
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getId() == id);
        if (count != positions.size()) {
            XmlUtilsDataExtractor.updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(String name) {
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getName().equals(name));
        if (count != positions.size()) {
            XmlUtilsDataExtractor.updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeBySalary(double salary) {
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getSalary() == salary);
        if (count != positions.size()) {
            XmlUtilsDataExtractor.updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateId(int id, Position... positions) {
        return updateXml(pos -> pos.getId() == id);
    }

    @Override
    public String updateName(String name, Position... positions) {
        return updateXml(pos -> pos.getName().equals(name));
    }

    @Override
    public String updateSalary(double salary, Position... positions) {
        return updateXml(pos -> pos.getSalary() == salary);
    }

    @Override
    public Position showById(int id) {
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        for (Position pos : positions) {
            if (pos.getId() == id) {
                return pos;
            }
        }
        return null;
    }

    @Override
    public List<Position> showAll() {
        return XmlUtilsDataExtractor.extractPositions();
    }

    @Override
    public List<Position> showByName(String name) {
        return removePosition(XmlUtilsDataExtractor.extractPositions(),
                (pos) -> pos.getName().equals(name));
    }

    @Override
    public List<Position> showBySalary(double salary) {
        return removePosition(XmlUtilsDataExtractor.extractPositions(),
                (pos) -> pos.getSalary() == salary);
    }

    @Override
    public List<Position> showByIdTemplate(String id) {
        String template = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(XmlUtilsDataExtractor.extractPositions(),
                (pos) -> String.valueOf(pos.getId()).matches(template));
    }

    @Override
    public List<Position> showByNameTemplate(String name) {
        String template = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showPosition(XmlUtilsDataExtractor.extractPositions(),
                (pos) -> pos.getName().matches(template));
    }

    @Override
    public List<Position> showBySalaryTemplate(String salary) {
        String template = salary.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(XmlUtilsDataExtractor.extractPositions(),
                (pos) -> String.valueOf(pos.getSalary()).matches(template));
    }

    private List<Position> removePosition(List<Position> positions, Predicate<Position> condition) {
        for (int i = 0; i < positions.size(); i++) {
            if (condition.test(positions.get(i))) {
                positions.remove(i);
            }
        }
        return positions;
    }

    private List<Position> showPosition(List<Position> positions, Predicate<Position> condition) {
        List<Position> result = new ArrayList<>();
        for (Position pos : positions) {
            if (condition.test(pos)) {
                result.add(pos);
            }
        }
        return positions;
    }

    private String updateXml(Predicate<Position> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Position> positions = XmlUtilsDataExtractor.extractPositions();
        for (String str : arguments) {
            String[] fieldValue = str.split("=");
            switch (fieldValue[0]) {
                case "name":
                    positions = updateFields(positions, condition, (pos) -> pos.setName(fieldValue[1]));
                    break;
                case "salary":
                    try {
                        double argument = Double.parseDouble(fieldValue[1]);
                        positions = updateFields(positions, condition, (pos) -> pos.setSalary(argument));
                        break;
                    } catch (NumberFormatException e) {
                        return "isn`t a digit!";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return "not enough arguments!";
                    }
            }
        }
        XmlUtilsDataExtractor.updatePositions(positions);
        return "departments update";
    }

    private List<Position> updateFields(List<Position> positions, Predicate<Position> condition1,
                                        Consumer<Position> condition2) {
        for (Position pos : positions) {
            if (condition1.test(pos)) {
                condition2.accept(pos);
            }
        }
        return positions;
    }
}
