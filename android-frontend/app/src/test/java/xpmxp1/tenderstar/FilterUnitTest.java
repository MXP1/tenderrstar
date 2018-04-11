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
public class FilterUnitTest {
    List<Product> products = new ArrayList<>();
    Filter filter;

    Tag tagCat = new Tag("Cat");
    Tag tagAnimal = new Tag("Animal");
    Tag tagVegetable = new Tag("Vegetable");
    Tag tagFruit = new Tag("Fruit");
    Tag tagSpirits = new Tag("Spirits");

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

        tempProduct = new Product("Whiskey", Product.Category.ALCOHOL);
        tempProduct.tags.add(tagSpirits);
        tempProduct.stores.add(storeBilla);
        tempProduct.stores.add(storeSpar);
        products.add(tempProduct);

        tempProduct = new Product("Jack Daniels", Product.Category.ALCOHOL);
        tempProduct.tags.add(tagSpirits);
        tempProduct.stores.add(storeBilla);
        tempProduct.stores.add(storePenny);
        products.add(tempProduct);

        tempProduct = new Product("Banana", Product.Category.FOOD);
        tempProduct.tags.add(tagFruit);
        tempProduct.stores.add(storePenny);
        products.add(tempProduct);

        tempProduct = new Product("Whiskas", Product.Category.CATFOOD);
        tempProduct.tags.add(tagAnimal);
        tempProduct.tags.add(tagCat);
        tempProduct.stores.add(storeSpar);
        products.add(tempProduct);

        tempProduct = new Product("Carrot", Product.Category.FOOD);
        tempProduct.tags.add(tagVegetable);
        tempProduct.stores.add(storeBilla);
        products.add(tempProduct);

        tempProduct = new Product("Paprika", Product.Category.FOOD);
        tempProduct.tags.add(tagVegetable);
        tempProduct.stores.add(storeSpar);
        products.add(tempProduct);


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

        filter.addTag(tagVegetable);
        List<Product> results = filter.results();

        assertEquals(2, results.size());
        assertEquals("Carrot", results.get(0).name);
    }

    @Test
    public void testTags2() throws Exception {
        filter.addTag(tagCat);
        filter.addTag(tagAnimal);
        List<Product> results = filter.results();

        assertEquals(1, results.size());
        assertEquals("Whiskas", results.get(0).name);
    }

    @Test
    public void testStore() throws Exception {
        filter.addStore(storeBilla);
        List<Product> results = filter.results();

        assertEquals(3, results.size());
    }

    @Test
    public void testSearchString1() throws Exception {
        filter.setSearchString("Banana");
        List<Product> results = filter.results();

        assertEquals("Banana", results.get(0).name);
    }

    @Test
    public void testSearchString2() throws Exception {
        filter.setSearchString("Apple");
        List<Product> results = filter.results();

        assertEquals(0, results.size());
    }

    @Test
    public void testSearchString3() throws Exception {
        filter.setSearchString("Whiskey Whiskas Banana");
        List<Product> results = filter.results();

        assertEquals(3, results.size());
    }

    @Test
    public void testSearchString4() throws Exception {
        filter.setSearchString("Banana Whiskas ");
        List<Product> results = filter.results();

        assertEquals(2, results.size());
    }

    @Test
    public void testSearchString5() throws Exception {
        filter.setSearchString("whiskey BANANA");
        List<Product> results = filter.results();

        assertEquals(2, results.size());
    }

    @Test
    public void testSearchString6() throws Exception {
        filter.setSearchString("Jack Daniels Banana");
        List<Product> results = filter.results();

        assertEquals(2, results.size());
        assertEquals("Jack Daniels", results.get(0).name);
    }

    @Test
    public void testCombination1() throws Exception {
        filter.setSearchString("Jack Daniels Banana");
        filter.addTag(tagSpirits);
        List<Product> results = filter.results();

        assertEquals(1, results.size());
        assertEquals("Jack Daniels", results.get(0).name);
    }

    @Test
    public void testCombination2() throws Exception {
        filter.setSearchString("Jack Daniels Banana");
        filter.addTag(tagSpirits);
        filter.addStore(storeBilla);
        filter.addStore(storePenny);
        List<Product> results = filter.results();

        assertEquals(1, results.size());
        assertEquals("Jack Daniels", results.get(0).name);
    }

    @Test
    public void testCombination3() throws Exception {
        filter.setSearchString("Jack Daniels");
        filter.addTag(tagSpirits);
        filter.addStore(storeSpar);
        List<Product> results = filter.results();

        assertEquals(0, results.size());
    }
}