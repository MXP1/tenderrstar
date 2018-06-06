package xpmxp1.tenderstar.app_objects;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xpmxp1.tenderstar.Database;
import xpmxp1.tenderstar.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    private boolean isShoppingCart;

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

        public void setAddButtonInvisible() {
            List<Product> productList = Database.getInstance().getShoppingCartProducts();
            for (Product p : productList) {
                if (p.getId() == product.getId()) {
                    addShoppingCartButton.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        }
    }


    public ProductAdapter(List<Product> myDataset, boolean isShoppingCart) {
        this.isShoppingCart = isShoppingCart;
        productList = myDataset;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);

        ViewHolder vh = new ViewHolder(c, isShoppingCart, this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(productList.get(position).getName());
        holder.category.setText(Database.getInstance().getCategoryForProduct(productList.get(position).getCategoryId()));
        holder.description.setText(productList.get(position).getDescription().toString());
        holder.price.setText(productList.get(position).getPriceAsString());
        holder.product = productList.get(position);
        holder.setAddButtonInvisible();
    }

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