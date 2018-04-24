package xpmxp1.tenderstar.database;

import android.arch.persistence.room.*;
import android.arch.persistence.room.TypeConverters;

import xpmxp1.tenderstar.database.DAO.AddressDAO;
import xpmxp1.tenderstar.database.DAO.CustomerDAO;
import xpmxp1.tenderstar.database.DAO.FavoritDAO;
import xpmxp1.tenderstar.database.DAO.ProductDAO;
import xpmxp1.tenderstar.database.DAO.ProductRatingDAO;
import xpmxp1.tenderstar.database.DAO.SavedOfferDAO;
import xpmxp1.tenderstar.database.DAO.StoreDAO;
import xpmxp1.tenderstar.database.DAO.StoreRatingDAO;
import xpmxp1.tenderstar.database.DAO.StoreTypeDAO;
import xpmxp1.tenderstar.database.DAO.TagDAO;
import xpmxp1.tenderstar.app_objects.Address;
import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductRating;
import xpmxp1.tenderstar.app_objects.SavedOffer;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.StoreRating;
import xpmxp1.tenderstar.app_objects.StoreType;
import xpmxp1.tenderstar.app_objects.Tag;

@Database(entities = {Customer.class, Store.class, Address.class,
        Favorit.class, Product.class, StoreType.class, Tag.class,
        SavedOffer.class, ProductRating.class, StoreRating.class},
        version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class TenderstarDB extends RoomDatabase {
    public abstract CustomerDAO customerDAO();
    public abstract StoreDAO storeDAO();
    public abstract AddressDAO addressDAO();
    public abstract FavoritDAO favoritDAO();
    public abstract ProductDAO productDAO();
    public abstract StoreTypeDAO storeTypeDAO();
    public abstract TagDAO tagDAO();
    public abstract SavedOfferDAO savedOfferDAO();
    public abstract ProductRatingDAO productRatingDAO();
    public abstract StoreRatingDAO storeRatingDAO();
}
