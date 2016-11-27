package model;

import model.abstractstore.Money;

import java.time.LocalDateTime;

public class Order {
    //// TODO:: Add time % date
    //// TODO::  Хранить общую стоимость сделки или цену за одно изделме? (есть скидки, поэтому не очевидно)
    private final String productName;
    private final String userName;
    private final Money totalAmount;
    private final int count;
    private final LocalDateTime localDateTime ;

    public Order(String productName, String userName, Money totalAmount, int count, LocalDateTime localDateTime) {
        this.productName = productName;
        this.userName = userName;
        this.totalAmount = totalAmount;
        this.count = count;
        this.localDateTime = localDateTime;
    }


}
