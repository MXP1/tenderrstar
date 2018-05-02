package xpmxp1.tenderstar;

import java.util.ArrayList;
import java.util.List;

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
        {
            instance = new Database();
            instance.createDummies();
        }
        return instance;
    }

    static public Database getDummyInstance() {
        if (instance == null)
        {
            instance = new Database();
            instance.createDummies();
        }

        return instance;
    }

    private List<Product> products;
    private List<Store> stores;
    private List<Tag> tags;
    private List<Store> favorites;


    // Constructor
    private Database() {

    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    public List<Store> getStores() {
        return new ArrayList<>(stores);
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public void AddFavorite(Store store)
    {
        favorites.add(store);
    }

    public List<Store> GetFavorites()
    {
        return favorites;
    }

    public void RemoveFavorite(Store store)
    {
        favorites.remove(store);
    }

    private void createDummies() {
        // create products
        products = new ArrayList<>();
        products.add(new Product("Milk", Product.Category.FOOD, "descr", 1.2f));
        products.add(new Product("Water", Product.Category.FOOD,"descr", 0.8f));
        products.add(new Product("Cereal", Product.Category.FOOD, "descr", 3.8f));
        products.add(new Product("Sausage", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Pizza", Product.Category.FOOD, "descr", 4.4f));
        products.add(new Product("Rice", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Beer", Product.Category.ALCOHOL, "descr", 1.0f));
        products.add(new Product("Wine", Product.Category.ALCOHOL, "descr", 7.0f));
        products.add(new Product("Vodka", Product.Category.ALCOHOL, "descr", 32.7f));
        products.add(new Product("Whisky", Product.Category.ALCOHOL, "descr", 99.99f));
        products.add(new Product("Felix", Product.Category.CATFOOD, "delicious cat food", 1.5f));
        products.add(new Product("Sheba", Product.Category.CATFOOD, "cat food", 1.25f));
        products.add(new Product("Whiskas", Product.Category.CATFOOD, "descr", 1.3f));
        products.add(new Product("Ketchup", Product.Category.FOOD, "descr", 2.8f));
        products.add(new Product("InstantNoodles", Product.Category.FOOD, "descr", 3.1f));
        products.add(new Product("Pasta", Product.Category.FOOD, "descr", 1.7f));
        products.add(new Product("Cheese", Product.Category.FOOD, "descr", 1.3f));
        products.add(new Product("Ham", Product.Category.FOOD, "descr", 2.0f));
        products.add(new Product("Rum", Product.Category.ALCOHOL, "descr", 4.7f));
        products.add(new Product("Alami", Product.Category.CATFOOD, "descr", 11.6f));
        products.add(new Product("Gourmet", Product.Category.CATFOOD, "descr", 16.9f));

        // create stores
        stores = new ArrayList<>();
        stores.add(new Store("Billa", new Store.OpeningHours(new Store.Time(), new Store.Time(), false), "Straße 1", "8010"));
        stores.add(new Store("Spar", new Store.OpeningHours(new Store.Time(), new Store.Time(), false), "Straße 2", "8010"));
        stores.add(new Store("Penny", new Store.OpeningHours(new Store.Time(), new Store.Time(), false), "Straße 3", "8010"));
        stores.add(new Store("Lidl", new Store.OpeningHours(new Store.Time(), new Store.Time(), false), "Straße 4", "8010"));
        stores.add(new Store("Zoo4You", new Store.OpeningHours(new Store.Time(), new Store.Time(), false), "Straße 4", "8010"));

        favorites = new ArrayList<>();
    }
}
