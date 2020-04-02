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
    public static void updateEmployees(List<Employee> employees){
        Gson gson = new Gson(); //Create a Gson object
        try
        {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.json");
            for (Employee employee:employees) {
                fileWriter.write(gson.toJson(employee));
            }
           fileWriter.close();
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }
    public static void updateDepartments(List<Department> departments) {
        Gson gson = new Gson(); //Create a Gson object
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.json");
            for (Department department:departments) {
                fileWriter.write(gson.toJson(department));
            }
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }
    public static void updatePositions(List<Position> positions) {
        Gson gson = new Gson(); //Create a Gson object
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.json");
            for (Position position:positions) {
                fileWriter.write(gson.toJson(position));
            }
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }
}
