package xpmxp1.tenderstar.app_objects;

import java.util.ArrayList;
import java.util.List;

import static xpmxp1.tenderstar.app_objects.Product.Category.FOOD;

/**
 * Created by dominik on 21.03.18.
 */

public class Product {
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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
        this.setCategory(category);
        this.tags = new ArrayList<>();
        this.stores = new ArrayList<>();
    }
    public Product(String name, Category category, List<Tag> tags, List<Store> stores) {
        this.name = name;
        this.setCategory(category);
        this.tags = tags;
        this.stores = stores;
    }
}
