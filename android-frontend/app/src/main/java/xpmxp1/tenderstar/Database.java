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
