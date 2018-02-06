package src.customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TransactionReader {

    TransactionReader(String filePath) {
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasMoreTransactions() {
        return false;
    }

    public Transaction getNextTransaction() {
        Transaction transaction = new Transaction();
        int quantity;
        String upc;
        String nextToken;
        String nextline = "";
        java.util.StringTokenizer tokenizer;
        try {
            nextline = reader.readLine(); // name first, one string, no tokenizing
            transaction.setHeader(new TransactionHeader(nextline, new java.util.Date()));

            // parse line for item data
            nextline = reader.readLine(); // item data, loop
            tokenizer = new java.util.StringTokenizer(nextline);
            
            while (nextline.charAt(0) != '<') {
                nextToken = tokenizer.nextToken();

                upc = nextToken;
                if (!tokenizer.hasMoreTokens()) {
                    quantity = 1;
                } else {
                    quantity = Integer.valueOf(tokenizer.nextToken());
                }
                transaction.addTransactionItem(new TransactionItem(upc, quantity));
                
                nextline = reader.readLine(); // item data, loop
                tokenizer = new java.util.StringTokenizer(nextline);
            } // end item data
            
            // parse payment data
            tokenizer.nextToken("< $>\t");
            Payment payment = null;
            switch (tokenizer.nextToken()) {
                case "CASH":
                    payment = new CashPayment(Double.valueOf(tokenizer.nextToken()));
                    break;
                case "CHECK":
                    payment = new CheckPayment(Double.valueOf(tokenizer.nextToken()));
                    break;
                case "CREDIT":
                    payment = new CreditPayment(tokenizer.nextToken());
                    break;
                default:
                    break;
            }
            transaction.setPayment(payment);
            nextline = reader.readLine();
            while(nextline.isEmpty()) nextline = reader.readLine(); // consume empty lines
            
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    private BufferedReader reader;
}
