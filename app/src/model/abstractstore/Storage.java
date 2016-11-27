package model.abstractstore;

public interface Storage {
    void addItem(Product product, int  count); //  добавить опзицию

    void push(String productName, int  count); //  приход Receipt
    void put(String productName, int  count); // отпуск Release
    int getCount(String productName);
    boolean contains(String productName);
    Product findProduct(String productName);
}
