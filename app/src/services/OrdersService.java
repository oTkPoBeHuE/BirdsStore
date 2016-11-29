package services;

import data.DAO;
import data.FileSave;
import data.MemoryDAO;
import model.abstractstore.Money;
import model.abstractstore.Order;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


public class OrdersService {
    private static DAO<Order> orders = new MemoryDAO<>();

    private OrdersService() {
    }

    public static void generateOrder(String productName, String username, Money totalAmount, int count) {
        Order order = new Order(generateID(), productName, username, totalAmount, count, LocalTime.now());
        saveOrder(order);
    }

    public static void saveOrder(Order order){
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

    public static void save(String filename) throws IOException {
        FileSave.saveOrderDB(orders, filename);
    }

}
