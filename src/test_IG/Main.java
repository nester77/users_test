package test_IG;

import test_IG.entity.Roles;
import test_IG.entity.Users;
import test_IG.io.UsersConsoleInput;
import test_IG.io.UsersFileReader;
import test_IG.io.UsersFileWriter;

import java.util.List;


import static test_IG.entity.Roles.ADMIN;
import static test_IG.entity.Roles.PROVIDER;
import static test_IG.io.FilePathConstants.USERS_SOURCE_FILE;

public class Main {

    public static void main(String[] args) {

        UsersFileReader reader_users = new UsersFileReader(USERS_SOURCE_FILE);
        List<Users> users = reader_users.readItems();

        System.out.println(users);

//        Roles[] roles ={ADMIN, PROVIDER};
//        String[] phones ={"jfkkjkg","ghghfgf","ghgh"};
//
//        Users user1 = new Users("trjjh","hsddsr","jkjkghgh@hjh.de", roles, phones);
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



    }

}
