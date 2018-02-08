package customer;

public class TransactionItem {
    TransactionItem(String upc, int quantity){
        this.upc = upc;
        this.quantity = quantity;
    }
    
    public String getUPC(){
        return this.upc;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    @Override
    public String toString(){
        return getUPC() + " " + getQuantity();
    }
    
    private String upc;
    private int quantity;
}
