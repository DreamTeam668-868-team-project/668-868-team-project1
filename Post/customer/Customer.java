package customer;

public class Customer {
    String name;
    Transaction transaction;
    TransactionHeader transactionHeader;

    public Customer(Transaction transaction) // give transaction from file, takes place of GUI input
    {
        this.transaction = transaction;
        this.name = transaction.getHeader().getCustomerName();
        this.transactionHeader = transaction.getHeader();
    }

    public String getName() {
        return name;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void checkout() {

        // interact with POST methods
        // POST.scanItem -- continues while transaction has more items


        // POST.payTotal -- make an attempt to pay
    }
}
