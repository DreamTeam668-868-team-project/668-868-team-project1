package customer;

public class CheckPayment extends Payment {

    public CheckPayment(double amount) {   
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Paid by Check";
    }
    
    private double amount;
}
