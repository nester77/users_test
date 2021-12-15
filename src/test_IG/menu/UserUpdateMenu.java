package test_IG.menu;

import test_IG.entity.Users;
import test_IG.io.UsersConsoleInput;
import test_IG.io.UsersFileReader;
import test_IG.io.UsersFileWriter;
import test_IG.util.UsersUtil;

import java.util.List;
import java.util.Scanner;

import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class UserUpdateMenu {
    private final Scanner scanner;

    public UserUpdateMenu() {
        scanner = new Scanner(System.in);
    }

    public void printUserUpdateMenu() {
        System.out.println("");
        System.out.println("РЕДАКТИРОВАНИЕ ПОЛЬЗОВАТЕЛЯ");
        System.out.println("МЕНЮ");
        System.out.println("1. Редактировать ИМЯ");
        System.out.println("2. Редактировать ФАМИЛИЮ");
        System.out.println("3. Редактировать Email");
        System.out.println("4. Редактировать РОЛИ");
        System.out.println("5. Редактировать ТЕЛЕФОН №1");
        System.out.println("6. Редактировать ТЕЛЕФОН №2");
        System.out.println("7. Редактировать ТЕЛЕФОН №3");
        System.out.println("0. Сохранить изменения и выйти из редактирования");

    }

    public void startUserUpdate(int indexUser) {
        int key=0;
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        UsersFileReader readerUsers = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = readerUsers.readItems();
        Users user = users.get(indexUser-1);


        do {
            printUserUpdateMenu();
            UsersUtil.printUser(user);
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
                    System.out.print("Введите новое ИМЯ пользователя: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));

                    break;
                case 2:
                    System.out.print("Введите новую ФАМИЛИЮ пользователя: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));

                    break;
                case 3:
                    System.out.print("Введите новый Email пользователя: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));
                    break;
                case 4:

                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));
                    break;
                case 5:
                    System.out.print("Введите новый ТЕЛЕФОН №1 пользователя или '0' при отсутствии: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));
                    break;
                case 6:
                    System.out.print("Введите новый ТЕЛЕФОН №2 пользователя или '0' при отсутствии: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));
                    break;
                case 7:
                    System.out.print("Введите новый ТЕЛЕФОН №3 пользователя или '0' при отсутствии: ");
                    UsersUtil.printUser(usersConsoleInput.userUpdate(user, key));
                    break;
                case 0:
                    System.out.println("Сохранение именений...");
                    break;
                default:
                    System.out.println("Вы ввели неверное значение пункта меню!");
            }
        } while (key != 0);
        UsersFileWriter fullInfoFileWriter = new UsersFileWriter(users);
        fullInfoFileWriter.writeAll(USERS_SOURCE_FILE);
    }
}
