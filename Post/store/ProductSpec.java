package store;

public class ProductSpec {
    String upc;
    String description;
    double price;

    ProductSpec(String upc, String description, double price) {
        this.upc = upc;
        this.description = description;
        this.price = price;
    }

    public String getUpc() {
        return upc;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return getUpc() + " " + getDescription() + " " + getPrice();
    }
}
