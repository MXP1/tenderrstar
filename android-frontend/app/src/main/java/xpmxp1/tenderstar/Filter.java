package xpmxp1.tenderstar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.Tag;

/**
 * Created by dominik on 21.03.18.
 */

//TODO: FILTER nach Category mit DB Entity

public class Filter {
    private List<Product> products;
    private String searchString = "";
    //private Product.Category category = null;
    private List<Tag> tags = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();

    public Filter(List<Product> products) {
        this.products = products;
    }

    public void reset() {
        searchString = "";
        //category = null;
        tags = new ArrayList<>();
        stores = new ArrayList<>();
    }

    /*public void setCategory(Product.Category category) {
        this.category = category;
    }*/

    public List<Product> results() {
        List<Product> results = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            boolean matches = true;

            //TODO:
            // Filter category
            /*if (category != null && product.category != category) {
                matches = false;
            }*/

            // Filter tags
            if (tags != null && !tags.isEmpty()) {
                if (product.tags != null && !product.tags.containsAll(tags)) {
                    matches = false;
                }
                else if (product.tags == null) {
                    matches = false;
                }
            }

            // Filter stores
            if (stores != null && !stores.isEmpty()) {
                if (product.stores != null && !product.stores.containsAll(stores)) {
                    matches = false;
                }
                else if (product.stores == null) {
                    matches = false;
                }
            }

            // Filter searchString
            if (matches && searchString != "") {
                // create regex
                String searchPattern = createSearchRegex(searchString);
                Pattern pattern = Pattern.compile(".*?(?:(" + searchPattern + ").*?)");
                Matcher matcher = pattern.matcher(product.getName().toLowerCase());

                // find matches
                matches = matcher.matches();
            }

            // add product if filter matches
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
    public void setSearchString(String searchString) { this.searchString = searchString; }

    private String createSearchRegex(String searchString) {

        String[] stringList = searchString.split("\\s");
        String regex = "";

        for (int i = 0; i < stringList.length; i++) {
            regex += stringList[i].toLowerCase();
            if (i < stringList.length - 1)
                regex += "|";
        }

        return regex;
    }
}