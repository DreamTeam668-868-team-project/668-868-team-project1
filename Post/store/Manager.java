package store;

public class Manager {
    
    Manager(String name, Store store){
        this.name = name;
        this.store = store;
    }
    
    public void openStore(){
        // init product catalog
        // store.getCatalog().init();
        // seup Post -- store.getPost().init();
        store.open();
    }
    
    private String name;
    private Store store;
    
}
