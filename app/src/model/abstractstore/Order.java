package model.abstractstore;

import model.abstractstore.Money;

import java.time.LocalDateTime;

public class Order implements Comparable {
    //// TODO:: Add time % date
    //// TODO::  Хранить общую стоимость сделки или цену за одно изделме? (есть скидки, поэтому не очевидно)
    private final String productName;
    private final String userName;
    private final Money totalAmount;
    private final int count;
    private final LocalDateTime localDateTime ;
    private final String ID;

    public Order(String ID, String productName, String userName, Money totalAmount, int count, LocalDateTime localDateTime) {
        this.ID = ID;
        this.productName = productName;
        this.userName = userName;
        this.totalAmount = totalAmount;
        this.count = count;
        this.localDateTime = localDateTime;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public int compareTo(Object o) {
        return localDateTime.compareTo(((Order)o).getLocalDateTime());
    }

    public String getID() {
        return ID;
    }
}
