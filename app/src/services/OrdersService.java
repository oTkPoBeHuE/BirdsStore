package services;

import data.Database;
import data.MemoryDatabase;
import model.abstractstore.Order;
import model.abstractstore.Money;
import model.abstractstore.Product;
import model.abstractstore.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Created by oTk on 27.11.2016.
 */
public class OrdersService {
    private static Database<Order> orders = new MemoryDatabase<>();

    private OrdersService() {
    }


    private static Order generateOrder(String productname, String username, Money totalAmount, int count){
        return new Order(generateID(), productname, username, totalAmount, count, LocalDateTime.now());
    }

    private static  String generateID() {
        return UUID.randomUUID().toString();
    }

    private static  void payBill(User user, Money totalAmount){
        user.setMoney(user.getMoney().subtract(totalAmount));
    }


    public static  Money getBill(Product product, int count, BiFunction<Product, Integer, Money> discount){
        return discount.apply(product, count);
    }

    public static  int size() {
        return orders.size();
    }

    public static  List<Order> getAllOrders(){
        return orders.findAll();
    }
}
