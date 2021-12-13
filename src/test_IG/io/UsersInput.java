package test_IG.io;


import test_IG.entity.Users;

public interface UsersInput {

    public  Users UserCreate();

    public  Users UserRead(int index);

    public  Users UserUpdate (Users user, int menuItem);

    public void UserDelete(int i);
}
