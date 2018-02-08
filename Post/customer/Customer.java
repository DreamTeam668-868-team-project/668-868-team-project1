package customer;

public class Customer {
    String name;
    Transaction transaction;

    Customer (Transaction transaction) // give transaction from file, takes place of GUI input
    {
        this.transaction = transaction;
        this.name = transaction.getHeader().getCustomerName();
    }
    
    public void checkout(){

        // interact with POST methods
        // POST.scanItem -- continues while transaction has more items

        
        // POST.payTotal -- make an attempt to pay
    }
}
