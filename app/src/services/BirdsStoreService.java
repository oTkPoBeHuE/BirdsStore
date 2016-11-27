package services;

import model.abstractstore.Money;
import model.abstractstore.Storage;
import model.birdsimpl.Bird;
import model.birdsimpl.BirdsStorage;

/**
 * Created by oTk on 27.11.2016.
 */
public class BirdsStoreService {
    private static BirdsStoreService ourInstance = new BirdsStoreService();
    public static BirdsStoreService getInstance() {
        return ourInstance;
    }

    private BirdsStoreService() {

    }

    private static Storage storage = new BirdsStorage();

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


}
