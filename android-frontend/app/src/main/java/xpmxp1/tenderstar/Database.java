package xpmxp1.tenderstar;


import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductCategory;
import xpmxp1.tenderstar.app_objects.SavedOffer;
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
        }
        return instance;
    }

    // Constructor
    private Database() {

    }

    public List<Product> getProducts() {
        return CustomApplication.getDb().productDAO().getAllProducts();
    }

    public List<Store> getStores() {
        return CustomApplication.getDb().storeDAO().getAllStores();
    }

    public List<Tag> getTags() {
        //TODO: Query
        return null;
    }

    private void createDummies() {
        // create products
        products = new ArrayList<>();
        products.add(new Product("Milk", Product.Category.FOOD, "descr", 1.2f, "Billa", "8010"));
        products.add(new Product("Water", Product.Category.FOOD,"descr", 0.8f, "Spar", "4715"));
        products.add(new Product("Cereal", Product.Category.FOOD, "descr", 3.8f, "Spar", "4710"));
        products.add(new Product("Sausage", Product.Category.FOOD, "descr", 2.0f, "Spar", "8715"));
        products.add(new Product("Pizza", Product.Category.FOOD, "descr", 4.4f, "Spar", "7015"));
        products.add(new Product("Rice", Product.Category.FOOD, "descr", 2.0f, "Billa", "1015"));
        products.add(new Product("Beer", Product.Category.ALCOHOL, "descr", 1.0f, "Billa", "1005"));
        products.add(new Product("Wine", Product.Category.ALCOHOL, "descr", 7.0f, "Billa", "5020"));
        products.add(new Product("Vodka", Product.Category.ALCOHOL, "descr", 32.7f, "Billa", "4715"));
        products.add(new Product("Whisky", Product.Category.ALCOHOL, "descr", 99.99f,"Lidl", "8050"));
        products.add(new Product("Felix", Product.Category.CATFOOD, "delicious cat food", 1.5f, "Lidl", "4715"));
        products.add(new Product("Sheba", Product.Category.CATFOOD, "cat food", 1.25f, "Spar", "8020"));
        products.add(new Product("Whiskas", Product.Category.CATFOOD, "descr", 1.3f, "Spar", "8090"));
        products.add(new Product("Ketchup", Product.Category.FOOD, "descr", 2.8f, "Lidl", "8005"));
        products.add(new Product("InstantNoodles", Product.Category.FOOD, "descr", 3.1f, "Spar", "4710"));
        products.add(new Product("Pasta", Product.Category.FOOD, "descr", 1.7f, "Lidl", "1015"));
        products.add(new Product("Cheese", Product.Category.FOOD, "descr", 1.3f, "Spar", "3002"));
        products.add(new Product("Ham", Product.Category.FOOD, "descr", 2.0f, "Spar", "8030"));
        products.add(new Product("Rum", Product.Category.ALCOHOL, "descr", 4.7f, "Lidl", "8060"));
        products.add(new Product("Alami", Product.Category.CATFOOD, "descr", 11.6f, "Spar", "8010"));
        products.add(new Product("Gourmet", Product.Category.CATFOOD, "descr", 16.9f, "Spar", "8020"));
    // Favorites
    public void AddFavorite(Store store) {
        Favorit f = new Favorit(CustomApplication.getLoggedInCustomer().getId(), store.getId());
        CustomApplication.getDb().favoritDAO().insertFavorit(f);
    }

    public List<Store> GetFavorites() {
        return CustomApplication.getDb().favoritDAO().getAllFavoritesStores(CustomApplication.getLoggedInCustomer().getId());
    }

    public void RemoveFavorite(Store store) {
        Favorit f = new Favorit(CustomApplication.getLoggedInCustomer().getId(), store.getId());
        CustomApplication.getDb().favoritDAO().deleteFavorit(f);
    }

    // Shopping Cart
    public void addShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(CustomApplication.getLoggedInCustomer().getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().insertSavedOffer(savedOffer);
    }

    public List<Product> getShoppingCartProducts() {
        return CustomApplication.getDb().savedOfferDAO().getSavedOffersForCustomer(CustomApplication.getLoggedInCustomer().getId());
    }

    public void removeShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(CustomApplication.getLoggedInCustomer().getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().deleteSavedOffer(savedOffer);
    }

    public String getCategoryForProduct(long categoryId) {
        return CustomApplication.getDb().productCategoryDAO().getCategoryForProduct(categoryId);
    }

    public Customer loginCustomer(String username, String password) {
        Customer c = CustomApplication.getDb().customerDAO().loginCustomer(username, password);
        if(c != null)
            CustomApplication.setLoggedInCustomer(c);
        return c;
    }
}
