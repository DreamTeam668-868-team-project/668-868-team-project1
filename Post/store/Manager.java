package store;

public class Manager {

    Manager(String name, Store store) {
        this.name = name;
    }

    public void openStore() {
        // init product catalog
        // store.getCatalog().init();
        // seup Post -- store.getPost().init();
        String procatalog = "Post/testFiles/Products.txt";
        ProductCatalog productCatalog = new ProductCatalog(procatalog);
        productCatalog.init();
        Post post = new Post(productCatalog);
        store.open();
    }

    public void closeStore() {
        store.close();
    }

    private String name;
    private Store store;

}
