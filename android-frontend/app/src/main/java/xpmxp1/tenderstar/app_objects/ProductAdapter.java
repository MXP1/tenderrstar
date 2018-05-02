package xpmxp1.tenderstar.app_objects;

import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import xpmxp1.tenderstar.Database;
import xpmxp1.tenderstar.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    private boolean isShoppingCart;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        private Product product;
        private ProductAdapter productAdapter;

        public CardView mCardView;
        public TextView name;
        public TextView category;
        public TextView description;
        public TextView price;

        public FloatingActionButton addShoppingCartButton;
        public FloatingActionButton removeShoppingCartButton;

        public ViewHolder(CardView c, boolean isShoppingCart, final ProductAdapter productAdapter) {
            super(c);

            this.productAdapter = productAdapter;
            mCardView = c;
            name = (TextView) c.findViewById(R.id.textView_name);
            category = (TextView) c.findViewById(R.id.textView_category);
            description = (TextView) c.findViewById(R.id.textView_description);
            price = (TextView) c.findViewById(R.id.textView_price);

            addShoppingCartButton = (FloatingActionButton) c.findViewById(R.id.button_add_shopping_cart);
            removeShoppingCartButton = (FloatingActionButton) c.findViewById(R.id.button_remove_shopping_cart);

            if (isShoppingCart) {
                addShoppingCartButton.setVisibility(View.INVISIBLE);
            }
            else {
                removeShoppingCartButton.setVisibility(View.INVISIBLE);
            }

            addShoppingCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.getInstance().addShoppingCart(product);
                    addShoppingCartButton.setVisibility(View.INVISIBLE);
                }
            });

            removeShoppingCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.getInstance().removeShoppingCart(product);
                    productAdapter.setProductList(Database.getInstance().getShoppingCartProducts());
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductAdapter(List<Product> myDataset, boolean isShoppingCart) {
        this.isShoppingCart = isShoppingCart;
        productList = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);

        //TextView v = c.findViewById(R.id.textView_name);

        ViewHolder vh = new ViewHolder(c, isShoppingCart, this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(productList.get(position).name);
        holder.category.setText(productList.get(position).category.toString());
        holder.description.setText(productList.get(position).description.toString());
        holder.price.setText(productList.get(position).getPriceAsString());
        holder.product = productList.get(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void clear() {
        productList.clear();
        notifyDataSetChanged();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }
}