package data;

import model.abstractstore.Money;
import model.abstractstore.Order;
import model.abstractstore.User;
import services.OrdersService;
import services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static javax.swing.UIManager.get;


public class FileSave {
    static final char SEPARATOR = ',';

    public static void saveUserDB(Database<User> userDB, String filename) throws IOException {
        List<String> lines = userDB.findAll()
                .stream()
                .map(user -> user.getName() + SEPARATOR
                        + user.getPassword() + SEPARATOR
                        + user.getMoney())
                .collect(Collectors.toList());

        Files.write(Paths.get(filename), lines);
        //  databaseToLines(userDB, filename, user -> user.getName() + SEPARATOR  + user.getPassword() + SEPARATOR  + user.getMoney());
    }

    public static void saveOrderDB(Database<Order> ordersDB, String filename) throws IOException {
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


    public static void readUserDB(Database<User> userDB, String filename) throws IOException {
        UserService.clear();
        Files.lines(Paths.get(filename))
                .map(line -> Arrays.asList(line.split(String.valueOf(SEPARATOR))))
                .forEach(line -> UserService.createUser(line.get(0), line.get(1), line.get(2)));
    }

//    public static <T>  List<String>    databaseToLines(Database<T> userDB, String filename, Function<T,String> func){
//        return userDB.findAll()
//                .stream()
//                .map(func)
//                .collect(Collectors.toList());
//
//    }


}
