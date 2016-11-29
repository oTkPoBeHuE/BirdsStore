package services;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import model.abstractstore.Money;
import utils.Utilities;

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

    public void buy(String username, String password, String productname, int count)
            throws AuthorisationException,
            UserException,
            ProductException,
            MoneyException
    {
        Utilities.checkUserExist(username);
        Utilities.checkPassword(username, password);
        Utilities.checkProductExist(productname);
        Utilities.checkProductCount(productname, count);


        Money totalAmount = StorageService.getInstance().getPrice(productname).pow(count);

        Utilities.checkUserMoney(productname, totalAmount);

        StorageService.getInstance().release(productname, count);
        UserService.getInstance().setMoney(username, UserService.getInstance().getUser(username).getMoney().subtract(totalAmount));
    }




}
