package model.birdsimpl;

import model.abstractstore.Product;

import java.util.Map;

public class BirdsSorage implements Storage {

    Map<String, Products> products;

    private class Products {
        public Products(Product product, int count) {
            this.product = product;
            this.count = count;
        }

        Product product;
        int count;
    }

}
