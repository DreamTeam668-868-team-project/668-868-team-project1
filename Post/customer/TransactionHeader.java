package customer;

import java.text.SimpleDateFormat;

public class TransactionHeader {
    String customerName;
    java.util.Date date;
    
    TransactionHeader(String name, java.util.Date date){
        this.customerName = name;
        this.date = date;        
    }
    
    public String getCustomerName(){
        return this.customerName;
    }
    
    public String getDate(){
        return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(date).toString();
    }    // toString();
    
    @Override
    public String toString() {
        String s = "Customer Name: " + customerName + "  Date: " + date.toString();
        return s;
    }
}
