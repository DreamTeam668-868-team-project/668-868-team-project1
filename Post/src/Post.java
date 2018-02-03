public class Post {
    ProductSpec product;
    Post(ProductCatalog productCatalog){

    }
    public void updateProductCatalog(){}

    public void scanItem(ProductSpec product){
        this.product = product;
        if(validateUPC()){
            product.getPrice();
            updateTransitation();
            print();

        }
    }

    public boolean validateUPC(){return false;}


    private void updateTransitation(){


    }

    private void print(){}
}
