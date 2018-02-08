package customer;

import java.util.ArrayList;

public class Transaction {
    
    public Transaction(){
        this.transactionItems = new ArrayList<>();
        this.index = 0;
    }
    
    public void setHeader(TransactionHeader header){
        this.header = header;
    }
    
    public TransactionHeader getHeader(){
        return this.header;
    }
    
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    
    public Payment getPayment() {
        return this.payment;
    }
    
    public void addTransactionItem(TransactionItem item){
        if(!this.transactionItems.contains(item)) this.transactionItems.add(item);
    }
    
    public boolean hasMoreTransactionItems()
    {
        return (index < transactionItems.size());
    }
    
    public TransactionItem getNextTransactionItem(){
        TransactionItem tItem = null;
        try{
            tItem = transactionItems.get(index);
            index++;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return tItem;        
    }
    
    // toString
    
    private int index;
    private Payment payment;
    private TransactionHeader header;
    private ArrayList<TransactionItem> transactionItems;
}
