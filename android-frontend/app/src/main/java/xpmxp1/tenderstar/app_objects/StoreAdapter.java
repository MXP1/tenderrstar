package xpmxp1.tenderstar.app_objects;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xpmxp1.tenderstar.Navigation;
import xpmxp1.tenderstar.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private List<Store> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public CardView mCardView;
        public TextView name;
        public TextView address;
        public Store store;

        public ViewHolder(CardView c) {
            super(c);

            mCardView = c;

            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.getInstance().navigateToStoreDetail(store);
                }
            });

            name = (TextView) c.findViewById(R.id.textView_name);
            address = (TextView) c.findViewById(R.id.textView_address);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StoreAdapter(List<Store> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_card, parent, false);

        //TextView v = c.findViewById(R.id.textView_name);

        ViewHolder vh = new ViewHolder(c);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(mDataset.get(position).name);
        holder.address.setText(mDataset.get(position).address);
        holder.store = mDataset.get(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
