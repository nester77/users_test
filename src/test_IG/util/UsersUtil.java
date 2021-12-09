package test_IG.util;

import test_IG.entity.Roles;
import test_IG.entity.Users;

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
}



