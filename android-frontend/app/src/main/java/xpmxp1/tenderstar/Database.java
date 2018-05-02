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


    // get first customer for debugging
    Customer customer = CustomApplication.getDb().customerDAO().getAllCustomers().get(0);

    private List<Product> products;
    private List<Store> stores;
    private List<Tag> tags;
    private List<Store> favorites;
    private List<Product> shoppingCartProducts;


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
        return new ArrayList<>(tags);
    }

    // Favorites
    public void AddFavorite(Store store) {
        Favorit f = new Favorit(customer.getId(), store.getId());
        CustomApplication.getDb().favoritDAO().insertFavorit(f);
    }
    public List<Store> GetFavorites() {
        return CustomApplication.getDb().favoritDAO().getAllFavoritesStores();
    }
    public void RemoveFavorite(Store store) {
        Favorit f = new Favorit(customer.getId(), store.getId());
        CustomApplication.getDb().favoritDAO().deleteFavorit(f);
    }

    // Shopping Cart
    public void addShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(customer.getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().insertSavedOffer(savedOffer);
    }
    public List<Product> getShoppingCartProducts() {
        return CustomApplication.getDb().savedOfferDAO().getSavedOffersForCustomer(customer.getId());
    }
    public void removeShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(customer.getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().deleteSavedOffer(savedOffer);
    }

}
