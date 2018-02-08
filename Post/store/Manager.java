package store;

public class Manager {

    Manager(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    public Post openStore() {
        // init product catalog
        // store.getCatalog().init();
        // setup Post -- store.getPost().init();
        String procatalog = "Post/testFiles/Products.txt";
        ProductCatalog productCatalog = new ProductCatalog(procatalog);
        productCatalog.init();
        Post post = new Post(store, productCatalog);
        store.open();
        return post;
    }

    public void closeStore() {
        store.close();
    }

    private String name;
    private Store store;

}
