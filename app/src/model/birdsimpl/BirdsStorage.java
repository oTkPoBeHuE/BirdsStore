package model.birdsimpl;

import model.abstractstore.Product;
import model.abstractstore.Storage;
import data.Database;
import data.MemoryDatabase;
import model.abstractstore.User;

import java.util.List;

public class BirdsStorage implements Storage {

    private final Database<Products> products = new MemoryDatabase<Products>();



    @Override
    public void addItem(Product product, int count) {
        //TODO: exception
        products.save(product.getName(), new Products(product, count));
    }

    @Override
    public void push(String productName, int count) {
        products.read(productName).add(count);
    }

    @Override
    public void put(String productName, int count) {
        products.read(productName).sub(count);
    }

    @Override
    public int getCount(String productName) {
        return products.read(productName).getCount();
    }

    @Override
    public boolean contains(String productName) {
        return products.containsKey(productName);
    }

    @Override
    public Product findProduct(String productName) {
        return products.read(productName).getProduct();
    }

    @Override
    public int size() {
        return products.size();
    }

    @Override
    public List<Products> getAllProducts(){
        return products.toList();
    }
}
