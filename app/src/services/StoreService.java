package services;

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
        checkUsername(username);
        checkPassword(username, password);
        checkProduct(productname);
        checkProductCount(productname, count);



    }

    private void checkPassword(String username, String password) {
        //TODO:: exception
    }

    private void checkUsername(String username) {
        //TODO:: exception
    }


    private void checkProduct(String name){
        //TODO:: exception
    }
    private void checkProductCount(String productName, int  count){
        //TODO:: exception
    }


}
