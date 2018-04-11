package xpmxp1.tenderstar;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;

/**
 * Created by tomazm on 11.04.18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    private Context pContext;
    private List<Product> productsList = new ArrayList<>();

    public ProductAdapter(@NonNull Context context, @LayoutRes ArrayList<Product> list){
        super (context, 0,list );
        pContext = context;
        productsList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(pContext).inflate(R.layout.content_home,parent, false);

        Product currentProduct = productsList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentProduct.name);

        TextView category = (TextView) listItem.findViewById(R.id.textView_category);
        category.setText(currentProduct.category.toString());

        return listItem;

    }

}
