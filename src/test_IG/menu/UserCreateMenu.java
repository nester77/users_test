package test_IG.menu;

import java.util.Scanner;

public class UserCreateMenu {

    private final Scanner scanner;

    public UserCreateMenu() {
        scanner = new Scanner(System.in);
    }

    public void printUserCreateMenu() {
        System.out.println("СОЗДАНИЕ ПОЛЬЗОВАТЕЛЯ");
        System.out.println("Ведите порядковый номер пользователя");
    }
}