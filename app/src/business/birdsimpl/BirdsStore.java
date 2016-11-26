package business.birdsimpl;

import business.abstractstore.Product;
import business.abstractstore.Storage;
import business.abstractstore.Store;

public class BirdsStore implements Store {
    Storage storage = new BirdsStorage();

    @Override
    public void Sell(Product product) {

    }
}
