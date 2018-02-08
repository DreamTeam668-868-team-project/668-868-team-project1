package customer;

import store.Post;

public class Customer {
    String name;
    Transaction transaction;
    Post post;

    public Customer (Post post, Transaction transaction) // give transaction from file, takes place of GUI input
    {
        this.transaction = transaction;
        this.name = transaction.getHeader().getCustomerName();
        this.post = post;
    }
    
    public void checkout(){

        // interact with POST methods
        // POST.scanItem -- continues while transaction has more items
        post.startTransaction();
        post.login(transaction.getHeader());
        while(transaction.hasMoreTransactionItems()){
            post.scanItem(transaction.getNextTransactionItem());
        }
        post.pay(transaction.getPayment());
        post.printInvoice();
        // POST.payTotal -- make an attempt to pay
    }
}
