package model.birdsimpl;

import model.abstractstore.Storage;
import model.abstractstore.Store;

public class BirdsStore implements Store {
    Storage storage = new BirdsStorage();

    @Override
    public void sell(String productName, int count) {

    }

    @Override
    public boolean containsProduct(String productName, int count) {
        return false;
    }

    @Override
    public void addItem(String productName, int count) {

    }

    @Override
    public void increaseCountProduct(String productName, int count) {

    }

    @Override
    public void decreaseCountProduct(String productName, int count) {

    }

    @Override
    public void setCountProduct(String productName, int count) {

    }
}
