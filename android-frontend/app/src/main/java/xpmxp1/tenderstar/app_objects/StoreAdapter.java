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
import xpmxp1.tenderstar.Navigation;
import xpmxp1.tenderstar.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private List<Store> storeList;
    private boolean isFavoriteMenu;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            c.setOnClickListener(this);

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
            List<Store> storeList = Database.getInstance().GetFavorites();
            for (Store s : storeList) {
                if (s.getId() == store.getId()) {
                    favoriteBtn.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        }

        @Override
        public void onClick(View view) {
            Navigation.getInstance().navigateToStoreDetail(store);
        }
    }

    public StoreAdapter(List<Store> myDataset, boolean isFavoriteMenu) {
        storeList = myDataset;
        this.isFavoriteMenu = isFavoriteMenu;
    }

    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView c = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_card, parent, false);

        ViewHolder vh = new ViewHolder(c, isFavoriteMenu, this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(storeList.get(position).getStoreName());
        holder.address.setText(storeList.get(position).getAddress());
        holder.store = storeList.get(position);
        holder.setAddButtonInvisible();
    }

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