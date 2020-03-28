package org.view;

import java.util.Scanner;

public class View {
    private Scanner in;
    public void welcome(){
        in = new Scanner(System.in);
        System.out.println("Приветствие");
        in.close();
    }
    public void instruction(){
        in = new Scanner(System.in);
        System.out.println("Инструкция по работе с приложением");
        in.close();
    }
    public void inputData(){
        System.out.println("Введите команду:\n");
    }
    public void oops(){
        System.out.println("Похожу такая команда отсутствует, попробуйте еще!\n");
    }
}
