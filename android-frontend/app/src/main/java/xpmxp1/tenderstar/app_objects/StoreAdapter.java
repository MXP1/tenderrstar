package xpmxp1.tenderstar.app_objects;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xpmxp1.tenderstar.R;

/**
 * Created by baran on 25.04.2018.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private List<Store> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView name;
        public TextView category;

        public ViewHolder(CardView c) {
            super(c);
            mCardView = c;
            name = (TextView) c.findViewById(R.id.textView_name);
            category = (TextView) c.findViewById(R.id.textView_category);
        }
    }

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

        StoreAdapter.ViewHolder vh = new StoreAdapter.ViewHolder(c);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(mDataset.get(position).name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
