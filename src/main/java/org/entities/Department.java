package org.entities;

public class Department {
    private int id;
    private String name;
    private int chiefIdEmployee;

    public Department(int id, String name, int chiefIdEmployee) {
        this.id = id;
        this.name = name;
        this.chiefIdEmployee = chiefIdEmployee;
    }
}
