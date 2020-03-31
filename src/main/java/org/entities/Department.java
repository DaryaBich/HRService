package org.entities;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private int chiefId;

    public Department(int id, String name, int chiefIdEmployee) {
        this.id = id;
        this.name = name;
        this.chiefId = chiefIdEmployee;
    }

    @Override
    public String toString() {
        return "Department: " +
                "id = " + id +
                " | name = " + name +
                " | chief Id = " + chiefId +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return chiefId == that.chiefId&&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chiefId);
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

    public Department() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }

    public int getChiefId() {
        return chiefId;
    }
}
