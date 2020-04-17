package org.entities;
import org.utils.JsonUtilsDataExtractor;
import org.utils.JsonUtilsDataUpdater;
import org.utils.XmlUtilsDataExtractor;
import org.utils.XmlUtilsDataUpdater;

import java.util.List;
import java.util.Objects;

public class Employee {

    private int id;

    private String FIO;

    private int idDepartment;

    private String phoneNumber;

    private int seniority;

    private int idPosition;

    public Employee() {
    }

    public Employee(int id, String FIO, int idDepartment,
                    String phoneNumber, int seniority, int position) {
        this.id = id;
        this.FIO = FIO;
        this.idDepartment = idDepartment;
        this.phoneNumber = phoneNumber;
        this.seniority = seniority;
        this.idPosition = position;
    }

    @Override
    public String toString() {
        return "Employee: " +
                FIO +
                " | id = " + id +
                " | Department = " + idDepartment +
                " | Phone = " + phoneNumber + '\'' +
                " | Seniority = " + seniority +
                " | Position = " + idPosition +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idDepartment == employee.idDepartment &&
                seniority == employee.seniority &&
                idPosition == employee.idPosition &&
                Objects.equals(FIO, employee.FIO) &&
                Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, idDepartment, phoneNumber, seniority, idPosition);
    }

    public int getId() {
        return id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public void setId(int id) {
        this.id = id;
    }
}
