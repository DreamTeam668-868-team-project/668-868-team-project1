package src.store;

public class Post {
    private ProductCatalog productCatalog;
    private ProductSpec product;
    Post(ProductCatalog productCatalog){
        this.productCatalog = productCatalog;
    }
    void updateProductCatalog(){}

    public void scanItem(String upc){
        this.product = this.productCatalog.getProduct(upc);
        
        if(validateUPC()){
            product.getPrice();
            updateInvoice();
            printInvoice();

        }
    }

    boolean validateUPC(){return false;}


    private void updateInvoice(){


    }

    private void printInvoice(){}
}
