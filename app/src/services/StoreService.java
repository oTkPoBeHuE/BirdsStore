package services;

import model.abstractstore.Money;

/**
 * Created by oTk on 29.11.2016.
 */
public class StoreService {
    private static StoreService ourInstance = new StoreService();

    public static StoreService getInstance() {
        return ourInstance;
    }

    private StoreService() {
    }

    public void buy(String username, String password, String productname, int count){
        checkUserExist(username);
        checkPassword(username, password);
        checkProduct(productname);
        checkProductCount(productname, count);


        Money totalAmount = StorageService.getInstance().getPrice(productname).pow(count);
        checkUserMoney(productname, totalAmount);

        UserService.getInstance().getUser(username);

        StorageService.getInstance().release(productname, count);
        UserService.getInstance().setMoney(username, UserService.getInstance().getUser(username).getMoney().subtract(totalAmount));

    }

    public void checkPassword(String username, String password) {
        //TODO:: exception
    }

    public void checkUserExist(String username) {
        //TODO:: exception
    }

    public void checkProduct(String name){
        //TODO:: exception
    }
    public void checkProductCount(String productName, int  count){
        //TODO:: exception
    }
    public void checkUserMoney(String username, Money totalAmount){
        if(!UserService.getInstance().getUser(username).getMoney().amountExist(totalAmount)){
            //TODO:: exception
        }
    }


}
