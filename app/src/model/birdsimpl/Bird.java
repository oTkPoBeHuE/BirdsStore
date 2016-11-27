package model.birdsimpl;

import model.abstractstore.Money;
import model.abstractstore.Product;

public class Bird extends Product {
    public Bird(String name, Money price) {
        super(name, price);
    }
}
