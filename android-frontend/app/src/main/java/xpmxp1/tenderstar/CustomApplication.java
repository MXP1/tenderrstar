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
            fillDbWithTestData();
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

    public static void nukeTables(){
        db.customerDAO().nukeTable();
        db.favoritDAO().nukeTable();
        db.productCategoryDAO().nukeTable();
        db.productDAO().nukeTable();
        db.productRatingDAO().nukeTable();
        db.savedOfferDAO().nukeTable();
        db.storeDAO().nukeTable();
        db.storeRatingDAO().nukeTable();
        db.storeTypeDAO().nukeTable();
        db.tagDAO().nukeTable();
    }

    public static void fillDbWithTestData(){

        Customer c1 = new Customer("Admin", "Admin", "admin@asdf.com");
        Customer c2 = new Customer("Max", "Muster", "susi@asdf.com");

        long i = db.customerDAO().insertCustomer(c1);
        c1.setId(i);
        i = db.customerDAO().insertCustomer(c2);
        c2.setId(i);

        StoreType st1 = new StoreType("Food");
        StoreType st2 = new StoreType("Tech");

        i = db.storeTypeDAO().insertStoreType(st1);
        st1.setId(i);
        i = db.storeTypeDAO().insertStoreType(st2);
        st2.setId(i);

        ProductCategory pc1 = new ProductCategory("Food");
        ProductCategory pc2 = new ProductCategory("Tech");

        i = db.productCategoryDAO().insertCategory(pc1);
        pc1.setId(i);
        i = db.productCategoryDAO().insertCategory(pc2);
        pc2.setId(i);

        Tag t1 = new Tag("Food");
        Tag t2 = new Tag("Tech");

        i = db.tagDAO().insertTag(t1);
        t1.setId(i);
        i = db.tagDAO().insertTag(t2);
        t2.setId(i);

        Store s1 = new Store("LoremIpsum", "LoremIpsum", "LoremIpsum-Store", "ex-link", st1.getId(),
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Main Street 7", "1010");
        Store s2 = new Store("MediaSat", "MediaSat", "MediaSat-Store", "ex-link", st2.getId(),
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Tech Street 1", "1010");
        Store s3 = new Store("ConTech", "ConTech", "ConTech-Store", "ex-link", st2.getId(),
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Test Street 192", "8010");
        i = db.storeDAO().insertStore(s1);
        s1.setId(i);
        i = db.storeDAO().insertStore(s2);
        s2.setId(i);
        i = db.storeDAO().insertStore(s3);
        s3.setId(i);

        Product p1 = new Product("Ham", "desc", 2.0, 10.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId());
        Product p2 = new Product("Egg", "desc",  1.3, 5.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId());
        Product p3 = new Product("TV", "desc",699.99, 25.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s2.getId(), pc2.getId());
        Product p4 = new Product("Computer", "desc", 1229.79, 12.5, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s3.getId(), pc2.getId());

        i = db.productDAO().insertProduct(p1);
        p1.setId(i);
        i = db.productDAO().insertProduct(p2);
        p2.setId(i);
        i = db.productDAO().insertProduct(p3);
        p3.setId(i);
        i = db.productDAO().insertProduct(p4);
        p4.setId(i);

        ProductRating pr1 = new ProductRating(p1.getId(), c1.getId(), 5, "Great!");
        ProductRating pr2 = new ProductRating(p2.getId(), c1.getId(), 3, "Meeh...");
        ProductRating pr3 = new ProductRating(p3.getId(), c2.getId(), 4, "Nice.");
        ProductRating pr4 = new ProductRating(p4.getId(), c1.getId(), 2, "Worst PC EVER!");
        ProductRating pr5 = new ProductRating(p4.getId(), c2.getId(), 5, "Best PC EVER!!!!");
        db.productRatingDAO().insertProductRating(pr1);
        db.productRatingDAO().insertProductRating(pr2);
        db.productRatingDAO().insertProductRating(pr3);
        db.productRatingDAO().insertProductRating(pr4);
        db.productRatingDAO().insertProductRating(pr5);

        StoreRating sr1 = new StoreRating(s1.getId(),c1.getId(), 5, "");
        StoreRating sr2 = new StoreRating(s2.getId(),c1.getId(), 3, "okay...");
        StoreRating sr3 = new StoreRating(s2.getId(),c2.getId(), 5, "Super helpful staff");

        db.storeRatingDAO().insertStoreRating(sr1);
        db.storeRatingDAO().insertStoreRating(sr2);
        db.storeRatingDAO().insertStoreRating(sr3);
    }
}
