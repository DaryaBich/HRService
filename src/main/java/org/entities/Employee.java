package org.entities;

public class Employee {
    private int id;
    private String FIO;
    private int idDepartment;
    private String phoneNumber;
    private int seniority;
    private int idPosition;

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
                " | Seniority =" + seniority +
                " | Position=" + idPosition +
                '\n';
    }
}
