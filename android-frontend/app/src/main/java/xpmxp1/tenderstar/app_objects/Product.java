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
    public String stores;
    public String postal;

    public Product() {};
    public Product(String name, Category category, String description, float price, String store, String postal) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.tags = new ArrayList<>();
        this.stores = store;
        this.postal = postal;
    }
    public Product(String name, Category category, String description, float price, List<Tag> tags, String stores) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.tags = tags;
        this.stores = stores;
    }

    public Product(String name, Category category, String description, float price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.tags = new ArrayList<>();
    }

    public String getPriceAsString() {
        return String.format("%.2f", price) + "€";
    }
}
