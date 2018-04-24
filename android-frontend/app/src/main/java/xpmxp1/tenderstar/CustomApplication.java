package xpmxp1.tenderstar;

import android.app.Application;
import android.arch.persistence.room.Room;

import java.util.Date;

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
import xpmxp1.tenderstar.database.TenderstarDB;

/**
 * Created by sebastian on 4/23/18.
 */

public class CustomApplication extends Application {

    private static TenderstarDB db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), TenderstarDB.class, "TenderstarDB").build();
        //fillDbWithTestData();
    }

    public static synchronized TenderstarDB getDb() {
        return db;
    }

    private void fillDbWithTestData(){
        Customer c1 = new Customer("Max", "Max", "max@asdf.com");
        Customer c2 = new Customer("Susi", "Susi", "susi@asdf.com");

        Store s1 = new Store("LoremIpsum", "LoremIpsum", "LoremIpsum-Store", 1, 1, "08:00-18:00");
        Store s2 = new Store("MediaSat", "MediaSat", "MediaSat-Store", 2, 2, "08:30-20:00");
        Store s3 = new Store("ConTech", "ConTech", "ConTech-Store", 2, 3, "00:00-24:00");

        Address a1 = new Address(1000, "Wien", "Mainstreet 1");
        Address a2 = new Address(8000, "Graz", "Techstreet 1");
        Address a3 = new Address(8000, "Graz", "Techstreet 17");

        Favorit f1 = new Favorit(1,1);
        Favorit f2 = new Favorit(2,2);

        Product p1 = new Product("Ham", 2.0, 10.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), 1);
        Product p2 = new Product("Egg", 1.3, 5.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), 1);
        Product p3 = new Product("TV", 699.99, 25.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), 2);
        Product p4 = new Product("Computer", 1229.79, 12.5, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), 3);

        ProductRating pr1 = new ProductRating(1,1, 5, "Great!");
        ProductRating pr2 = new ProductRating(2,1, 3, "Meeh...");
        ProductRating pr3 = new ProductRating(3,2, 4, "Nice.");
        ProductRating pr4 = new ProductRating(4,2, 2, "Worst PC EVER!");
        ProductRating pr5 = new ProductRating(4,1, 5, "Best PC EVER!!!!");

        SavedOffer so1 = new SavedOffer(1,1);
        SavedOffer so2 = new SavedOffer(1,2);
        SavedOffer so3 = new SavedOffer(2,2);

        StoreRating sr1 = new StoreRating(1,1, 5, "");
        StoreRating sr2 = new StoreRating(2,2, 3, "okay...");
        StoreRating sr3 = new StoreRating(1,2, 5, "Super helpful staff");

        StoreType st1 = new StoreType("Food");
        StoreType st2 = new StoreType("Tech");

        Tag t1 = new Tag("Food");
        Tag t2 = new Tag("Tech");

        db.customerDAO().insertCustomer(c1);
        db.customerDAO().insertCustomer(c2);
        db.storeDAO().insertStore(s1);
        db.storeDAO().insertStore(s2);
        db.storeDAO().insertStore(s3);
        db.addressDAO().insertAddress(a1);
        db.addressDAO().insertAddress(a2);
        db.addressDAO().insertAddress(a3);
        db.favoritDAO().insertFavorit(f1);
        db.favoritDAO().insertFavorit(f2);
        db.productDAO().insertProduct(p1);
        db.productDAO().insertProduct(p2);
        db.productDAO().insertProduct(p3);
        db.productDAO().insertProduct(p4);
        db.productRatingDAO().insertProductRating(pr1);
        db.productRatingDAO().insertProductRating(pr2);
        db.productRatingDAO().insertProductRating(pr3);
        db.productRatingDAO().insertProductRating(pr4);
        db.productRatingDAO().insertProductRating(pr5);
        db.savedOfferDAO().insertSavedOffer(so1);
        db.savedOfferDAO().insertSavedOffer(so2);
        db.savedOfferDAO().insertSavedOffer(so3);
        db.storeRatingDAO().insertStoreRating(sr1);
        db.storeRatingDAO().insertStoreRating(sr2);
        db.storeRatingDAO().insertStoreRating(sr3);
        db.storeTypeDAO().insertStoreType(st1);
        db.storeTypeDAO().insertStoreType(st2);
        db.tagDAO().insertTag(t1);
        db.tagDAO().insertTag(t2);
    }
}
