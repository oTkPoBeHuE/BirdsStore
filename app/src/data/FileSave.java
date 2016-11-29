package data;

import model.abstractstore.Order;
import model.abstractstore.User;
import services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FileSave {
    static final char SEPARATOR = ',';

    public static void saveUserDB(DAO<User> userDB, String filename) throws IOException {
        List<String> lines = userDB.findAll()
                .stream()
                .map(user -> user.getName() + SEPARATOR
                        + user.getPassword() + SEPARATOR
                        + user.getMoney())
                .collect(Collectors.toList());

        Files.write(Paths.get(filename), lines);
    }

    public static void readUserDB(DAO<User> userDB, String filename) throws IOException {
        UserService.clear();
        Files.lines(Paths.get(filename))
                .map(line -> Arrays.asList(line.split(String.valueOf(SEPARATOR))))
                .forEach(line -> UserService.createUser(line.get(0), line.get(1), line.get(2)));
    }


    public static void saveOrderDB(DAO<Order> ordersDB, String filename) throws IOException {
        List<String> lines = ordersDB.findAll()
                .stream()
                .map(order -> order.getID() + SEPARATOR
                        + order.getProductName() + SEPARATOR
                        + order.getUserName() + SEPARATOR
                        + order.getTotalAmount().toString() + SEPARATOR
                        + Integer.toString(order.getCount()) + SEPARATOR
                        + order.getLocalTime() + SEPARATOR)
                .collect(Collectors.toList());

        Files.write(Paths.get(filename), lines);
    }



}
