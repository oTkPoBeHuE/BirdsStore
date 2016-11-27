package model.abstractstore;

public interface Storage {
    void addItem(Product product, int  count);

    void push(String productName, int  count); // TODO: rename
    void put(String productName, int  count); // TODO: rename

    int getCount(String productName);
    boolean contains(String productName);
    Product findProduct(String productName);
}
