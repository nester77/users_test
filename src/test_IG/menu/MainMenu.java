package test_IG.menu;

import test_IG.io.UsersConsoleInput;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;

    public MainMenu() {
       scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println("ПРИЛОЖЕНИЕ 'ПОЛЬЗОВАТЕЛИ'");
        System.out.println("МЕНЮ");
        System.out.println("1. Вывести всех пользователей");
        System.out.println("2. Вывести полную информацию о пользователе");
        System.out.println("3. Создать нового пользователя");
        System.out.println("4. Редактировать пользователя");
        System.out.println("5. Удалить пользователя");
        System.out.println("0. Выйти из программы");

    }

    public void start() {
        int key;
        do {
            printMainMenu();
            System.out.print("Введите номер меню: ");



            key = this.scanner.nextInt();

            switch (key) {
                case 1:
                    System.out.println(UsersConsoleInput.AllUsersRead());

                    break;
                case 2:
                    System.out.println(UsersConsoleInput.UserRead(2));

                    break;
                case 3:


                    break;
                case 4:


                    break;
                case 5:


                    break;
                case 0:
                    System.out.println("Завершение программы...");
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 0);
    }
}

