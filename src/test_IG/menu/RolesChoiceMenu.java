package test_IG.menu;

import test_IG.entity.Roles;

import java.util.Scanner;

import static test_IG.entity.Roles.*;


public class RolesChoiceMenu {
    private final Scanner scanner;

    public RolesChoiceMenu() {
        scanner = new Scanner(System.in);
    }

    public void printRolesChoiceMenu() {
        System.out.println("");
        System.out.println("Выбор РОЛИ пользователя:");
        System.out.println("1. USER");
        System.out.println("2. CUSTOMER");
        System.out.println("3. ADMIN");
        System.out.println("4. PROVIDER");
        System.out.println("5. SUPER_ADMIN");
        System.out.println("0. Оставить роль пустой");

    }


    public Roles startRolesChoiceMenu() {
        int key=0;
        Roles role=EMPTY;

        do {
            printRolesChoiceMenu();

            System.out.print("Введите номер пункта меню: ");
            String s = scanner.next();

            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Вы ввели неверное значение пункта меню!");
                continue;
            }
            key = Integer.parseInt(s);

            switch (key) {
                case 1:
                    role=USER;

                    break;
                case 2:
                    role=CUSTOMER;
                    break;
                case 3:
                    role=ADMIN;
                    break;
                case 4:
                    role=PROVIDER;
                    break;
                case 5:
                    role=SUPER_ADMIN;
                    break;
                case 0:
                    role=EMPTY;
                    break;
                default:
                    System.out.println("Вы ввели неверное значение пункта меню!");
            }
        } while (key<0 || key>5);
        return role;
    }

}
