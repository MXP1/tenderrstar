package xpmxp1.tenderstar;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * Created by dominik on 18.04.18.
 */

public class Database {
    // Singleton
    static private Database instance = null;
    private static TenderstarDB db = CustomApplication.getDb();

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
        Customer c2 = new Customer("Max", "Muster", "max@asdf.com");
        Customer c3 = new Customer("Susi", "Muster", "susi@asdf.com");

        long i = db.customerDAO().insertCustomer(c1);
        c1.setId(i);
        i = db.customerDAO().insertCustomer(c2);
        c2.setId(i);
        i = db.customerDAO().insertCustomer(c3);
        c3.setId(i);

        StoreType st1 = new StoreType("Grocery");
        StoreType st2 = new StoreType("Electronic");
        StoreType st3 = new StoreType("Drugstore");
        StoreType st4 = new StoreType("Furniture");

        i = db.storeTypeDAO().insertStoreType(st1);
        st1.setId(i);
        i = db.storeTypeDAO().insertStoreType(st2);
        st2.setId(i);
        i = db.storeTypeDAO().insertStoreType(st3);
        st3.setId(i);
        i = db.storeTypeDAO().insertStoreType(st4);
        st4.setId(i);

        ProductCategory pc1 = new ProductCategory("Food");
        ProductCategory pc2 = new ProductCategory("Beverages");
        ProductCategory pc3 = new ProductCategory("TV");
        ProductCategory pc4 = new ProductCategory("Computer");
        ProductCategory pc5 = new ProductCategory("Movie");
        ProductCategory pc6 = new ProductCategory("Games");
        ProductCategory pc7 = new ProductCategory("Perfume");

        ProductCategory pc8 = new ProductCategory("Medical Care");
        ProductCategory pc9 = new ProductCategory("Makeup");
        ProductCategory pc10 = new ProductCategory("Chair");
        ProductCategory pc11 = new ProductCategory("Table");
        ProductCategory pc12 = new ProductCategory("Wardrobe");
        ProductCategory pc13 = new ProductCategory("Bed");

        i = db.productCategoryDAO().insertCategory(pc1);
        pc1.setId(i);
        i = db.productCategoryDAO().insertCategory(pc2);
        pc2.setId(i);
        i = db.productCategoryDAO().insertCategory(pc3);
        pc3.setId(i);
        i = db.productCategoryDAO().insertCategory(pc4);
        pc4.setId(i);
        i = db.productCategoryDAO().insertCategory(pc5);
        pc5.setId(i);
        i = db.productCategoryDAO().insertCategory(pc6);
        pc6.setId(i);
        i = db.productCategoryDAO().insertCategory(pc7);
        pc7.setId(i);
        i = db.productCategoryDAO().insertCategory(pc8);
        pc8.setId(i);
        i = db.productCategoryDAO().insertCategory(pc9);
        pc9.setId(i);
        i = db.productCategoryDAO().insertCategory(pc10);
        pc10.setId(i);
        i = db.productCategoryDAO().insertCategory(pc11);
        pc11.setId(i);
        i = db.productCategoryDAO().insertCategory(pc12);
        pc12.setId(i);
        i = db.productCategoryDAO().insertCategory(pc13);
        pc13.setId(i);

        Tag t1 = new Tag("Food");
        Tag t2 = new Tag("Tech");

        i = db.tagDAO().insertTag(t1);
        t1.setId(i);
        i = db.tagDAO().insertTag(t2);
        t2.setId(i);

