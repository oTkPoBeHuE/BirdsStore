package data;

import model.abstractstore.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oTk on 29.11.2016.
 */
public class FileSave {

    public static void saveDB(Database<User> userDB, String filename) throws IOException {
        List<String> lines = userDB.findAll()
                .stream()
                .map(user -> user.getName() + "," + user.getPassword() + "," + user.getMoney())
                .collect(Collectors.toList());
        Files.write(Paths.get(filename), lines);
    }

    public static void readDB(Database<User> userDB, String filename) throws IOException {
       // Files.lines(Paths.get(filename)).flatMap()
    }

}
