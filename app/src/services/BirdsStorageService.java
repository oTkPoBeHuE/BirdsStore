package services;

import model.abstractstore.Money;
import model.abstractstore.Storage;
import model.birdsimpl.Bird;
import model.birdsimpl.BirdsStorage;

import java.util.List;

/**
 * Created by oTk on 27.11.2016.
 */
public class BirdsStorageService {
    private static BirdsStorageService ourInstance = new BirdsStorageService();
    public static BirdsStorageService getInstance() {
        return ourInstance;
    }
    private static Storage storage = new BirdsStorage();

    private BirdsStorageService() {

    }


    public void addBirdsItem(String name, Money price){
        storage.addItem(new Bird(name, price), 0);
    }

    public void addBirdsItem(String name, String price){
        addBirdsItem(name, Money.parseMoney(price));
    }
    //  Receipt - prihod(rus)
    public void receipt(String productName, int  count){
        storage.push(productName, count);
    }

    // Release - otpusk(rus)
    public void release(String productName, int  count){
        storage.put(productName, count);
    }

//    public static void sell(String productName, int  count, price){
//        release(productName, count);
//    }

    public boolean containsProduct(String name){
        return storage.contains(name);
    }
    public boolean containsProductCount(String productName, int  count){
        return  storage.getCount(productName) <= count;
    }

    private void checkProduct(String name){
        //TODO:: exception
    }
    private void checkProductCount(String productName, int  count){
        //TODO:: exception
    }

    public int size(){
        return storage.size();
    }

    public List<BirdsStorage.Products> getAllProducts(){
        return storage.getAllProducts();
    }

}
