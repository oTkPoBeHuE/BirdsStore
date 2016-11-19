package model;

import java.util.Map;

public interface Storage {


    //// TODO: наверно нужно переделать из интерфейса в абстрактный класс??
    class Products {
        //// TODO: rename

        public Products(Product product, int count) {
            this.product = product;
            this.count = count;
        }

        Product product;
        int count;
    }

    //Map<String, Products> products;
}
