package org.entities;

public class Employee {
    private int id;
    private String FIO;
    private int idDepartment;
    private String phoneNumber;
    private int seniority;
    private int positionId;

    public Employee(int id, String FIO, int idDepartment,
                    String phoneNumber, int seniority, int position) {
        this.id = id;
        this.FIO = FIO;
        this.idDepartment = idDepartment;
        this.phoneNumber = phoneNumber;
        this.seniority = seniority;
        positionId = position;
    }

    @Override
    public String toString() {
        return "Сотрудник\n" +
                "id = " + id +
                "\n" + FIO +
                "\nDepartment = " + idDepartment +
                "\nPhone = " + phoneNumber + '\'' +
                "\nSeniority =" + seniority +
                "\nPosition=" + positionId +
                '}';
    }
}
