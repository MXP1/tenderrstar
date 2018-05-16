package xpmxp1.tenderstar;

import org.junit.Before;
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
public class StoreFilterUnitTest {
    List<Product> products = new ArrayList<>();
    Filter filter;

    Tag tagCat = new Tag("Cat");
    Tag tagAnimal = new Tag("Animal");
    Tag tagVegetable = new Tag("Vegetable");
    Tag tagFruit = new Tag("Fruit");
    Tag tagSpirits = new Tag("Spirits");
    Tag tagDairy = new Tag("Dairy");
    Tag tagDrink = new Tag("Drink");


    Store storeBilla = new Store("Billa");
    Store storeSpar = new Store("Spar");
    Store storePenny = new Store("Penny");

    @Before
    public void initialize() {
        initProducts();
    }

    public void initProducts() {
        Product tempProduct;
        products = new ArrayList<>();


        tempProduct = new Product("Milk", Product.Category.FOOD, "descr", 1.2f, "Billa", "8010");
        tempProduct.tags.add(tagDairy);
        products.add(tempProduct);

        tempProduct = new Product("Water", Product.Category.FOOD,"descr", 0.8f, "Spar", "4715");
        tempProduct.tags.add(tagDrink);
        products.add(tempProduct);

        tempProduct = new Product("Cereal", Product.Category.FOOD, "descr", 3.8f, "Spar", "4710");
        tempProduct.tags.add(tagFruit);
        products.add(tempProduct);

        tempProduct = new Product("Sausage", Product.Category.FOOD, "descr", 2.0f, "Spar", "8715");
        tempProduct.tags.add(tagAnimal);
        products.add(tempProduct);



        filter = new Filter(products);
    }

    @Test
    public void testCombination() throws Exception {
        filter.setSearchString("Milk");
        filter.addTag(tagDairy);
        List<Product> results = filter.results();

        assertEquals(1, results.size());
    }

    @Test
    public void testCombination1() throws Exception {
        filter.setSearchString("Billa");
        List<Product> results = filter.results();

        assertEquals(1, results.size());
    }

    @Test
    public void testCombination2() throws Exception {
        filter.setSearchString("Spar");
        List<Product> results = filter.results();

        assertEquals(3, results.size());
    }
}