package test_IG.menu;

import test_IG.io.UsersConsoleInput;
import test_IG.util.UsersUtil;

import java.util.Scanner;

public class UserChoiceMenu {
    private final Scanner scanner;

    public UserChoiceMenu() {
        scanner = new Scanner(System.in);
    }

    public  void printUserChoiceMenu() {
        System.out.println("ВЫБОР ПОЛЬЗОВАТЕЛЯ");
        System.out.println("Ведите порядковый номер пользователя");


    }

    public  int startUserChoice(int length) {
        int key=0;
            do {
                printUserChoiceMenu();
                System.out.print("Ваш выбор от 1 до "+ length+ ": ");
                String s = scanner.next();
                try {
                     Integer.parseInt(s);
                } catch (NumberFormatException e){
                    System.out.println("Неверный ввод");
                    continue;
                }
                key = Integer.parseInt(s);


            } while (key<1 || key>length);
        return key;
    }
}
