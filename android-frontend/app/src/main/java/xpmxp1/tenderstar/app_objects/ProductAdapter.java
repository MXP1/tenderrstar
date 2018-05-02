package xpmxp1.tenderstar.app_objects;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xpmxp1.tenderstar.CustomApplication;
import xpmxp1.tenderstar.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public CardView mCardView;
        public TextView name;
        public TextView category;
        public TextView description;
        public TextView price;

        public ViewHolder(CardView c) {
            super(c);
            mCardView = c;
            name = (TextView) c.findViewById(R.id.textView_name);
            category = (TextView) c.findViewById(R.id.textView_category);
            description = (TextView) c.findViewById(R.id.textView_description);
            price = (TextView) c.findViewById(R.id.textView_price);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductAdapter(List<Product> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);

        //TextView v = c.findViewById(R.id.textView_name);

        ViewHolder vh = new ViewHolder(c);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String category = CustomApplication.getDb().productCategoryDAO().getCategoryForProduct(mDataset.get(position).getCategoryId());
        holder.name.setText(mDataset.get(position).getName());
        holder.category.setText(category);
        holder.description.setText(mDataset.get(position).getDescription().toString());
        holder.price.setText("" + mDataset.get(position).getPrice());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void clear() {
        mDataset.clear();
        notifyDataSetChanged();
    }

    public void setmDataset(List<Product> productList) {
        mDataset = productList;
        notifyDataSetChanged();
    }
}