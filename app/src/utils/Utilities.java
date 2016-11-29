package utils;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import gui.users.SetMoneyWindow;
import model.abstractstore.Money;
import model.abstractstore.User;
import services.StorageService;
import services.UserService;

/**
 * Created by oTk on 29.11.2016.
 */
public final class Utilities {

    private Utilities() {
    }

    public static boolean isCorrectPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    //-----------------------------checks---------------------------------------------------//
    public static void checkPassword(String username, String password) throws AuthorisationException {
        if (!Utilities.isCorrectPassword(UserService.getUser(username), password))
            throw new AuthorisationException(ExceptionMessages.WRONG_PASSWORD);
    }

    public static void checkUserExist(String username) throws UserException {
        if (!UserService.containsUser(username))
            throw new UserException(ExceptionMessages.USER_NOT_FOUND);
    }

    public static void checkProductExist(String name) throws ProductException {
        if (!StorageService.getInstance().containsProduct(name))
            throw new ProductException(ExceptionMessages.PRODUCT_NOT_FOUND);
    }

    public static void checkProductCount(String productName, int count) throws ProductException {
        if (!StorageService.getInstance().containsProductCount(productName, count))
            throw new ProductException(ExceptionMessages.NOT_ENOUGH_PRODUCTS);
    }

    public static void checkUserMoney(String username, Money totalAmount) throws MoneyException {
        Money userMoney = UserService.getUser(username).getMoney();
        if (!userMoney.amountExist(totalAmount)) {
            throw new MoneyException(ExceptionMessages.NOT_ENOUGH_MONEY);
        }
    }



}
