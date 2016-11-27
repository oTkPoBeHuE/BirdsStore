package model.abstractstore;

public interface Store {
    void sell(String  productName, int count);
    boolean containsProduct(String  productName, int count);
    void addItem(String  productName, int count);

    void increaseCountProduct(String  productName, int count);
    void decreaseCountProduct(String  productName, int count);

    void setCountProduct(String  productName, int count);
}

