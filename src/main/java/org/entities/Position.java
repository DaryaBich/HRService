package org.entities;

import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;

import java.util.List;
import java.util.Objects;

public class Position {
    private int id;
    private String name;
    private double salary;

    public Position(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Position: " +
                " id = " + id +
                " | name ='" + name + '\'' +
                " | salary = " + salary +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.salary, salary) == 0 &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position() {
    }
    public static String listPositionsToString(List<Position> positions){
        StringBuilder sBPosition = new StringBuilder();
        for (Position pos : positions) {
            sBPosition.append(pos.toString());
        }
        return sBPosition.toString();
    }
    public static List<Position> chooseFile(boolean fileType){
        String filepathXml = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml";
        String filepathJson = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.json";
        return fileType? XmlUtilsDataExtractor.extractPositions(filepathXml):
                JsonUtilsDataExtractor.extractPositions(filepathJson);
    }
    public static void updateChoosingFile(boolean fileType, List<Position> positions){
        if (fileType){
            XmlUtilsDataUpdater.updatePositions(positions);
        }
        else {
            JsonUtilsDataUpdater.updatePositions(positions);
        }
    }
}
