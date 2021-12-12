package test_IG;

import test_IG.entity.Roles;
import test_IG.entity.Users;
import test_IG.io.UsersConsoleInput;
import test_IG.io.UsersFileReader;
import test_IG.io.UsersFileWriter;
import test_IG.menu.MainMenu;

import java.util.List;
import java.util.Scanner;


import static test_IG.entity.Roles.*;
import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class Main {

    public static void main(String[] args) {

        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();
        int i=1;
        for (Users user : users) {

            System.out.print(i+ ". ");
            System.out.println(
                    "Имя:     " + user.getFirstName() + "   " +
                            "Фамилия: " + user.getLastName() + "   " +
                            "Почта:   " + user.getEmail() );
            i++;
        }
//
//        System.out.println(users);

//        Roles[] roles ={ADMIN, EMPTY};
//        String[] phones ={"","5451151","0"};
//
//        Users user = new Users("trjjh","hsddsr","jkjkghgh@hjh.de", roles, phones);
//
//        System.out.println(
//               "Имя:     " + user.getFirstName() + '\n' +
//               "Фамилия: " + user.getLastName() + '\n' +
//               "Почта:   " + user.getEmail() );
//
//        if (user.getRoles()[0]!=EMPTY) System.out.println("Роль :   " + user.getRoles()[0]);
//        if (user.getRoles()[1]!=EMPTY) System.out.println("Роль :   " + user.getRoles()[1]);
//
//        if (user.getMobilePhones()[0]!="") System.out.println("Телефон: " + user.getMobilePhones()[0]);
//        if (user.getMobilePhones()[1]!="") System.out.println("Телефон: " + user.getMobilePhones()[1]);
//        if (user.getMobilePhones()[2]!="") System.out.println("Телефон: " + user.getMobilePhones()[2]);




//        UsersConsoleInput.UserUpdate (user1,6);
//
//        System.out.println(users);

//        users.add(user1);



//        users.add(UsersConsoleInput.UserCreate ());
//        System.out.println(users);
//
//
//        UsersFileWriter fullInfoFileWriter = new UsersFileWriter(users);
//        fullInfoFileWriter.writeAll(USERS_SOURCE_FILE);
//        System.out.println(users);

//        UsersConsoleInput.UserDelete (3);

//        System.out.println();
//        System.out.println(UsersConsoleInput.UserRead (1));



//        MainMenu mainMenu = new MainMenu();
//        mainMenu.start();

    }

}
