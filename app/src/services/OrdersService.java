package services;

import data.Database;
import data.MemoryDatabase;
import model.abstractstore.Money;
import model.abstractstore.Order;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by oTk on 27.11.2016.
 */
public class OrdersService {
    private static Database<Order> orders = new MemoryDatabase<>();

    private OrdersService() {
    }

    public static void generateOrder(String productName, String username, Money totalAmount, int count) {
        Order order = new Order(generateID(), productName, username, totalAmount, count, LocalTime.now());
        orders.save(order.getID(), order);
    }

    private static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static int size() {
        return orders.size();
    }

    public static List<Order> getAllOrders() {
        return orders.findAll();
    }
}