        Store s1 = new Store("Billa", "Billa", "Billa", "www.billa.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(20,0), false), "Main Street 7", "1010");
        Store s2 = new Store("Hofer", "Hofer", "Hofer", "www.hofer.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(19,30), true), "Main Street 2", "1010");
        Store s3 = new Store("Spar", "Spar", "Spar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(18,30), false), "Spar Street 1", "9010");
        Store s4 = new Store("Eurospar", "Eurospar", "Eurospar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(19,30), false), "Spar Street 2", "8010");
        Store s5 = new Store("Interspar", "Interspar", "Interspar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(22,0), true), "Spar Street 3", "8010");
        Store s6 = new Store("Merkur", "Merkur", "Merkur", "www.merkurmarkt.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010");
        Store s7 = new Store("Penny", "Penny", "Penny", "https://www.penny.at/", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010");

        Store s8 = new Store("MediaMarkt", "MediaMarkt", "MediaMarkt", "www.mediamarkt.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(9,30), new OpeningHours.Time(19,30), false), "Acorn Avenue 1", "4010");
        Store s9 = new Store("Saturn", "Saturn", "Saturn", "www.saturn.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "West Lane 192", "4010");
        Store s10 = new Store("Conrad", "Conrad", "Conrad", "www.conrad.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(19,0), false), "Mount Lane 203", "8010");
        Store s11 = new Store("Hartlauer", "Hartlauer", "Hartlauer", "www.hartlauer.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Bath Boulevard 27", "1010");
        Store s12 = new Store("Best Buy", "Best Buy", "Best Buy", "www.bestbuy.com", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Hart Passage 82", "1010");
        Store s13 = new Store("Euronics", "Euronics", "Euronics", "www.euronics.de", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Flint Avenue 23", "8010");

        Store s14 = new Store("Bipa", "Bipa", "Bipa", "www.bipa.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Circus Street 54", "8010");
        Store s15 = new Store("DM", "DM", "DM", "www.meindm.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(18,30), false), "Windmill Route 14", "1010");
        Store s16 = new Store("Müller", "Müller", "Müller", "www.mueller-drogerie.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(20,0), false), "Hazelnut Row 7", "4010");
        Store s17 = new Store("Walgreens", "Walgreen", "Walgreen", "www.walgreens.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(22,30), false), "Castle Avenue 5", "4010");
        Store s18 = new Store("CVSHealth", "CVSHealth", "CVSHealth", "www.cvshealth.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Ivy Row 8", "1010");
        Store s19 = new Store("Express Scripts", "Express Scripts", "Express Scripts", "www.express-scripts.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(9,30), new OpeningHours.Time(21,0), true), "Serenity Row 1", "1010");

        Store s20 = new Store("Möbelix", "Möbelix", "Möbelix", "www.moebelix.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,30), false), "Bright Avenue 2", "8010");
        Store s21 = new Store("Kika", "Kika", "Kika", "www.kika.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(20,0), false), "Duke Passage 47", "8010");
        Store s22 = new Store("IKEA", "IKEA", "IKEA", "www.ikea.com", st4.getId(),
                new OpeningHours(new OpeningHours.Time(9,0), new OpeningHours.Time(20,0), true), "University Lane 16", "8010");
        Store s23 = new Store("XXXLutz", "XXXLutz", "XXXLutz", "www.xxxlutz.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Snowflake Street 73", "1010");
        Store s24 = new Store("Leiner", "Leiner", "Leiner", "www.leiner.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,30), true), "Butcher Boulevard 134", "4010");

        i = db.storeDAO().insertStore(s15);
        s15.setId(i);
        i = db.storeDAO().insertStore(s16);
        s16.setId(i);
        i = db.storeDAO().insertStore(s1);
        s1.setId(i);
        i = db.storeDAO().insertStore(s6);
        s6.setId(i);
        i = db.storeDAO().insertStore(s7);
        s7.setId(i);
        i = db.storeDAO().insertStore(s2);
        s2.setId(i);
        i = db.storeDAO().insertStore(s3);
        s3.setId(i);
        i = db.storeDAO().insertStore(s10);
        s10.setId(i);
        i = db.storeDAO().insertStore(s11);
        s11.setId(i);
        i = db.storeDAO().insertStore(s4);
        s4.setId(i);
        i = db.storeDAO().insertStore(s20);
        s20.setId(i);
        i = db.storeDAO().insertStore(s21);
        s21.setId(i);
        i = db.storeDAO().insertStore(s5);
        s5.setId(i);
        i = db.storeDAO().insertStore(s8);
        s8.setId(i);
        i = db.storeDAO().insertStore(s9);
        s9.setId(i);
        i = db.storeDAO().insertStore(s12);
        s12.setId(i);
        i = db.storeDAO().insertStore(s13);
        s13.setId(i);
        i = db.storeDAO().insertStore(s14);
        s14.setId(i);
        i = db.storeDAO().insertStore(s18);
        s18.setId(i);
        i = db.storeDAO().insertStore(s19);
        s19.setId(i);
        i = db.storeDAO().insertStore(s22);
        s22.setId(i);
        i = db.storeDAO().insertStore(s17);
        s17.setId(i);
        i = db.storeDAO().insertStore(s23);
        s23.setId(i);
        i = db.storeDAO().insertStore(s24);
        s24.setId(i);

        Product p1 = new Product("Ham", "desc", 2.0, 10.0,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId());
        Product p2 = new Product("Ham", "desc", 2.0, 10.0,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId();
        Product p3 = new Product("Ham", "desc", 2.0, 10.0,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId();
        Product p4 = new Product("Ham", "desc", 2.0, 10.0,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), s1.getId(), pc1.getId();

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
