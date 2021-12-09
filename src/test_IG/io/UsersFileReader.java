package test_IG.io;

import test_IG.entity.Users;
import test_IG.util.UsersUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersFileReader {

    private final String filepath;

    public UsersFileReader(String filepath) {
        this.filepath = filepath;
    }

    public List<Users> readItems() {
        List<Users> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Users user = UsersUtil.toObject(line);

                result.add(user);
            }

        } catch (IOException e) {
            System.out.println("Read file error");
        }

        return result;
    }


}
