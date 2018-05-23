package xpmxp1.tenderstar;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.web.proto.sugar.WebSugar;
import android.util.Log;
import android.widget.ExpandableListView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.ProductCategory;
import xpmxp1.tenderstar.app_objects.ProductRating;
import xpmxp1.tenderstar.app_objects.SavedOffer;
import xpmxp1.tenderstar.app_objects.StoreRating;
import xpmxp1.tenderstar.app_objects.StoreType;
import xpmxp1.tenderstar.app_objects.Tag;
import xpmxp1.tenderstar.database.DAO.CustomerDAO;
import xpmxp1.tenderstar.database.DAO.ProductDAO;
import xpmxp1.tenderstar.database.DAO.SavedOfferDAO;
import xpmxp1.tenderstar.database.DAO.StoreDAO;
import xpmxp1.tenderstar.database.TenderstarDB;
import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;

@RunWith(JUnit4.class)
public class DatabaseTest {
    private TenderstarDB db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, TenderstarDB.class).build();

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
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Main Street 7", "1010", 0, 0);
        Store s2 = new Store("MediaSat", "MediaSat", "MediaSat-Store", "ex-link", st2.getId(),
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Tech Street 1", "1010", 0, 0);
        Store s3 = new Store("ConTech", "ConTech", "ConTech-Store", "ex-link", st2.getId(),
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "Test Street 192", "8010", 0, 0);
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

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void stressTest() throws Exception {
        db.productDAO().nukeTable();
        for(int i = 0; i < 5000; i++) {
            Product product = new Product("Test", "Test", 2.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 1, 1);
            db.productDAO().insertProduct(product);
        }
        List<Product> products = db.productDAO().getAllProducts();
        assertEquals(5000, products.size());
    }

    @Test
    public void nukeTablesTest() throws Exception {
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

        assertEquals(0, db.customerDAO().getAllCustomers().size());
        assertEquals(0, db.productCategoryDAO().getAllProductCategories().size());
        assertEquals(0, db.productDAO().getAllProducts().size());
        assertEquals(0, db.storeDAO().getAllStores().size());
        assertEquals(0, db.storeTypeDAO().getAllStoreTypes().size());
        assertEquals(0, db.tagDAO().getAllTags().size());
    }

    @Test
    public void CustomerDAOTest() throws Exception {
        List<Customer> customers = db.customerDAO().getAllCustomers();
        if(customers.size() == 0){
            throw new Exception("Query: No customers saved in DB!");
        }
        Customer customer = customers.get(0);
        long customer2ID = customers.get(1).getId();
        customer.setUsername("Susi");
        customer.setPassword("Susi");
        db.customerDAO().updateCustomer(customer);
        Customer updatedCustomer = db.customerDAO().loginCustomer("Susi", "Susi");
        assertEquals("Susi", updatedCustomer.getUsername());
        assertEquals("Susi", updatedCustomer.getPassword());
        db.customerDAO().deleteCustomer(updatedCustomer);
        customers = db.customerDAO().getAllCustomers();
        assertEquals(1, customers.size());
        assertEquals(null, db.customerDAO().getCustomer(updatedCustomer.getId()));
        assertNotEquals(null, db.customerDAO().getCustomer(customer2ID));
    }

    @Test
    public void FavoritDAOTest() throws Exception {
        Customer customer = db.customerDAO().getAllCustomers().get(0);
        Store store = db.storeDAO().getAllStores().get(0);
        if(customer == null || store == null) {
            throw new Exception("Query: No data saved in DB!");
        }
        List<Store> favoriteStores = db.favoritDAO().getAllFavoritesStores(customer.getId());
        assertEquals(0, favoriteStores.size());

        Favorit favorit = new Favorit(customer.getId(), store.getId());
        db.favoritDAO().insertFavorit(favorit);
        favoriteStores = db.favoritDAO().getAllFavoritesStores(customer.getId());
        assertNotEquals(0, favoriteStores.size());

        db.favoritDAO().deleteFavorit(favorit);
        favoriteStores = db.favoritDAO().getAllFavoritesStores(customer.getId());
        assertEquals(0, favoriteStores.size());
    }

    @Test
    public void ProductCategoryDAOTest() throws Exception {
        List<ProductCategory> categories = db.productCategoryDAO().getAllProductCategories();
        if (categories.size() == 0) {
            throw new Exception("Query: No ProductCategory found in DB!");
        }
        ProductCategory category = categories.get(0);
        category.setName("UpdatedCategory");
        db.productCategoryDAO().updateCategory(category);
        categories = db.productCategoryDAO().getAllProductCategories();
        assertEquals("UpdatedCategory", categories.get(0).getName());
        String categoryName = db.productCategoryDAO().getCategoryForProduct(categories.get(0).getId());
        assertEquals("UpdatedCategory", categoryName);
        db.productCategoryDAO().deleteCategory(category);
        categories = db.productCategoryDAO().getAllProductCategories();
        assertEquals(1, categories.size());
        ProductCategory productCategory = new ProductCategory("Catfood");
        db.productCategoryDAO().insertCategory(productCategory);
        categories = db.productCategoryDAO().getAllProductCategories();
        assertEquals(2, categories.size());
    }

    @Test
    public void ProductStoreDAOTest() throws Exception {
        List<Product> products = db.productDAO().getAllProductsForStoreName("LoremIpsum-Store");
        if(products.size() == 0) {
            throw new Exception("Query: No Products found in DB!");
        }
        Product product = products.get(0);
        product.setDescription("UpdatedDescription");
        db.productDAO().updateProduct(product);
        products = db.productDAO().getAllProducts();
        assertEquals("UpdatedDescription", products.get(0).getDescription());
        Store store = db.storeDAO().getAllStores().get(0);
        if(store == null) {
            throw new Exception("Query: No Store found in DB!");
        }
        products = db.productDAO().getAllProductsForStore(store.getId());
        assertEquals(2, products.size());
        db.productDAO().deleteProduct(products.get(0));
        products = db.productDAO().getAllProductsForStore(store.getId());
        assertEquals(1, products.size());
    }

    @Test
    public void ProductDAOTest() throws Exception {
        List<Product> products = db.productDAO().getAllProducts();
        if(products.size() == 0) {
            throw new Exception("Query: No Products found in DB!");
        }
        Product product = products.get(0);
        product.setDescription("UpdatedDescription");
        db.productDAO().updateProduct(product);
        products = db.productDAO().getAllProducts();
        assertEquals("UpdatedDescription", products.get(0).getDescription());
        Store store = db.storeDAO().getAllStores().get(0);
        if(store == null) {
            throw new Exception("Query: No Store found in DB!");
        }
        products = db.productDAO().getAllProductsForStore(store.getId());
        assertEquals(2, products.size());
        db.productDAO().deleteProduct(products.get(0));
        products = db.productDAO().getAllProductsForStore(store.getId());
        assertEquals(1, products.size());
    }

    @Test
    public void ProductRatingDAOTest() throws Exception {
        List<Product> products = db.productDAO().getAllProducts();
        if(products.size() == 0) {
            throw new Exception("Query: No Products found in DB!");
        }
        Product product = products.get(0);
        List<ProductRating> productRatings = db.productRatingDAO().getRatingsForProduct(product.getId());
        assertNotEquals(0, productRatings.size());
        ProductRating rating = productRatings.get(0);
        rating.setComment("Update");
        rating.setRating(1);
        db.productRatingDAO().updateProductRating(rating);
        productRatings = db.productRatingDAO().getRatingsForProduct(product.getId());
        assertEquals("Update", productRatings.get(0).getComment());
        assertEquals(1, productRatings.get(0).getRating());
        db.productRatingDAO().deleteProductRating(productRatings.get(0));
        productRatings = db.productRatingDAO().getRatingsForProduct(product.getId());
        assertEquals(0, productRatings.size());
    }

    @Test
    public void SavedOfferDAOTest() throws Exception {
        List<Customer> customers = db.customerDAO().getAllCustomers();
        List<Product> products = db.productDAO().getAllProducts();

        if(customers.size() == 0 || products.size() == 0) {
            throw new Exception("Query: No Data found in DB!");
        }

        Customer customer = customers.get(0);
        Product product = products.get(0);
        SavedOffer savedOffer = new SavedOffer(customer.getId(), product.getId());
        db.savedOfferDAO().insertSavedOffer(savedOffer);
        List<Product> savedOffers = db.savedOfferDAO().getSavedOffersForCustomer(customer.getId());
        assertNotEquals(0, savedOffers.size());

        db.savedOfferDAO().deleteSavedOffer(savedOffer);
        savedOffers = db.savedOfferDAO().getSavedOffersForCustomer(customer.getId());
        assertEquals(0, savedOffers.size());
    }

    @Test
    public void StoreDAOTest() throws Exception {
        List<Store> stores = db.storeDAO().getAllStores();
        if(stores.size() == 0) {
            throw new Exception("Query: No Stores found in DB!");
        }
        Store store = stores.get(0);
        store.setStoreName("UpdatedStore");
        db.storeDAO().updateStore(store);
        store = db.storeDAO().getStore(store.getId());
        assertEquals("UpdatedStore", store.getStoreName());
        db.storeDAO().deleteStore(store);
        store = db.storeDAO().getStore(store.getId());
        assertEquals(null, store);
    }

    @Test
    public void StoreRatingDAOTest() throws Exception {
        List<Store> stores = db.storeDAO().getAllStores();
        if(stores.size() == 0) {
            throw new Exception("Query: No Products found in DB!");
        }
        Store store = stores.get(0);
        List<StoreRating> storeRatings = db.storeRatingDAO().getRatingForStore(store.getId());
        assertNotEquals(0, storeRatings.size());
        StoreRating rating = storeRatings.get(0);
        rating.setComment("Update");
        rating.setRating(1);
        db.storeRatingDAO().updateStoreRating(rating);
        storeRatings = db.storeRatingDAO().getRatingForStore(store.getId());
        assertEquals("Update", storeRatings.get(0).getComment());
        assertEquals(1, storeRatings.get(0).getRating());
        db.storeRatingDAO().deleteStoreRating(storeRatings.get(0));
        storeRatings = db.storeRatingDAO().getRatingForStore(store.getId());
        assertEquals(0, storeRatings.size());
    }

    @Test
    public void StoreTypeDAOTest() throws Exception {
        List<StoreType> types = db.storeTypeDAO().getAllStoreTypes();
        if(types.size() == 0){
            throw new Exception("Query: No ProductCategory found in DB!");
        }
        StoreType type = types.get(0);
        type.setType("UpdatedType");
        db.storeTypeDAO().updateStoreType(type);
        types = db.storeTypeDAO().getAllStoreTypes();
        assertEquals("UpdatedType", types.get(0).getType());
        db.storeTypeDAO().deleteStoreType(type);
        types = db.storeTypeDAO().getAllStoreTypes();
        assertEquals(1, types.size());
        StoreType storeType = new StoreType("Drogerie");
        db.storeTypeDAO().insertStoreType(storeType);
        types = db.storeTypeDAO().getAllStoreTypes();
        assertEquals(2, types.size());
        assertEquals("Drogerie", types.get(1).getType());
    }

    @Test
    public void TagDAOTest() throws Exception {
        List<Tag> tags = db.tagDAO().getAllTags();
        if(tags.size() == 0){
            throw new Exception("Query: No Tags found in DB!");
        }
        Tag tag = tags.get(0);
        tag.setName("UpdatedType");
        db.tagDAO().updateTag(tag);
        tags = db.tagDAO().getAllTags();
        assertEquals("UpdatedType", tags.get(0).getName());
        db.tagDAO().deleteTag(tag);
        tags = db.tagDAO().getAllTags();
        assertEquals(1, tags.size());
        tag = new Tag("Food");
        db.tagDAO().insertTag(tag);
        tags = db.tagDAO().getAllTags();
        assertEquals(2, tags.size());
        assertEquals("Food", tags.get(1).getName());
    }


    @Test
    public void productAutoIncrementTest() throws Exception {
        nukeTablesTest();
        Product product1 = new Product("AAAA", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 0,1);
        Product product2 = new Product("BBBB", "asdf asdf asdf", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 1,1);
        Product product3 = new Product("CCCC", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 2,1);

        long i = db.productDAO().insertProduct(product1);
        assertNotEquals(i, -1);
        product1.setId(i);

        i = db.productDAO().insertProduct(product2);
        assertNotEquals(i, -1);
        product2.setId(i);

        i = db.productDAO().insertProduct(product3);
        assertNotEquals(i, -1);
        product3.setId(i);

        assertNotEquals(0, product1.getId());
        assertNotEquals(0, product2.getId());
        assertNotEquals(0, product3.getId());

        Log.d("DatabaseTest", "P1 Id = " + product1.getId());
        Log.d("DatabaseTest", "P2 Id = " + product2.getId());
        Log.d("DatabaseTest", "P3 Id = " + product3.getId());

        List<Product> products = db.productDAO().getAllProducts();

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }

    }

    @Test
    public void insertCustomerTest() throws Exception {
        nukeTablesTest();
        Customer kunde1 = new Customer("Rene", "abcd", "asdf@asdf.at");
        Customer kunde2 = new Customer("Sebastian", "abcd", "asdf@asdf.at");

        long i = db.customerDAO().insertCustomer(kunde1);
        assertNotEquals(i, -1);
        kunde1.setId(i);

        i = db.customerDAO().insertCustomer(kunde2);
        assertNotEquals(i, -1);
        kunde2.setId(i);

        List<Customer> customers = db.customerDAO().getAllCustomers();

        for(Customer c : customers) {
            Log.d("DatabaseTest", "ID: " + c.getId());
            Log.d("DatabaseTest", "Username: " + c.getUsername());
            Log.d("DatabaseTest", "Password: " + c.getPassword());
            Log.d("DatabaseTest", "E-Mail: " + c.getEmail());
        }
    }

    @Test
    public void insertStoreTest() throws Exception {
        nukeTablesTest();
        Store store1 = new Store("ASDF-Store", "asdf", "ASDF", "www.asdf.at", 1,
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "asdf", "213", 0, 0);
        Store store2 = new Store("ASDF-Store", "asdf", "irgendwas", "www.asdf.at", 1,
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "asdf", "213", 0, 0);

        long i = db.storeDAO().insertStore(store1);
        assertNotEquals(i, -1);
        store1.setId(i);

        i = db.storeDAO().insertStore(store2);
        assertNotEquals(i, -1);
        store2.setId(i);

        List<Store> stores = db.storeDAO().getAllStores();

        for(Store s : stores) {
            Log.d("DatabaseTest", "ID: " + s.getId());
            Log.d("DatabaseTest", "Username: " + s.getUsername());
            Log.d("DatabaseTest", "Password: " + s.getPassword());
            Log.d("DatabaseTest", "Open Hours:: " + s.getOpeningHours().toString());
        }
    }

    @Test
    public void typeConversionTest()  throws  Exception {
        nukeTablesTest();
        Product product = new Product("AAAA", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 0, 1);

        long i = db.productDAO().insertProduct(product);
        assertNotEquals(i, -1);
        product.setId(i);

        List<Product> products = db.productDAO().getAllProducts();

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }

    }

    @Test
    public void getAllProductsForStoreTest() throws Exception {
        nukeTablesTest();
        Store store = new Store("ASDF-Store", "asdf", "irgendwas", "www.asdf.at", 1,
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "asdf", "213", 0, 0);
        long i = db.storeDAO().insertStore(store);
        assertNotEquals(i, -1);

        Product product1 = new Product("AAAA", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 0, 1);
        Product product2 = new Product("BBBB", "asdf asdf asdf", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 1, 1);
        Product product3 = new Product("CCCC", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 2, 1);

        i = db.productDAO().insertProduct(product1);
        assertNotEquals(i, -1);
        product1.setId(i);

        i = db.productDAO().insertProduct(product2);
        assertNotEquals(i, -1);
        product2.setId(i);

        i = db.productDAO().insertProduct(product3);
        assertNotEquals(i, -1);
        product3.setId(i);

        Log.d("DatabasesTest", "store id = " + store.getId());

        List<Product> products = db.productDAO().getAllProductsForStore(store.getId());

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }
    }

    @Test
    public void savedOfferForCustomerTest() throws Exception {
        nukeTablesTest();
        Store store = new Store("ASDF-Store", "asdf", "irgendwas", "www.asdf.at", 1,
                new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false), "asdf", "213", 0, 0);

        long i = db.storeDAO().insertStore(store);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Store return id = " + i);

        Product product1 = new Product("AAAA", "asdf asdf asdf",5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 0, 1);
        Product product2 = new Product("BBBB", "asdf asdf asdf", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 1, 1);

        Customer kunde1 = new Customer("Rene", "abcd", "asdf@asdf.at");

        i = db.productDAO().insertProduct(product1);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Product1 return id = " + i);
        product1.setId(i);

        i = db.productDAO().insertProduct(product2);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Product2 return id = " + i);
        product2.setId(i);

        i = db.customerDAO().insertCustomer(kunde1);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Customer return id = " + i);
        kunde1.setId(i);

        SavedOffer savedOffer = new SavedOffer(kunde1.getId(), product1.getId());

        i = db.savedOfferDAO().insertSavedOffer(savedOffer);
        assertNotEquals(i, -1);

        Log.d("DatabaseTest", "SavedOffer return id = " + i);

        List<Product> products = db.savedOfferDAO().getSavedOffersForCustomer(kunde1.getId());

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
        }
    }
}

