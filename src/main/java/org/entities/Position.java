package org.entities;

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
                " | name='" + name + '\'' +
                " | salary=" + salary +
                '\n';
    }
}
