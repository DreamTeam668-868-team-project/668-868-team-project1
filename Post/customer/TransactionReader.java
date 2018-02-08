package customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TransactionReader {

    public TransactionReader(String filePath){
        try{
        file = new File(filePath);
        scanner = new Scanner(file);
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean hasMoreTransactions(){
        return scanner.hasNext();
    }
    
    public Transaction nextTransaction() {
        String nextLine = "";        
        Transaction transaction = new Transaction();
        
        
        if (scanner.hasNextLine()) {
            while(nextLine.isEmpty()) nextLine = scanner.nextLine(); // consume empty lines
            TransactionHeader header = new TransactionHeader(nextLine, new Date());
            transaction.setHeader(header);
            
            nextLine = scanner.nextLine();
            tokenizer = new StringTokenizer(nextLine);
            while(nextLine.charAt(0) != '<'){
                
                int quantity = 1;
                String upc = tokenizer.nextToken();
                
                if(tokenizer.hasMoreTokens())
                    quantity = Integer.valueOf(tokenizer.nextToken());
                
                transaction.addTransactionItem(new TransactionItem(upc, quantity));
                nextLine = scanner.nextLine();
                tokenizer = new StringTokenizer(nextLine);
            }
            
            // parse payment data
            Payment payment = null;
            switch (tokenizer.nextToken("< $>\t")) {
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

            
            //System.out.println(nextLine);
        } else return null;
        
        return transaction;
    }
    
    public static void main(String[] args){
        Transaction trans;
        try {
            
            TransactionReader tr = new TransactionReader("Post/testFIles/Transaction.txt");
            while(tr.hasMoreTransactions()){
                trans = tr.nextTransaction();
                while(trans.hasMoreTransactionItems()){
                    TransactionItem tItem = trans.getNextTransactionItem();
                    System.out.println(tItem);
                }
            System.out.println("");
            }
        } catch(Exception e){
            
        }
        
        
        
    }

    private String nextLine;
    private StringTokenizer tokenizer;
    private Scanner scanner;
    private File file;
}
