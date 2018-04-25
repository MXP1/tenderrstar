package xpmxp1.tenderstar;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;
import static org.junit.Assert.assertNotEquals;

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

import xpmxp1.tenderstar.app_objects.SavedOffer;
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
    private  CustomerDAO customerDAO;
    private StoreDAO storeDAO;
    private ProductDAO productDAO;
    private SavedOfferDAO savedOfferDAO;
    private TenderstarDB db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, TenderstarDB.class).build();
        customerDAO = db.customerDAO();
        storeDAO = db.storeDAO();
        productDAO = db.productDAO();
        savedOfferDAO = db.savedOfferDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void ConsistencyTest() throws Exception {
        productAutoIncrementTest();
        insertCustomerTest();
        insertStoreTest();
        savedOfferForCustomerTest();
        typeConversionTest();
        getAllProductsForStoreTest();
    }

    @Test
    public void productAutoIncrementTest() throws Exception {
        Product product1 = new Product("AAAA", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 0);
        Product product2 = new Product("BBBB", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 1);
        Product product3 = new Product("CCCC", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 2);

        long i = productDAO.insertProduct(product1);
        assertNotEquals(i, -1);
        product1.setId(i);

        i = productDAO.insertProduct(product2);
        assertNotEquals(i, -1);
        product2.setId(i);

        i = productDAO.insertProduct(product3);
        assertNotEquals(i, -1);
        product3.setId(i);

        assertNotEquals(0, product1.getId());
        assertNotEquals(0, product2.getId());
        assertNotEquals(0, product3.getId());

        Log.d("DatabaseTest", "P1 Id = " + product1.getId());
        Log.d("DatabaseTest", "P2 Id = " + product2.getId());
        Log.d("DatabaseTest", "P3 Id = " + product3.getId());

        List<Product> products = productDAO.getAllProducts();

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }

    }

    @Test
    public void insertCustomerTest() throws Exception {
        Customer kunde1 = new Customer("Rene", "abcd", "asdf@asdf.at");
        Customer kunde2 = new Customer("Sebastian", "abcd", "asdf@asdf.at");

        long i = customerDAO.insertCustomer(kunde1);
        assertNotEquals(i, -1);
        kunde1.setId(i);

        i = customerDAO.insertCustomer(kunde2);
        assertNotEquals(i, -1);
        kunde2.setId(i);


        List<Customer> customers = customerDAO.getAllCustomers();

        for(Customer c : customers) {
            Log.d("DatabaseTest", "ID: " + c.getId());
            Log.d("DatabaseTest", "Username: " + c.getUsername());
            Log.d("DatabaseTest", "Password: " + c.getPassword());
            Log.d("DatabaseTest", "E-Mail: " + c.getEmail());
        }
    }

    @Test
    public void insertStoreTest() throws Exception {
        Store store1 = new Store("ASDF-Store", "asdf", "ASDF", 1, 1, "00:00-24:00");
        Store store2 = new Store("LOREM-IPSUM-Store", "asdf", "LOREM-IPSUM", 1, 1, "00:00-24:00");

        long i = storeDAO.insertStore(store1);
        assertNotEquals(i, -1);
        store1.setId(i);

        i = storeDAO.insertStore(store2);
        assertNotEquals(i, -1);
        store2.setId(i);


        List<Store> stores = storeDAO.getAllStores();

        for(Store s : stores) {
            Log.d("DatabaseTest", "ID: " + s.getId());
            Log.d("DatabaseTest", "Username: " + s.getUsername());
            Log.d("DatabaseTest", "Password: " + s.getPassword());
            Log.d("DatabaseTest", "Open Hours:: " + s.getOpenHours());
        }
    }

    @Test
    public void typeConversionTest()  throws  Exception {
        Product product = new Product("asdf", 5.0, 2.0, new Date(System.currentTimeMillis()/1000), new Date(System.currentTimeMillis()/1000 + 12345) , 5);

        long i = productDAO.insertProduct(product);
        assertNotEquals(i, -1);
        product.setId(i);

        List<Product> products = productDAO.getAllProducts();

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }

    }

    @Test
    public void getAllProductsForStoreTest() throws Exception {
        Store store = new Store("a", "a", "Store A", 1,1, "00:00-24:00");
        long i = storeDAO.insertStore(store);
        assertNotEquals(i, -1);

        Product product1 = new Product("AAAA", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , store.getId());
        Product product2 = new Product("BBBB", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , store.getId());
        Product product3 = new Product("CCCC", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , 2);

        i = productDAO.insertProduct(product1);
        assertNotEquals(i, -1);

        i = productDAO.insertProduct(product2);
        assertNotEquals(i, -1);

        i = productDAO.insertProduct(product3);
        assertNotEquals(i, -1);

        Log.d("DatabasesTest", "store id = " + store.getId());

        List<Product> products = productDAO.getAllProductsForStore(store.getId());

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
            Log.d("DatabaseTest", "FromDate: " + p.getFromDate());
            Log.d("DatabaseTest", "ToDate: " + p.getToDate());
        }
    }

    @Test
    public void savedOfferForCustomerTest() throws Exception {
        Log.d("DatabaseTest", "---------------savedOfferTestStart-------------");
        Store store = new Store("a", "a", "Store A", 1,1, "00:00-24:00");
        long i = storeDAO.insertStore(store);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Store return id = " + i);


        Product product1 = new Product("SavedOffer", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , store.getId());
        Product product2 = new Product("BBBB", 5.0, 2.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 12345) , store.getId());
        Customer kunde1 = new Customer("Rene", "abcd", "asdf@asdf.at");

        i = productDAO.insertProduct(product1);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Product1 return id = " + i);
        product1.setId(i);

        i = productDAO.insertProduct(product2);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Product2 return id = " + i);
        product2.setId(i);

        i = customerDAO.insertCustomer(kunde1);
        assertNotEquals(i, -1);
        Log.d("DatabaseTest", "Customer return id = " + i);
        kunde1.setId(i);

/*
        Log.d("DatabaseTest", "P1_ID = " + product1.getId());
        Log.d("DatabaseTest", "P2_ID = " + product2.getId());
        Log.d("DatabaseTest", "C_ID = " + kunde1.getId());
*/

        SavedOffer savedOffer = new SavedOffer(kunde1.getId(), product1.getId());

        i = savedOfferDAO.insertSavedOffer(savedOffer);
        assertNotEquals(i, -1);

        Log.d("DatabaseTest", "SavedOffer return id = " + i);

        List<Product> products = savedOfferDAO.getSavedOffersForCustomer(kunde1.getId());

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
        }

        Log.d("DatabaseTest", "--------------------------------------------------");

        /*products = productDAO.getAllProducts();

        for(Product p : products) {
            Log.d("DatabaseTest", "ID: " + p.getId());
            Log.d("DatabaseTest", "Name: " + p.getName());
        }*/

    }

}

