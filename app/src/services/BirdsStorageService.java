package services;

import model.abstractstore.Money;
import model.abstractstore.Storage;
import model.birdsimpl.Bird;
import model.birdsimpl.BirdsStorage;

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


    public static void addBirdsItem(String name, Money price){
        storage.addItem(new Bird(name, price), 0);
    }

    //  Receipt - prihod(rus)
    public static void receipt(String productName, int  count){
        storage.push(productName, count);
    }

    // Release - otpusk(rus)
    public static void release(String productName, int  count){
        storage.put(productName, count);
    }

//    public static void sell(String productName, int  count, price){
//        release(productName, count);
//    }

    public static boolean containsProduct(String name){
        return storage.contains(name);
    }
    public static boolean containsProductCount(String productName, int  count){
        return  storage.getCount(productName) <= count;
    }

    private static void checkProduct(String name){
        //TODO:: exception
    }
    private static void checkProductCount(String productName, int  count){
        //TODO:: exception
    }

}
