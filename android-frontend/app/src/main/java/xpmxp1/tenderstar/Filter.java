package xpmxp1.tenderstar;

import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.Tag;

/**
 * Created by dominik on 21.03.18.
 */

public class Filter {
    private List<Product> products;
    private String searchString = "";
    private Product.Category category = null;
    private List<Tag> tags = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();

    public Filter(List<Product> products) {
        this.products = products;
    }

    public void reset() {
        searchString = "";
        category = null;
        tags = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void setCategory(Product.Category category) {
        this.category = category;
    }

    public List<Product> results() {
        List<Product> results = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            boolean matches = true;

            // Filter category
            if (category != null && product.category != category) {
                matches = false;
            }


            if (tags != null && !tags.isEmpty()) {
                if (product.tags != null && !product.tags.containsAll(tags)) {
                    matches = false;
                }

                else if (product.tags == null) {
                    matches = false;
                }
            }

            if (stores != null && !stores.isEmpty()) {
                if (product.stores != null && !product.stores.containsAll(stores)) {
                    matches = false;
                }
                else if (product.stores == null) {
                    matches = false;
                }
            }

            if (matches) {
                results.add(product);
            }
        }

        return results;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void addStore(Store store) {
        this.stores.add(store);
    }
}
