package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

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
            StringTokenizer tokenizer = new StringTokenizer(nextLine);
            upc = tokenizer.nextToken();
            desc = tokenizer.nextToken();
            price = Double.valueOf(tokenizer.nextToken());
            //System.out.println(nextLine);
        } else return null;
        return new ProductSpec(upc, desc, price);
    }
}
