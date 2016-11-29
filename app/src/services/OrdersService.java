package services;

import data.Database;
import data.MemoryDatabase;
import model.abstractstore.Order;
import model.abstractstore.Money;
import model.abstractstore.Product;
import model.abstractstore.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
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


    public static void generateOrder(String productName, String username, Money totalAmount, int count){
        Order order = new Order(generateID(),  productName, username, totalAmount, count, LocalTime.now());
        orders.save( order.getID(), order);
    }

    private static  String generateID() {
        return UUID.randomUUID().toString();
    }


//    public static  Money getBill(Product product, int count, BiFunction<Product, Integer, Money> discount){
//        return discount.apply(product, count);
//    }

    public static  int size() {
        return orders.size();
    }

    public static  List<Order> getAllOrders(){
        return orders.findAll();
    }
}
