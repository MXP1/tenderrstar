package xpmxp1.tenderstar.app_objects;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import java.util.List;

import xpmxp1.tenderstar.Database;
import xpmxp1.tenderstar.Navigation;
import xpmxp1.tenderstar.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private List<Store> storeList;
    private boolean isFavoriteMenu;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public CardView mCardView;
        public TextView name;
        public TextView address;
        public Store store;

        public FloatingActionButton favoriteBtn;
        public FloatingActionButton removeFavoriteBtn;

        private StoreAdapter storeAdapter;

        public ViewHolder(CardView c, boolean isFavoriteMenu, final StoreAdapter storeAdapter) {
            super(c);
            this.storeAdapter = storeAdapter;

            mCardView = c;
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.getInstance().navigateToStoreDetail(store);
                }
            });

            name = (TextView) c.findViewById(R.id.textView_search);
            address = (TextView) c.findViewById(R.id.textView_address);
            favoriteBtn = (FloatingActionButton) c.findViewById(R.id.favoriteBtn);
            removeFavoriteBtn = (FloatingActionButton) c.findViewById(R.id.removeFavoriteBtn);

            if(isFavoriteMenu)
            {
                removeFavoriteBtn.setVisibility(View.INVISIBLE);
            }
            else
            {
                favoriteBtn.setVisibility(View.INVISIBLE);
            }

            favoriteBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    favoriteBtn.setBackgroundColor(6);
                    Database.getInstance().AddFavorite(store);
                    favoriteBtn.setVisibility(View.INVISIBLE);
                }
            });

            removeFavoriteBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    favoriteBtn.setBackgroundColor(6);
                    Database.getInstance().RemoveFavorite(store);

                    storeAdapter.setStoreList(Database.getInstance().GetFavorites());
                }
            });
        }

        public void setAddButtonInvisible() {
            // make add button invisible if they are in the favorites list
            List<Store> storeList = Database.getInstance().GetFavorites();
            for (Store s : storeList) {
                if (s.getId() == store.getId()) {
                    favoriteBtn.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StoreAdapter(List<Store> myDataset, boolean isFavoriteMenu) {
        storeList = myDataset;
        this.isFavoriteMenu = isFavoriteMenu;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_card, parent, false);

        ViewHolder vh = new ViewHolder(c, isFavoriteMenu, this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(storeList.get(position).getStoreName());
        holder.address.setText(storeList.get(position).getAddress());
        holder.store = storeList.get(position);
        holder.setAddButtonInvisible();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
        notifyDataSetChanged();
    }
    public void clear() {
        storeList.clear();
        notifyDataSetChanged();
    }
}