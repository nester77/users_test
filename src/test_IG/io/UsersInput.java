package test_IG.io;


import test_IG.entity.Users;

public interface UsersInput {

    public  Users UserCreate();

    Users  UserCreate(Users user);

    public static Users UserRead() {
        return null;
    }


    public  void UserUpdate(Users userUpd, int index);


    public void UserDelete(int i);
}
