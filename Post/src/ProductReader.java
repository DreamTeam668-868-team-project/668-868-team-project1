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
    public void nextLine() {
        String nextLine = productReader.nextLine().trim();

        // ignore comments and empty lines
        while (!nextLine.isEmpty()) {
            if (productReader.hasNextLine()) {
                nextLine = productReader.nextLine().trim();
                System.out.println(nextLine);
            }
        }

//        return nextLine;
    }
}
