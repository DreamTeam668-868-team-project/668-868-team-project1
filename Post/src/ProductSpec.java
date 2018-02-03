public class ProductSpec {
    int upc;
    String description;
    double price;

    ProductSpec(int upc, String description, double price) {
        this.upc = upc;
        this.description = description;
        this.price = price;

    }

    public int getUpc() {
        return upc;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


}
