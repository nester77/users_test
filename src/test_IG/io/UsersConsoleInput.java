package test_IG.io;

import test_IG.entity.Roles;
import test_IG.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class UsersConsoleInput implements UsersInput {


    public static Users  UserCreate(){
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        Roles[] roles = new Roles[2];
        String[] mobilePhones= new String[3];


        String firstName = usersConsoleInput.getValue().nextLine();
        String lastName = usersConsoleInput.getValue().nextLine();
        String email = usersConsoleInput.getValue().nextLine();
        roles[0] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        roles[1] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        mobilePhones[0] = usersConsoleInput.getValue().nextLine();
        mobilePhones[1] = usersConsoleInput.getValue().nextLine();
        mobilePhones[2] = usersConsoleInput.getValue().nextLine();



        return new Users (firstName, lastName, email, roles, mobilePhones);
    }


    public static Users UserRead(int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();
        Users user= users.get(index-1);

        return user;
    }

    public static void UserUpdate(Users userUpd, int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        users.get(index-1).setFirstName(userUpd.getFirstName());
        users.get(index-1).setLastName(userUpd.getLastName());
        users.get(index-1).setEmail(userUpd.getEmail());
        users.get(index-1).setRoles(userUpd.getRoles());
        users.get(index-1).setMobilePhones(userUpd.getMobilePhones());

        UsersFileWriter fullInfoFileWriter = new UsersFileWriter(users);
        fullInfoFileWriter.writeAll(USERS_SOURCE_FILE);
    }

    public static void UserDelete(int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        UsersFileWriter fullInfoFileWriter = new UsersFileWriter(users);
        fullInfoFileWriter.writeAll(USERS_SOURCE_FILE);
    }


    public <T> Scanner getValue() {

        Scanner sc = new Scanner(System.in);

        return sc;
    }


}
