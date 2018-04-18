package xpmxp1.database;

import android.arch.persistence.room.*;
import android.arch.persistence.room.TypeConverters;

import xpmxp1.database.DAO.AddressDAO;
import xpmxp1.database.DAO.CustomerDAO;
import xpmxp1.database.DAO.FavoritDAO;
import xpmxp1.database.DAO.ProductDAO;
import xpmxp1.database.DAO.StoreDAO;
import xpmxp1.tenderstar.app_objects.Address;
import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;

@Database(entities = {Customer.class, Store.class, Address.class, Favorit.class, Product.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class TenderstarDB extends RoomDatabase {
    public abstract CustomerDAO customerDAO();
    public abstract StoreDAO storeDAO();
    public abstract AddressDAO addressDAO();
    public abstract FavoritDAO favoritDAO();
    public abstract ProductDAO productDAO();
}
