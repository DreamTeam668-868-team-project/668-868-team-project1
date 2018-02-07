package store;

import customer.TransactionReader;
import java.io.FileNotFoundException;


public class Store {
//    public java.util.Date getDateAndTime(){
//        return new java.util.Date();
//    }
    private Manager manager;
    private Post post; // maybe array later
    private boolean isOpen;
    
    void open(){
        isOpen = true;
    }
    
    void close(){
        isOpen = false;
    }
    
    public boolean isStoreOpen(){
        return isOpen;
    }
    
    public static void main(String[] args){
        // manager opens store
        try {
            TransactionReader tr = new TransactionReader("Post/testFiles/Transaction.txt");
        } catch(FileNotFoundException e){
           e.printStackTrace();
        }
        // customers buy things
            // customer interacts with POST to process transactions
        // manager closes store
        
        /*
        while ( TransactionReader.hasMoreTransactons )
        {
            Customer customer = new Customer(TransactionReader.nextTransaction());
        
        
        }
        
        */
    }
}
