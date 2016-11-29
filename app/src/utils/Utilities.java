package utils;

import exceptions.AuthorisationException;
import exceptions.MoneyException;
import exceptions.ProductException;
import exceptions.UserException;
import gui.utils.Settings;
import model.abstractstore.Money;
import model.abstractstore.User;
import services.StorageService;
import services.UserService;

import java.util.regex.Pattern;

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

    public static void checkUserNameFormat(String username) throws UserException {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{"+ Settings.USERNAME_MIN_LENGTH+","+ Settings.USERNAME_MAX_LENGTH +"}$");
        if (username == null || !p.matcher(username).matches() ) {
            throw new UserException(ExceptionMessages.INVALID_USERNAME + " " + username);
       }
    }
    public static void checkPasswordFormat(String password) throws UserException {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{"+ Settings.PASSWORD_MIN_LENGTH+","+ Settings.PASSWORD_MAX_LENGTH+"}$");
        if (password == null || !p.matcher(password).matches() ) {
            throw new UserException(ExceptionMessages.INVALID_PASSWORD_FORMAT + " " + password);
        }
    }

    public static void checkCountFormat(int count) throws ProductException {
        if (count < 0) {
            throw new ProductException(ExceptionMessages.INVALID_NUMBER_FORMAT + " " + count);
        }
    }

    public static void checkMoneyFormat(Money money) throws MoneyException {
        if (!money.amountExist(Money.parseMoney("0"))) {
            throw new MoneyException(ExceptionMessages.INVALID_MONEY_FORMAT + " " + money.toString());
        }
    }

    public static void checkProductFormat(String name) throws ProductException {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{"+ Settings.PRODUCTNAME_MIN_LENGTH+","+ Settings.PRODUCT_NAME_MAX_LENGTH +"}$");
        if (name == null || !p.matcher(name).matches() ) {
            throw new ProductException(ExceptionMessages.INVALID_USERNAME + " " +name);
        }
    }


}
