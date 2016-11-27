package services;

import data.Database;
import data.MemoryDatabase;
import model.abstractstore.Money;
import model.abstractstore.User;

/**
 * Created by oTk on 27.11.2016.
 */
public class UserServices {
    private static Database<User> users = new MemoryDatabase<>();
    private static UserServices ourInstance = new UserServices();

    public static UserServices getInstance() {
        return ourInstance;
    }

    private UserServices() {

    }

    private static void createUser(String username, String password, Money money){
        //TODO: checkUser()
        users.save(username, new User(username, password, money));
    }

    public static boolean containsUser(String username){
        return users.containsKey(username);
    }
}
