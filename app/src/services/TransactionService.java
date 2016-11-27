package services;

import data.Database;
import data.MemoryDatabase;
import model.Order;
import model.abstractstore.Money;
import model.abstractstore.Product;
import model.abstractstore.User;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

/**
 * Created by oTk on 27.11.2016.
 */
public class TransactionService {
    private static TransactionService ourInstance = new TransactionService();
    public static TransactionService getInstance() {
        return ourInstance;
    }
    private static Database<Order> orders = new MemoryDatabase<>();

    private TransactionService() {
    }


    private static Order generateOrder(Product product, User user, Money totalAmount, int count){
        return new Order(product.getName(), user.getName(), totalAmount, count, LocalDateTime.now());
    }

    private static void payBill(User user, Money totalAmount){
        user.setMoney(user.getMoney().subtract(totalAmount));
    }

    private static void checkUserMoney(User user, Money totalAmount){
        if(!user.getMoney().amountExist(totalAmount));
        //TODO:: exception
    }

    public static  Money getBill(Product product, int count, BiFunction<Product, Integer, Money> discount){
        return discount.apply(product, count);
    }

}
