package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    private File file;
    private Scanner productReader;

    public ProductReader(String productFile) throws FileNotFoundException {
        file = new File(productFile);
        productReader = new Scanner(file);
    }

    public boolean hasMoreProducts(){
        return (productReader.nextLine().trim() != null);
    }
    
    public ProductSpec nextProduct() {
        String nextLine = "";
        String upc = "";
        String desc = "";
        double price = 0.0;

        if (productReader.hasNextLine()) {
            nextLine = productReader.nextLine().trim();
            
            upc = nextLine.substring(0,3);
            desc = nextLine.substring(10, 29);
            price = Double.valueOf(nextLine.substring(30));
            
            //System.out.println(nextLine);
        } else return null;
        return new ProductSpec(upc, desc, price);
    }
    
    public static void main(String[] args){
        String filePath = "Post/testFiles/Products.txt";
        try{
            ProductReader pr = new ProductReader(filePath);
            ProductSpec product = pr.nextProduct();
            
            System.out.println(product.toString());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
