package business;

import business.abstractstore.Money;

public class Order {
    //// TODO:: Add time % date
    //// TODO::  Хранить общую стоимость сделки или цену за одно изделме? (есть скидки, поэтому не очевидно)
    String productName;
    Money totalAmount;
    int count;
}
