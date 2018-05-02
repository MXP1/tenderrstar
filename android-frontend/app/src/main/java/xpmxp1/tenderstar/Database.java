package xpmxp1.tenderstar;


import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.Tag;

/**
 * Created by dominik on 18.04.18.
 */

public class Database {
    // Singleton
    static private Database instance = null;
    static public Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    private List<Product> products;
    private List<Store> stores;
    private List<Tag> tags;

    // Constructor
    private Database() {
        createDummies();
    }

    public List<Product> getProducts() {
        return CustomApplication.getDb().productDAO().getAllProducts();
    }

    public List<Store> getStores() {
        return CustomApplication.getDb().storeDAO().getAllStores();
    }

    public List<Tag> getTags() {
        //TODO
        return null;
    }

    private void createDummies() {
        // create products

        /*
        products = new ArrayList<>();
        products.add(new Product("Milk", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Water", Product.Category.FOOD,"descr", 2.0f));
        products.add(new Product("Cereal", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Sausage", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Pizza", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Rice", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Beer", Product.Category.ALCOHOL, "descr", 2.0f));
        products.add(new Product("Wine", Product.Category.ALCOHOL, "descr", 2.0f));
        products.add(new Product("Whiskas", Product.Category.CATFOOD, "descr", 2.0f));

        //String username, String password, String storeName, String link, int storeTypeID, int locationID, OpeningHours openingHours, String address, String postalCode
        // create stores
        stores = new ArrayList<>();
        stores.add(new Store("Billa", new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Straße 1", "8010"));
        stores.add(new Store("Spar", new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Straße 2", "8010"));
        stores.add(new Store("Penny", new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Straße 3", "8010"));
        stores.add(new Store("Lidl", new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Straße 4", "8010"));
        */
    }
}
