package src.store;

public class ProductCatalog {
    private ProductReader pr;
    private java.util.Map<String, ProductSpec> productCatalog;
    
    ProductCatalog(String filePath){
        try {
            pr = new ProductReader(filePath);
        } catch(java.io.FileNotFoundException e){
            e.printStackTrace();            
        }
    }
    
    void init(){
        while(pr.hasMoreProducts()){
            addProduct(pr.nextProduct());
        }        
    }
    
    void addProduct(ProductSpec productSpec){
        if(productCatalog.containsKey(productSpec.getUpc())) return;
        productCatalog.put(productSpec.getUpc(), productSpec);
    }
    
    ProductSpec getProduct(String upc){
        return productCatalog.get(upc);
    }
    
    boolean validateUPC(String upc){
        if(productCatalog.containsKey(upc)) return true;
        return false;
    }
}
