package xpmxp1.tenderstar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.Tag;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FilterUnitTest {
    List<Product> products = new ArrayList<>();
    Filter filter;

    Tag tag1 = new Tag("Cat");
    Tag tag2 = new Tag("Animal");

    Store store = new Store("Billa");

    public void initProducts() {
        List<Tag> tagList1 = new ArrayList<>();
        tagList1.add(tag1);
        tagList1.add(tag2);

        List<Store> storeList1 = new ArrayList<>();
        storeList1.add(store);

        products = new ArrayList<>();
        products.add(new Product("Whiskey", Product.Category.ALCOHOL));
        products.add(new Product("Banana", Product.Category.FOOD));
        products.add(new Product("Whiskas", Product.Category.CATFOOD, tagList1, storeList1));

        filter = new Filter(products);
    }

    @Test
    public void testCategory() throws Exception {
        initProducts();

        filter.setCategory(Product.Category.FOOD);
        List<Product> results = filter.results();
        System.out.print(products.size());
        assertEquals("Banana", results.get(0).name);
    }

    @Test
    public void testTags1() throws Exception {
        initProducts();

        filter.addTag(tag1);
        List<Product> results = filter.results();

        assertEquals("Whiskas", results.get(0).name);
    }

    @Test
    public void testTags2() throws Exception {
        initProducts();

        filter.addTag(tag1);
        filter.addTag(tag2);
        List<Product> results = filter.results();

        assertEquals("Whiskas", results.get(0).name);
    }

    @Test
    public void testStore() throws Exception {
        initProducts();
        filter.addStore(store);
        List<Product> results = filter.results();

        assertEquals("Whiskas", results.get(0).name);
    }
}