package test_IG.io;

import test_IG.entity.Users;
import test_IG.util.UsersUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UsersFileWriter {

    private List<Users> users;

    public UsersFileWriter(List<Users> users) {
    this.users = users;
    }

    public void writeAll(String nameOfFile) {
        try (FileWriter writer = new FileWriter(nameOfFile)) {
            for (Users userInfo : users) {
                writer.write(UsersUtil.formatForWriting(userInfo));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        }

}


