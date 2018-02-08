package store;

import customer.TransactionHeader;
import customer.TransactionReader;

import java.io.FileNotFoundException;


public class Store {
    //    public java.util.Date getDateAndTime(){
//        return new java.util.Date();
//    }
    private String name;
    private Manager manager;
    private Post post; // maybe array later
    private boolean isOpen;
    private static String customerTransaction = "Post/testFiles/Transaction.txt";

    public Store(String name) {
        // have a store name

        this.name = name;
    }

    void open() {
        isOpen = true;
    }

    void close() {
        isOpen = false;
    }

    public boolean isStoreOpen() {
        return isOpen;
    }

    public static void main(String[] args) {

        // manager opens store
        Store store1 = new Store("Costco");
        Manager manager = new Manager("John", store1);
        manager.openStore();

        if (store1.isOpen) {
            try {
                // customers buy things
                TransactionReader tr = new TransactionReader(customerTransaction);

                while (tr.hasMoreTransactions()) {
                    System.out.print("");
                }
            } catch (FileNotFoundException e) {
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
}
