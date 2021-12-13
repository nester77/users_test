package test_IG.menu;

import test_IG.entity.Users;
import test_IG.io.UsersConsoleInput;
import test_IG.io.UsersFileReader;
import test_IG.io.UsersFileWriter;
import test_IG.util.UsersUtil;

import java.util.List;
import java.util.Scanner;

import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class MainMenu {
    private final Scanner scanner;

    public MainMenu() {
       scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println("");
        System.out.println("ПРИЛОЖЕНИЕ 'ПОЛЬЗОВАТЕЛИ'");
        System.out.println("МЕНЮ");
        System.out.println("1. Вывести всех пользователей");
        System.out.println("2. Вывести информацию о пользователе");
        System.out.println("3. Создать нового пользователя");
        System.out.println("4. Редактировать пользователя");
        System.out.println("5. Удалить пользователя");
        System.out.println("0. Выйти из программы");

    }

    public void start() {
        int key=0;
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        UserChoiceMenu userChoiceMenu = new UserChoiceMenu();
        do {
            printMainMenu();
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
                    UsersUtil.printAllUsers(usersConsoleInput.AllUsersRead());
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("ИНФОРМАЦИЯ. ");
                    UsersUtil.printUser(usersConsoleInput.UserRead(userChoiceMenu.startUserChoice(UsersUtil.getLengthList())));
                    break;
                case 3:
                    UsersFileReader reader_users3 = new UsersFileReader(USERS_SOURCE_FILE);
                    List<Users> users3 = reader_users3.readItems();
                    users3.add(usersConsoleInput.UserCreate());
                    UsersFileWriter fullInfoFileWriter3 = new UsersFileWriter(users3);
                    fullInfoFileWriter3.writeAll(USERS_SOURCE_FILE);
                    break;
                case 4:
                    System.out.println("");
                    System.out.print("ИЗМЕНЕНИЕ. ");
                    UserUpdateMenu userUpdateMenu = new UserUpdateMenu();
                    userUpdateMenu.startUserUpdate(userChoiceMenu.startUserChoice(UsersUtil.getLengthList()));

                    break;
                case 5:
                    System.out.println("");
                    System.out.print("УДАЛЕНИЕ. ");
                    usersConsoleInput.UserDelete(userChoiceMenu.startUserChoice(UsersUtil.getLengthList()));

                    break;
                case 0:
                    System.out.println("Завершение программы...");
                    break;
                default:
                    System.out.println("Вы ввели неверное значение пункта меню!");
            }
        } while (key != 0);
    }
}

