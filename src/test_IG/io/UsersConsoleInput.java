package test_IG.io;

import test_IG.entity.Roles;
import test_IG.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class UsersConsoleInput implements UsersInput {

    @Override
    public Users  UserCreate(){
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        Roles[] roles = new Roles[2];
        String[] mobilePhones= new String[3];

        System.out.println("СОЗДАНИЕ ПОЛЬЗОВАТЕЛЯ");
        System.out.print("Введите Имя: ");
        String firstName = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Фамилию: ");
        String lastName = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Email: ");
        String email = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Роль: ");
        roles[0] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        System.out.print("Введите Роль: ");
        roles[1] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        System.out.print("Введите Телефон: ");
        mobilePhones[0] = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Телефон: ");
        mobilePhones[1] = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Телефон: ");
        mobilePhones[2] = usersConsoleInput.getValue().nextLine();



        return new Users (firstName, lastName, email, roles, mobilePhones);
    }

    @Override
    public Users  UserCreate(Users user){
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        Roles[] roles = new Roles[2];
        String[] mobilePhones= new String[3];

        System.out.println("РЕДАКТИРОВАНИЕ ПОЛЬЗОВАТЕЛЯ");
        System.out.print("Введите Имя: ");
        String firstName = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Фамилию: ");
        String lastName = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Email: ");
        String email = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Роль: ");
        roles[0] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        System.out.print("Введите Роль: ");
        roles[1] = Roles.valueOf(usersConsoleInput.getValue().nextLine());
        System.out.print("Введите Телефон: ");
        mobilePhones[0] = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Телефон: ");
        mobilePhones[1] = usersConsoleInput.getValue().nextLine();
        System.out.print("Введите Телефон: ");
        mobilePhones[2] = usersConsoleInput.getValue().nextLine();

        return new Users (firstName, lastName, email, roles, mobilePhones);
    }

    public static Users UserRead(int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();
        Users user= users.get(index-1);

        return user;
    }

    public static List<Users> AllUsersRead() {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        return users;
    }

    @Override
    public void UserUpdate(Users userUpd, int index) {
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

    @Override
    public void UserDelete(int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        users.remove(index-1);

        UsersFileWriter fullInfoFileWriter = new UsersFileWriter(users);
        fullInfoFileWriter.writeAll(USERS_SOURCE_FILE);
    }






    public <T> Scanner getValue() {

        Scanner sc = new Scanner(System.in);

        return sc;
    }


}
