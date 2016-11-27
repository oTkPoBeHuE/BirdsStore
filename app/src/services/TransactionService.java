package services;

/**
 * Created by oTk on 27.11.2016.
 */
public class TransactionService {
    private static TransactionService ourInstance = new TransactionService();
    public static TransactionService getInstance() {
        return ourInstance;
    }

    private TransactionService() {
    }
    private static void generateOrder(){

    }

}
