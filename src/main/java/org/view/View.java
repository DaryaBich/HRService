package org.view;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void instruction(){
        System.out.println("Инструкция по работе с приложением:\nОбщая запись команды: команда/таблица/условие \n" +
                "Условие может быть: \n1) all - сделать действие со всеми записями. Например: show/department/all"+
                " - show все записи таблицы department\n2) другое условие, например: "+
                "show/employee/id/5 - show будет применено ко всем записям employee, у которых id = 5\n Список команд:"+
                "\n 1) show - вывести на экран записи. Например: show/position/name/HR\n2) remove - удалить записи."+
                " Например: remove/employee/seniority/2\n3) add from file - добавить записи из другого файла, здесь "+
                "условием будет путь к файлу, из которого будут считываться записи. \nНапример: add from file/"+
                "position/C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml\n4) add - добавить элемент, на месте"+
                " условия здесь будут поля сущности и их значения, обратите внимание id записи не вводится. \nНапример:"
                +" add/department/name/Developers/chiefId/2\n5) show by template - вывести записи, удовлетворяющие" +
                " введенному шаблону. Например: show by template/employee/1*\n6) update - обновить запись. В условии"+
                " указывается, какие записи следует обновить, например employee/idDepartment/1.\nПример такого запроса"+
                " update/position/salary/25000. После ввода команды будет выведено предложение ввода полей и их новых "+
                "значений");
        System.out.println("Таблицы и их поля:\nEmployee: id, fio, idDepartment, phoneNumber, seniority, idPosition \n"+
                "Position: id, name, salary\nDepartment: id, name, chiefId\n");

    }
    public static void inputData(){
        System.out.println("Введите команду:\n");
    }
    public static String[] inputUpdateArguments(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите поля для изменения в формате: поле1=значение1,поле2=значение2");
        String[] inputString = in.nextLine().split(",");
        in.close();
        return inputString;
    }
}
