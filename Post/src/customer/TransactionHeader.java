package src.customer;

public class TransactionHeader {
    String customerName;
    java.util.Date date;
    
    TransactionHeader(String name, java.util.Date date){
        this.customerName = name;
        this.date = date;        
    }
    
    // toString();
    
}
