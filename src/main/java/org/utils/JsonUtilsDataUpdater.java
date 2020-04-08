package org.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonUtilsDataUpdater {
    public static void updateEmployees(List<Employee> employees, String filepath){
        Gson gson = new Gson(); //Create a Gson object
        try
        {
            FileWriter fileWriter = new FileWriter(filepath);
            for (Employee employee:employees) {
                fileWriter.write(gson.toJson(employee));
            }
           fileWriter.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void updateDepartments(List<Department> departments, String filepath) {
        Gson gson = new Gson(); //Create a Gson object
        try {
            FileWriter fileWriter = new FileWriter(filepath);
            for (Department department:departments) {
                fileWriter.write(gson.toJson(department));
            }
            fileWriter.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void updatePositions(List<Position> positions, String filepath) {
        Gson gson = new Gson(); //Create a Gson object
        try {
            FileWriter fileWriter = new FileWriter(filepath);
            for (Position position:positions) {
                fileWriter.write(gson.toJson(position));
            }
            fileWriter.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
