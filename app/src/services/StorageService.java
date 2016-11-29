package services;

import model.abstractstore.Money;
import model.abstractstore.Storage;
import model.birdsimpl.Bird;
import model.birdsimpl.BirdsStorage;

import java.util.List;

public class StorageService {
    private static StorageService ourInstance = new StorageService();
    private static Storage storage = new BirdsStorage();

    private StorageService() {
    }

    public static StorageService getInstance() {
        return ourInstance;
    }

    public void addBirdsItem(String name, Money price) {
        storage.addItem(new Bird(name, price), 0);
    }

    public void addBirdsItem(String name, String price) {
        addBirdsItem(name, Money.parseMoney(price));
    }

    public void receipt(String productName, int count) {
        storage.push(productName, count);
    }

    public void release(String productName, int count) {
        storage.put(productName, count);
    }

    public boolean containsProduct(String name) {
        return storage.contains(name);
    }

    public boolean containsProductCount(String productName, int count) {
        return storage.getCount(productName) >= count;
    }

    public int size() {
        return storage.size();
    }

    public List<BirdsStorage.Products> getAllProducts() {
        return storage.getAllProducts();
    }

    public Money getPrice(String productName) {
        return storage.findProduct(productName).getPrice();
    }

}
