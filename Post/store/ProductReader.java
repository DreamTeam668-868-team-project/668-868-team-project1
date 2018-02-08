package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    private File file;
    private Scanner scanner;

    public ProductReader(String productFile) {
        try{
            file = new File(productFile);
            scanner = new Scanner(file);
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean hasMoreProducts(){
        return scanner.hasNext();
    }
    
    public ProductSpec nextProduct() {
        String nextLine = "";
        String upc = "";
        String desc = "";
        double price = 0.0;

        if (scanner.hasNextLine()) {
            nextLine = scanner.nextLine().trim();
            
            upc = nextLine.substring(0,4);
            desc = nextLine.substring(10, 30);
            price = Double.valueOf(nextLine.substring(30));
            
            //System.out.println(nextLine);
        } else return null;
        return new ProductSpec(upc, desc, price);
    }
    // test main
    public static void main(String[] args){
        String filePath = "Post/testFiles/Products.txt";
        ProductReader pr = new ProductReader(filePath);
        while(pr.hasMoreProducts()){
            ProductSpec product = pr.nextProduct();

            System.out.println(product.toString());
        }
    }
}
