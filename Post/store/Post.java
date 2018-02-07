package store;

import customer.CashPayment;
import customer.CheckPayment;
import customer.CreditPayment;
import customer.Payment;
import customer.TransactionItem;
import java.io.OutputStream;

public class Post {
    private ProductCatalog productCatalog;
    private ProductSpec scannedProduct;
    private double total;
    private OutputStream oStream;
    
    Post(ProductCatalog productCatalog){
        total = 0;
        this.productCatalog = productCatalog;
    }
    void updateProductCatalog(){}

    public void scanItem(TransactionItem tItem){        
        if(validateUPC(tItem.getUPC())){
            scannedProduct = productCatalog.getProduct(tItem.getUPC());
            updateInvoice(tItem);
        }
    }
    
    public boolean payTotal(Payment payment){
        if(payment instanceof CashPayment){
            // check if payment can cover total, return change (if any)
        }
        else if(payment instanceof CheckPayment){
            // check if amount of payment can cover bill
        }
        else if(payment instanceof CreditPayment){
            // verify credit number, reject or accept vased on result
        }
        return false;
    }
    
    public void endTransaction(){
        
    }
    
    boolean validateUPC(String upc){return this.productCatalog.validateUPC(upc);}

    private void updateInvoice(TransactionItem tItem){
        int quantity = tItem.getQuantity();
        double subTotal = 0;
        
        subTotal = tItem.getQuantity() * scannedProduct.getPrice();
        
        
        this.total += subTotal;     
    }
    
    private void printInvoice(){}
    
    private void clearInvoic(){
        total = 0;
        
    }
}
