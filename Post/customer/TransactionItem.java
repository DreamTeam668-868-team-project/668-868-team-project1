package customer;

public class TransactionItem {
    TransactionItem(String upc){
        this.upc = upc;
        quantity = 1;
    }
    
    TransactionItem(String upc, int quantity){
        
    }
    
    public String getUPC(){
        return "";
    }
    
    private String upc;
    private int quantity;
}
