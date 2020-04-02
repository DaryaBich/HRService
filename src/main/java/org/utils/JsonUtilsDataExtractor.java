package org.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtilsDataExtractor {
    public static List<Employee> extractEmployees(String filepath) {
        List<Employee> employees = new ArrayList<>();
        try {
            // для чтения файла
            FileReader fileReader = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(fileReader);
            // для преобразования файла
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line == null){
                return employees;
            }
            while (line.indexOf("}") > -1 ) {
                Employee employee = gson.fromJson(line.substring(0, line.indexOf("}") + 1), Employee.class);
                employees.add(employee);
                line = line.substring(line.indexOf("}") + 1);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    public static List<Department> extractDepartments(String filepath) {
        List<Department> departments = new ArrayList<>();
        try {
            // для чтения файла
            FileReader fileReader = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(fileReader);
            // для преобразования файла
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line == null){
                return departments;
            }
            while (line.indexOf("}") > -1 ) {
                Department department = gson.fromJson(line.substring(0, line.indexOf("}") + 1), Department.class);
                departments.add(department);
                line = line.substring(line.indexOf("}") + 1);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return departments;
    }

    public static List<Position> extractPositions(String filepath) {
        List<Position> positions = new ArrayList<>();
        try {
            // для чтения файла
            FileReader fileReader = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(fileReader);
            // для преобразования файла
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line == null){
                return positions;
            }
            while (line.indexOf("}") > -1) {
                Position position = gson.fromJson(line.substring(0, line.indexOf("}") + 1), Position.class);
                positions.add(position);
                line = line.substring(line.indexOf("}") + 1);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return positions;
    }
}
