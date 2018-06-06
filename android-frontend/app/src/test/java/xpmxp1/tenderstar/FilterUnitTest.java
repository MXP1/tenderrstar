package xpmxp1.tenderstar;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductCategory;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.StoreType;


public class FilterUnitTest{

    List<Store> stores = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    Filter filter_products;
    Filter filter_stores;

    @Before
    public void initialize() {
        initStoresProducts();
    }



    public void initStoresProducts(){
        StoreType st1 = new StoreType("Food");

        Store store1 = new Store("Interspar", "Interspar", "Interspar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(22,0), true), "Spar Street 3", "8010", 47.061020, 15.426144);
        Store store2 = new Store("Merkur", "Merkur", "Merkur", "www.merkurmarkt.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010", 47.057921, 15.439319);
        Store store3 = new Store("Penny", "Penny", "Penny", "https://www.penny.at/", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010", 47.071197, 15.431112);


        stores.add(store1);
        stores.add(store2);
        stores.add(store3);

        ProductCategory pc1 = new ProductCategory("Food");
        ProductCategory pc2 = new ProductCategory("Tech");

        Product temp1 = new Product("Butter", "desc", 2.0, 10.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), store1.getId(), pc1.getId());
        Product temp2 = new Product("Egg", "desc",  1.3, 5.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), store1.getId(), pc1.getId());
        Product temp3 = new Product("Milk", "desc",699.99, 25.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), store2.getId(), pc1.getId());
        Product temp4 = new Product("Laptop", "desc", 1229.79, 12.5, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), store3.getId(), pc2.getId());

        products.add(temp1);
        products.add(temp2);
        products.add(temp3);
        products.add(temp4);

        filter_products = new Filter(products);
        filter_stores = new Filter(stores, 1);
    }


    @Test
    public void testSearchProduct1() throws Exception {
        filter_products.setSearchString("Apple");
        List<Product> results = filter_products.results();

        assertEquals(0, results.size());
    }

    @Test
    public void testSearchProduct2() throws Exception {
        filter_products.setSearchString("Butter");
        List<Product> results = filter_products.results();

        assertEquals(1, results.size());
    }

    @Test
    public void testSearchStore1() throws Exception {
        filter_stores.setSearchString("Penny");
        List<Store> results = filter_stores.resultsStore();

        assertEquals(1, results.size());
    }

    @Test
    public void testSearchStore2() throws Exception {
        filter_stores.setSearchString("Hofer");
        List<Store> results = filter_stores.resultsStore();

        assertEquals(0, results.size());
    }
}
