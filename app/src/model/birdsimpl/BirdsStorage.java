package model.birdsimpl;

import data.DAO;
import data.MemoryDAO;
import model.abstractstore.Product;
import model.abstractstore.Storage;

import java.util.List;

public class BirdsStorage implements Storage {

    private final DAO<Products> products = new MemoryDAO<>();


    @Override
    public void addItem(Product product, int count) {
        products.save(product.getName(), new Products(product, count));
    }

    @Override
    public void push(String productName, int count) {
        products.find(productName).add(count);
    }

    @Override
    public void put(String productName, int count) {
        products.find(productName).sub(count);
    }

    @Override
    public int getCount(String productName) {
        return products.find(productName).getCount();
    }

    @Override
    public boolean contains(String productName) {
        return products.containsKey(productName);
    }

    @Override
    public Product findProduct(String productName) {
        return products.find(productName).getProduct();
    }

    @Override
    public int size() {
        return products.size();
    }

    @Override
    public List<Products> getAllProducts() {
        return products.findAll();
    }
}
