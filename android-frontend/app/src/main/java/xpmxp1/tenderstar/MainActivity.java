package xpmxp1.tenderstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import xpmxp1.tenderstar.app_objects.Product;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView = (ListView) findViewById(R.id.products_list);
        ArrayList<Product> productsList = new ArrayList<>();

        productsList.add(new Product("Milk", Product.Category.FOOD));
        productsList.add(new Product("Beer", Product.Category.ALCOHOL));

        productAdapter = new ProductAdapter(this, productsList);
        listView.setAdapter(productAdapter);
    }
}
