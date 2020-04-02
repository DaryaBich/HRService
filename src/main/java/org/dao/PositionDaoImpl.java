package org.dao;

import org.entities.Employee;
import org.entities.Position;
import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;
import org.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PositionDaoImpl implements PositionDao {
private String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml";
    @Override
    public boolean addPosition(boolean fileType, String name, double salary) {
        List<Position> positions = Position.chooseFile(fileType);
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
        Position.updateChoosingFile(fileType, positions);
        return true;
    }

    @Override
    public void removeAll(boolean fileType) {
        Position.updateChoosingFile(fileType, new ArrayList<>());
    }

    @Override
    public boolean removeById(boolean fileType, int id) {
        List<Position> positions = Position.chooseFile(fileType);
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getId() == id);
        if (count != positions.size()) {
            Position.updateChoosingFile(fileType, positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(boolean fileType, String name) {
        List<Position> positions = Position.chooseFile(fileType);
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getName().equals(name));
        if (count != positions.size()) {
            Position.updateChoosingFile(fileType, positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeBySalary(boolean fileType, double salary) {
        List<Position> positions = Position.chooseFile(fileType);
        int count = positions.size();
        positions = removePosition(positions, (pos) -> pos.getSalary() == salary);
        if (count != positions.size()) {
            Position.updateChoosingFile(fileType, positions);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateAll(boolean fileType) {
        return updater(fileType, dep -> true);
    }

    @Override
    public String updateId(boolean fileType, int id) {
        return updater(fileType, pos -> pos.getId() == id);
    }

    @Override
    public String updateName(boolean fileType, String name) {
        return updater(fileType, pos -> pos.getName().equals(name));
    }

    @Override
    public String updateSalary(boolean fileType, double salary) {
        return updater(fileType, pos -> pos.getSalary() == salary);
    }

    @Override
    public Position showById(boolean fileType, int id) {
        List<Position> positions = Position.chooseFile(fileType);
        for (Position pos : positions) {
            if (pos.getId() == id) {
                return pos;
            }
        }
        return null;
    }

    @Override
    public List<Position> showAll(boolean fileType) {
        return Position.chooseFile(fileType);
    }

    @Override
    public List<Position> showByName(boolean fileType, String name) {
        return removePosition(Position.chooseFile(fileType),
                (pos) -> pos.getName().equals(name));
    }

    @Override
    public List<Position> showBySalary(boolean fileType, double salary) {
        return removePosition(Position.chooseFile(fileType),
                (pos) -> pos.getSalary() == salary);
    }

    @Override
    public List<Position> showByIdTemplate(boolean fileType, String id) {
        String template = id.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(Position.chooseFile(fileType),
                (pos) -> String.valueOf(pos.getId()).matches(template));
    }

    @Override
    public List<Position> showByNameTemplate(boolean fileType, String name) {
        String template = name.replace("*", "[0-9a-zA-Zа-яА-Я_№ ]*")
                .replace("?", "[0-9a-zA-Zа-яА-Я_№ ]?");
        return showPosition(Position.chooseFile(fileType),
                (pos) -> pos.getName().matches(template));
    }

    @Override
    public List<Position> showBySalaryTemplate(boolean fileType, String salary) {
        String template = salary.replace("*", "[0-9]*")
                .replace("?", "[0-9]?");
        return showPosition(Position.chooseFile(fileType),
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

    private String updater(boolean fileType, Predicate<Position> condition) {
        String[] arguments = View.inputUpdateArguments();
        List<Position> positions =  Position.chooseFile(fileType);
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
        Position.updateChoosingFile(fileType, positions);
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
