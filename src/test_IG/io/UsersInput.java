package test_IG.io;


import test_IG.entity.Users;

import java.util.List;

public interface UsersInput {

    public Users userCreate();

    public Users userRead(int index);
    public List<Users> allUsersRead();

    public Users userUpdate(Users user, int menuItem);

    public void userDelete(int i);
}
