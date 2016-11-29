package model.abstractstore;


import java.util.List;

public interface Storage {
    void addItem(Product product, int count);

    void push(String productName, int count);

    void put(String productName, int count);

    int getCount(String productName);

    boolean contains(String productName);

    Product findProduct(String productName);

    int size();

    List<Products> getAllProducts();

    final class Products implements Comparable {
        private final Product product;
        private int count;

        public Products(Product product, int count) {
            this.product = product;
            this.count = count;
        }

        public Product getProduct() {
            return product;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void add(int count) {
            this.count += count;
        }

        public void sub(int count) {
            this.count -= count;
        }

        @Override
        public int compareTo(Object o) {
            return product.compare(((Products) o).product);
        }
    }
}
