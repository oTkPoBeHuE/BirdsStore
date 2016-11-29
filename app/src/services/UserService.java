package services;

import data.Database;
import data.MemoryDatabase;
import model.abstractstore.Money;
import model.abstractstore.User;

import java.util.List;

/**
 * Created by oTk on 27.11.2016.
 */
public class UserService {
    private Database<User> users = new MemoryDatabase<>();
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {

    }

    public User  getUser(String username){
       return users.read(username);
    }

    public void  addUser(String username, String password){
        createUser(username, password, Money.parseMoney("0"));
    }

    private void createUser(String username, String password, Money money){
        //TODO: checkUser()
        users.save(username, new User(username, password, money));
    }

    public boolean containsUser(String username){
        return users.containsKey(username);
    }

    public boolean checkPassword(String username, String password){
       return users.read(username).getPassword().equals(password);
    }

    public int size() {
        return users.size();
    }

    public List<User> getAllUsers(){
        return users.toList();
    }

    public void setMoney(String username, String money) {
        getUser(username).setMoney(money);
    }
}
