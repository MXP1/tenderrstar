package xpmxp1.tenderstar;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import java.util.Date;

import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductCategory;
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
    private static Customer loggedInCustomer;

    @Override
    public void onCreate() {
        super.onCreate();

        db = Room.databaseBuilder(getApplicationContext(), TenderstarDB.class, "TenderstarDB").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        //nukeTables();
        if(db.customerDAO().getAllCustomers().size() == 0)
            Database.fillDbWithTestData();
    }

    public static void setLoggedInCustomer(Customer customer){
        loggedInCustomer = customer;
    }

    public static Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public static synchronized TenderstarDB getDb() {
        return db;
    }
}
