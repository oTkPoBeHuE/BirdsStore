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
    private static OrdersService ourInstance = new OrdersService();
    public static OrdersService getInstance() {
        return ourInstance;
    }
    private static Database<Order> orders = new MemoryDatabase<>();

    private OrdersService() {
    }


    public void transaction(Order order){
        StorageService.getInstance().release(order.getProductName(), order.getCount());
        payBill(UserService.getInstance().getUser(order.getUserName()), order.getTotalAmount());
        orders.save(order.getID(), order);
    }

    private Order generateOrder(String productname, String username, Money totalAmount, int count){
        return new Order(generateID(), productname, username, totalAmount, count, LocalDateTime.now());
    }

    private String generateID() {
        return UUID.randomUUID().toString();
    }

    private void payBill(User user, Money totalAmount){
        user.setMoney(user.getMoney().subtract(totalAmount));
    }

//    private void checkUserMoney(User user, Money totalAmount){
//        if(!user.getMoney().amountExist(totalAmount));
//        //TODO:: exception
//    }

    public Money getBill(Product product, int count, BiFunction<Product, Integer, Money> discount){
        return discount.apply(product, count);
    }

    public int size() {
        return orders.size();
    }

    public List<Order> getAllOrders(){
        return orders.toList();
    }
}
