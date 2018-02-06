package customer;

public class CashPayment extends Payment {

    double amount;
    double change;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getChange() {
        return change;
    }
    
    public void setChange(double change){
        this.change = change;
    }
    
    @Override
    public String toString() {
        return "$" + amount + "\n$" + change;
    }
}
