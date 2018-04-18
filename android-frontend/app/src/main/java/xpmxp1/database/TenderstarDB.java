package xpmxp1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import xpmxp1.database.DAO.AddressDAO;
import xpmxp1.database.DAO.CustomerDAO;
import xpmxp1.database.DAO.FavoritDAO;
import xpmxp1.database.DAO.StoreDAO;
import xpmxp1.tenderstar.app_objects.Address;
import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.Store;

@Database(entities = {Customer.class, Store.class, Address.class, Favorit.class}, version = 1, exportSchema = false)
public abstract class TenderstarDB extends RoomDatabase {
    public abstract CustomerDAO customerDAO();
    public abstract StoreDAO storeDAO();
    public abstract AddressDAO addressDAO();
    public abstract FavoritDAO favoritDAO();
}
