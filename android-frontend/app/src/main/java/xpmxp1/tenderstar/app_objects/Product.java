package xpmxp1.tenderstar.app_objects;

import java.util.List;

/**
 * Created by dominik on 21.03.18.
 */

public class Product {
    public enum Category {
        FOOD, ALCOHOL, CATFOOD
    }

    public String name;
    public Category category;
    public List<Tag> tags;
    public List<Store> stores;

    public Product() {};
    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
    public Product(String name, Category category, List<Tag> tags, List<Store> stores) {
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.stores = stores;
    }
}
