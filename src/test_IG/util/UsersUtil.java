package test_IG.util;

import test_IG.entity.Roles;
import test_IG.entity.Users;

import java.util.Arrays;
import java.util.List;

import static test_IG.entity.Roles.EMPTY;

public class UsersUtil {

    public static Users toObject(String line) {
        String[] usersArgs = line.split(";");
        Roles[] roles = new Roles[2];
        String[] mobilePhones= new String[3];

        String firstName = usersArgs[0];
        String lastName = usersArgs[1];
        String email = usersArgs[2];
        roles[0] = Roles.valueOf(usersArgs[3]);
        roles[1] = Roles.valueOf(usersArgs[4]);
        mobilePhones[0] = usersArgs[5];
        mobilePhones[1] = usersArgs[6];
        mobilePhones[2] = usersArgs[7];


        return new Users (firstName, lastName, email, roles, mobilePhones);
    }

    public static String formatForWriting (Users user){
        return user.getFirstName() + ";"
                + user.getLastName() + ";"
                + user.getEmail() + ";"
                + user.getRoles()[0] + ";"
                + user.getRoles()[1] + ";"
                + user.getMobilePhones()[0] + ";"
                + user.getMobilePhones()[1] + ";"
                + user.getMobilePhones()[2] + "\n";
    }

    public void printUser (Users user) {
        System.out.println(
                "Имя:     " + user.getFirstName() + '\n' +
                "Фамилия: " + user.getLastName() + '\n' +
                "Почта:   " + user.getEmail() );

        if (user.getRoles()[0]!=EMPTY) System.out.println("Роль :   " + user.getRoles()[0]);
        if (user.getRoles()[1]!=EMPTY) System.out.println("Роль :   " + user.getRoles()[1]);

        if (user.getMobilePhones()[0]!="") System.out.println("Телефон: " + user.getMobilePhones()[0]);
        if (user.getMobilePhones()[1]!="") System.out.println("Телефон: " + user.getMobilePhones()[1]);
        if (user.getMobilePhones()[2]!="") System.out.println("Телефон: " + user.getMobilePhones()[2]);
    }

    public void printAllUsers (List<Users> users) {
        int i=1;
        for (Users user : users) {

            System.out.print(i+ ". ");
            System.out.println(
                    "Имя:     " + user.getFirstName() + "   " +
                    "Фамилия: " + user.getLastName() + "   " +
                    "Почта:   " + user.getEmail() );
            i++;
        }

    }
}




