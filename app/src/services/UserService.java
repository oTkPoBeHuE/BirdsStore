package services;

import data.Database;
import data.MemoryDatabase;
import exceptions.UserException;
import model.abstractstore.Money;
import model.abstractstore.User;
import utils.Utilities;

import java.util.List;

/**
 * Created by oTk on 27.11.2016.
 */
public class UserService {
    private static Database<User> users = new MemoryDatabase<>();

    private UserService() {

    }

    public static User getUser(String username) {
        return users.find(username);
    }

    public static void addUser(String username, String password) throws UserException {
        Utilities.checkUserNameFormat(username);
        Utilities.checkPasswordFormat(password);
        createUser(username, password, Money.parseMoney("0"));
    }

    private static void createUser(String username, String password, Money money) {
        //TODO: checkUser()
        users.save(username, new User(username, password, money));
    }

    public static boolean containsUser(String username) {
        return users.containsKey(username);
    }

    public static int size() {
        return users.size();
    }

    public static List<User> getAllUsers() {
        return users.findAll();
    }

    public static void setMoney(String username, String money) throws UserException {
        setMoney(username, Money.parseMoney(money));
    }

    public static void setMoney(String username, Money money) throws UserException {
        Utilities.checkUserNameFormat(username);
        getUser(username).setMoney(money);
    }
}
