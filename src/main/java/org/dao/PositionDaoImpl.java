package org.dao;

import org.ApplicationContext;
import org.entities.Position;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PositionDaoImpl implements PositionDao {
private String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml";
    @Override
    public boolean addPosition(String name, double salary) {
        List<Position> positions = ApplicationContext.getDataAccessor().extractPositions();
        int maxId = positions.size() + 1;
        Position position = new Position(positions.size() + 1, name, salary);
        for (Position pos : positions) {
            if (pos.equals(position)) {
                return false;
            }
            if (pos.getId() > maxId) {
                maxId = pos.getId();
            }
        }
        position.setId(maxId + 1);
        positions.add(position);
        ApplicationContext.getDataAccessor().updatePositions(positions);
        return true;
    }

    @Override
    public void removeAll() {
        ApplicationContext.getDataAccessor().updatePositions(new ArrayList<>());
    }

    @Override
    public boolean removeById(int id) {
        List<Position> positions = ApplicationContext.getDataAccessor().extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getId() == id);
        if (count != positions.size()) {
            ApplicationContext.getDataAccessor().updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(String name) {
        List<Position> positions = ApplicationContext.getDataAccessor().extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getName().equals(name));
        if (count != positions.size()) {
            ApplicationContext.getDataAccessor().updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeBySalary(double salary) {
        List<Position> positions = ApplicationContext.getDataAccessor().extractPositions();
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getSalary() == salary);
        if (count != positions.size()) {
            ApplicationContext.getDataAccessor().updatePositions(positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateAll() {
        return updater(dep -> true);
    }

    @Override
    public String updateId(int id) {
        return updater(pos -> pos.getId() == id);
    }

    @Override
    public String updateName(String name) {
        return updater(pos -> pos.getName().equals(name));
    }

    @Override
    public String updateSalary(double salary) {
        return updater(pos -> pos.getSalary() == salary);
    }

    @Override
    public Position showById(int id) {
        List<Position> positions = ApplicationContext.getDataAccessor().extractPositions();
        for (Position pos : positions) {
            if (pos.getId() == id) {
                return pos;
            }
        }
        return null;
    }

    @Override
    public List<Position> showAll() {
        return ApplicationContext.getDataAccessor().extractPositions();
    }

    @Override
    public List<Position> showByName(String name) {
        return removePosition(ApplicationContext.getDataAccessor().extractPositions(),
                (pos) -> pos.getName().equals(name));
    }

    @Override
    public List<Position> showBySalary(double salary) {
        return removePosition(ApplicationContext.getDataAccessor().extractPositions(),
                (pos) -> pos.getSalary() == salary);
    }

    @Override
    public List<Position> showByIdTemplate(String id) {
        String template = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(ApplicationContext.getDataAccessor().extractPositions(),
                (pos) -> String.valueOf(pos.getId()).matches(template));
    }

    @Override
    public List<Position> showByNameTemplate(String name) {
        String template = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showPosition(ApplicationContext.getDataAccessor().extractPositions(),
                (pos) -> pos.getName().matches(template));
    }

    @Override
    public List<Position> showBySalaryTemplate(String salary) {
        String template = salary.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(ApplicationContext.getDataAccessor().extractPositions(),
                (pos) -> String.valueOf(pos.getSalary()).matches(template));
    }

    private List<Position> removePosition(List<Position> positions, Predicate<Position> condition) {
        for (int i = 0; i < positions.size(); i++) {
            if (condition.test(positions.get(i))) {
                positions.remove(i);
                i = -1;
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

    private String updater(Predicate<Position> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Position> positions =  ApplicationContext.getDataAccessor().extractPositions();
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
        ApplicationContext.getDataAccessor().updatePositions(positions);
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
