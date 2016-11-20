package model.birdsimpl;

import model.abstractstore.Product;
import model.abstractstore.Store;

public class BirdsStore implements Store {
    Storage storage = new BirdsSorage();

    @Override
    public void Sell(Product product) {

    }
}
