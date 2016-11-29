package services;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import model.abstractstore.Money;
import utils.Utilities;


public class StoreService {
    private static StoreService ourInstance = new StoreService();

    private StoreService() {
    }

    public static StoreService getInstance() {
        return ourInstance;
    }

    public void buy(String username, String password, String productname, int count)
            throws AuthorisationException,
            UserException,
            ProductException,
            MoneyException {
        Utilities.checkUserNameFormat(username);
        Utilities.checkPasswordFormat(password);
        Utilities.checkCountFormat(count);

        Utilities.checkUserExist(username);
        Utilities.checkPassword(username, password);
        Utilities.checkProductExist(productname);
        Utilities.checkProductCount(productname, count);


        Money totalAmount = StorageService.getInstance().
                getPrice(productname).
                multiply(Money.parseMoney(Integer.toString(count)));

        Utilities.checkUserMoney(username, totalAmount);

        Money resultAmount = UserService.getUser(username).getMoney().subtract(totalAmount);

        StorageService.getInstance().release(productname, count);
        UserService.setMoney(username, resultAmount);

        OrdersService.generateOrder(productname, username, totalAmount, count);

    }


}
