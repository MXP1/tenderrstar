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

public class Filter {
    private List<Product> products;
    private String searchString = "";
    private List<Store> stores;

    public Filter(List<Product> products) {
        this.products = products;
    }

    public Filter(List<Store> stores, int a) {
        this.stores = stores;
    }

    public List<Store> resultsStore(){
        List<Store> resultsStore = new ArrayList<>();

        for (int i = 0; i < stores.size(); i++){
        Store store = stores.get(i);
        boolean matches = true;

            if (matches && searchString != "") {
                String searchPattern = createSearchRegex(searchString);
                Pattern pattern = Pattern.compile(".*?(?:(" + searchPattern + ").*?)");
                Matcher matcher = pattern.matcher(store.getStoreName().toLowerCase());

                matches = matcher.matches();
            }
            if (matches) {
                resultsStore.add(store);
            }
        }

        return resultsStore;
    }

    public List<Product> results() {
        List<Product> results = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            boolean matches = true;

            if (matches && searchString != "") {
                String searchPattern = createSearchRegex(searchString);
                Pattern pattern = Pattern.compile(".*?(?:(" + searchPattern + ").*?)");
                Matcher matcher = pattern.matcher(product.getName().toLowerCase());

                matches = matcher.matches();
            }

            if (matches) {
                results.add(product);
            }
        }

        return results;
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