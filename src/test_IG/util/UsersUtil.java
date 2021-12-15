package test_IG.util;

import test_IG.entity.Roles;
import test_IG.entity.Users;
import test_IG.io.UsersFileReader;

import java.util.List;

import static test_IG.entity.Roles.EMPTY;
import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

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

    public static void printUser(Users user) {
        System.out.print(
                "Имя: " + user.getFirstName() + "   " +
                "Фамилия: " + user.getLastName() + "   " +
                "Email: " + user.getEmail() + "   ");
        if (user.getRoles()[0]!=EMPTY) System.out.print("Роль №1: " + user.getRoles()[0]+ "   ");
        else {System.out.print("Роль №1: не указана    ");}
        if (user.getRoles()[1]!=EMPTY) System.out.print("Роль №2: " + user.getRoles()[1]+ "   ");
        else {System.out.print("Роль №2: не указана    ");}

        if (!user.getMobilePhones()[0].equals("0")) System.out.print("Телефон №1: " + user.getMobilePhones()[0]+ "   ");
        else {System.out.print("Телефон №1: не указан   ");}
        if (!user.getMobilePhones()[1].equals("0")) System.out.print("Телефон №2: " + user.getMobilePhones()[1]+ "   ");
        else {System.out.print("Телефон №2: не указан   ");}
        if (!user.getMobilePhones()[2].equals("0")) System.out.println("Телефон №3: " + user.getMobilePhones()[2]);
        else {System.out.println("Телефон №3: не указан");}
    }

    public static void printAllUsers(List<Users> users) {
        int i=1;
        for (Users user : users) {
            System.out.print(i+ ". ");
            printUser(user);
            i++;
        }

    }

    public static int getLengthList () {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();
        return users.size();
    }
}




