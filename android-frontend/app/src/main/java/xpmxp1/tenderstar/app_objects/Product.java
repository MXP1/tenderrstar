package xpmxp1.tenderstar.app_objects;

import java.util.ArrayList;
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
    public String description;
    public float price;
    public List<Tag> tags;
    public List<Store> stores;

    public Product() {};
    public Product(String name, Category category, String description, float price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.tags = new ArrayList<>();
        this.stores = new ArrayList<>();
    }
    public Product(String name, Category category, String description, float price, List<Tag> tags, List<Store> stores) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.tags = tags;
        this.stores = stores;
    }
}
