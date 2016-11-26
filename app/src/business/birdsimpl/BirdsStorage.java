package business.birdsimpl;

import business.abstractstore.Product;
import business.abstractstore.Storage;
import data.Database;
import data.MemoryDatabase;

import java.util.Map;

public class BirdsStorage implements Storage {

    private final Database<Products> products = new MemoryDatabase<Products>();

    private final class Products {
        final Product product;
        int count;

        public Products(Product product, int count) {
            this.product = product;
            this.count = count;
        }
    }


    @Override
    public void addItem(Product product, int count) {
        //TODO: exception
        products.save(product.getName(), new Products(product, count));
    }

    @Override
    public void push(String productName, int count) {
        products.read(productName).count += count;
    }

    @Override
    public void put(String productName, int count) {
        products.read(productName).count -= count;
    }

    @Override
    public int getCount(String productName) {
        return products.read(productName).count;
    }

    @Override
    public boolean contains(String productName) {
        return products.containsKey(productName);
    }

    @Override
    public Product findProduct(String productName) {
        return products.read(productName).product;
    }
}
