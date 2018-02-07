package customer;

public class TransactionItem {
    TransactionItem(String upc){
        this.upc = upc;
        quantity = 1;
    }
    
    TransactionItem(String upc, int quantity){
        this.upc = upc;
        this.quantity = quantity;
    }
    
    public String getUPC(){
        return "";
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    private String upc;
    private int quantity;
}
