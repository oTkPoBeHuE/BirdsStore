package business.birdsimpl;

import business.abstractstore.Product;
import business.abstractstore.Storage;
import data.Database;
import data.MemoryDatabase;

import java.util.Map;

public class BirdsSorage implements Storage {

    Database<Products> products = new MemoryDatabase<Products>();

    private final class Products {
        final Product product;
        int count;

        public Products(Product product, int count) {
            this.product = product;
            this.count = count;
        }

    }

}
