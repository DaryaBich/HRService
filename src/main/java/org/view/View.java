package org.view;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void welcome(){
        System.out.println("Приветствие");
    }
    public static void instruction(){
        System.out.println("Инструкция по работе с приложением");
    }
    public static void inputData(){
        System.out.println("Введите команду:\n");
    }
    public static void oops(){
        System.out.println("Похожe такая команда отсутствует, попробуйте еще!\n");
    }
    public static String[] inputUpdateArguments(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите поля для изменения в формате: поле1=значение1,поле2=значение2");
        String[] inputString = in.nextLine().split(",");
        in.close();
        return inputString;
    }
}
