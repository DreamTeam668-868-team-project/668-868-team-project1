package store;

import customer.*;

import java.io.FileNotFoundException;


public class Store {
    public java.util.Date getDateAndTime() {
        return new java.util.Date();
    }

    private String name;
    private Manager manager;
    private Post post; // maybe array later
    private boolean isOpen;
    private static String productsCatalog = "Post/testFiles/Products.txt";
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
        Customer c1;

        if (store1.isOpen) {
            Transaction trans;
            try {
                TransactionReader tr = new TransactionReader(customerTransaction);
                ProductCatalog pCatalog = new ProductCatalog(productsCatalog);
                Post post = new Post(pCatalog);
                // start the transaction
                post.startTransaction();

                while (tr.hasMoreTransactions()) {
                    // build a customer
                    trans = tr.nextTransaction();
                    c1 = new Customer(trans);
                    System.out.println(trans.getHeader().toString());
                    // implement buy in assignment2
//                    c1.checkout();

                    while (trans.hasMoreTransactionItems()) {
                        TransactionItem tItem = trans.getNextTransactionItem();
                        // check itm has valide UPC
                        post.scanItem(tItem);
                        // should print invoice instead...
                        System.out.println(tItem);
                        post.printInvoice();

                    }
                    System.out.println();
                    post.printTotal();
                    System.out.println();
                }
            } catch (Exception e) {

            }


        }
        manager.closeStore();

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

