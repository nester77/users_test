package test_IG.io;

import test_IG.entity.Roles;
import test_IG.entity.Users;
import test_IG.menu.RolesChoiceMenu;
import test_IG.validators.Validators;

import java.util.*;

import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class UsersConsoleInput implements UsersInput {

    @Override
    public Users userCreate(){
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();
        Roles[] roles = new Roles[2];
        String[] mobilePhones= new String[3];

        System.out.println();
        System.out.println("СОЗДАНИЕ ПОЛЬЗОВАТЕЛЯ");

        String firstName;
        System.out.print("Введите Имя: ");
        do {
        firstName = usersConsoleInput.getValue().nextLine().trim();
        } while (!Validators.nameValidator(firstName));

        String lastName;
        System.out.print("Введите Фамилию: ");
        do {
        lastName = usersConsoleInput.getValue().nextLine().trim();
        } while (!Validators.nameValidator(lastName));

        System.out.print("Введите Email: ");
        String email;
        do {
            email = usersConsoleInput.getValue().nextLine().trim();
        } while (!Validators.emailValidator(email));
        RolesChoiceMenu rolesChoiceMenu = new RolesChoiceMenu();
        do {
            roles[0] = rolesChoiceMenu.startRolesChoiceMenu(1);
            roles[1] = rolesChoiceMenu.startRolesChoiceMenu(2);
        } while (!Validators.rolesValidator(roles));

        System.out.print("Введите Телефон №1 или '0' при отсутствии: ");
        do {
            mobilePhones[0] = usersConsoleInput.getValue().nextLine().trim();
        } while (!Validators.mobilePhoneValidator(mobilePhones[0]));
        System.out.print("Введите Телефон №2 или '0' при отсутствии: ");
        do {
            mobilePhones[1] = usersConsoleInput.getValue().nextLine().trim();
        } while (!Validators.mobilePhoneValidator(mobilePhones[1]));
        System.out.print("Введите Телефон №3 или '0' при отсутствии: ");
        do {
            do {
                mobilePhones[2] = usersConsoleInput.getValue().nextLine().trim();
            } while (!Validators.mobilePhoneValidator(mobilePhones[2]));
        }while (!Validators.mobilePhonesValidator(mobilePhones));

        return new Users (firstName, lastName, email, roles, mobilePhones);
    }


    @Override
    public Users userRead(int index) {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();
        Users user= users.get(index-1);

        return user;
    }

    @Override
    public List<Users> allUsersRead() {
        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        return users;
    }

    @Override
    public Users userUpdate(Users user, int menuItem) {
        UsersConsoleInput usersConsoleInput = new UsersConsoleInput();

        switch (menuItem) {
            case 1:
                do {
                user.setFirstName(usersConsoleInput.getValue().nextLine().trim());
                } while (!Validators.nameValidator(user.getFirstName()));
                break;
            case 2:
                do {
                user.setLastName(usersConsoleInput.getValue().nextLine().trim());
                } while (!Validators.nameValidator(user.getLastName()));
                break;
            case 3:
                do {
                    user.setEmail(usersConsoleInput.getValue().nextLine().trim());
                } while (!Validators.emailValidator(user.getEmail()));
                break;
            case 4:
                RolesChoiceMenu rolesChoiceMenu = new RolesChoiceMenu();
                do {
                    user.getRoles()[0] = rolesChoiceMenu.startRolesChoiceMenu(1);
                    user.getRoles()[1] = rolesChoiceMenu.startRolesChoiceMenu(2);
                } while (!Validators.rolesValidator(user.getRoles()));
                break;

            case 5:
                do {
                    user.getMobilePhones()[0] = usersConsoleInput.getValue().nextLine().trim();
                } while (!Validators.mobilePhoneValidator(user.getMobilePhones()[0]) ||
                         !Validators.mobilePhonesValidator(user.getMobilePhones()));

                break;
            case 6:
                do {
                    user.getMobilePhones()[1] = usersConsoleInput.getValue().nextLine().trim();
                } while (!Validators.mobilePhoneValidator(user.getMobilePhones()[1]) ||
                         !Validators.mobilePhonesValidator(user.getMobilePhones()));

                break;
            case 7:
                do {
                    user.getMobilePhones()[2] = usersConsoleInput.getValue().nextLine().trim();
                } while (!Validators.mobilePhoneValidator(user.getMobilePhones()[2]) ||
                         !Validators.mobilePhonesValidator(user.getMobilePhones()));

                break;
        }
                return user;

    }


    @Override
    public void userDelete(int index) {
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
