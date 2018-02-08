package store;

import java.util.HashMap;

public class ProductCatalog {
private ProductReader pr;
private HashMap<String, ProductSpec> productCatalog;
private ProductSpec spec;
    
    ProductCatalog(String filePath){
        pr = new ProductReader(filePath);
        productCatalog = new HashMap();
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
