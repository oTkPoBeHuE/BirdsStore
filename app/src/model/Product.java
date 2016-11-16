package model;

public abstract class Product {
    private Double price;
    private Double name;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getName() {
        return name;
    }

    public void setName(Double name) {
        this.name = name;
    }
}
