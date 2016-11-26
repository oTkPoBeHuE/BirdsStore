package business.birdsimpl;

import business.abstractstore.Money;
import business.abstractstore.Product;

public class Bird extends Product {
    public Bird(String name, Money price) {
        super(name, price);
    }
}
