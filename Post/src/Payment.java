public class Payment {

    double amount;
    double change;
    String type;

    Payment(double amount, double change, String type) {
        this.amount = amount;
        this.change = change;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public double getChange() {
        return change;
    }

    public String getType() {
        return type;
    }
}
