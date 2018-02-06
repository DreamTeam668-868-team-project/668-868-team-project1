package customer;

import java.util.ArrayList;

public class Transaction {
    
    public void setHeader(TransactionHeader header){
        this.header = header;
    }
    
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    
    public void addTransactionItem(TransactionItem item){
        if(!this.transactionItems.contains(item)) this.transactionItems.add(item);
    }
    
    private Payment payment;
    private TransactionHeader header;
    private ArrayList<TransactionItem> transactionItems;
}
