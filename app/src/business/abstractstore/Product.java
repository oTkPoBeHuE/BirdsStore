package business.abstractstore;

public abstract class Product {
    private Money price;
    private String name;

    public Product(String name, Money price) {
        this.price = price;
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
