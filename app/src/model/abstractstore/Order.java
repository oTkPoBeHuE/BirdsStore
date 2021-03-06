package model.abstractstore;

import java.time.LocalTime;

public class Order implements Comparable {
    private final String productName;
    private final String userName;
    private final Money totalAmount;
    private final int count;
    private final LocalTime localTime ;
    private final String ID;

    public Order(String ID, String productName, String userName, Money totalAmount, int count, LocalTime localTime) {
        this.ID = ID;
        this.productName = productName;
        this.userName = userName;
        this.totalAmount = totalAmount;
        this.count = count;
        this.localTime = localTime;

    }

    public String getProductName() {
        return productName;
    }

    public String getUserName() {
        return userName;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public int getCount() {
        return count;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    @Override
    public int compareTo(Object o) {
        return localTime.compareTo(((Order)o).getLocalTime());
    }

    public String getID() {
        return ID;
    }

}
