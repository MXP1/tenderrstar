package xpmxp1.tenderstar;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;

import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.StoreAdapter;

/**
 * Created by dominik on 18.04.18.
 */

public class Navigation {
    static private Navigation instance = null;

    private AppBaseActivity activity;
    private NavigationView navigation_view;
    private FragmentTransaction ft;

    static public Navigation getInstance() {
        if (instance == null)
            instance = new Navigation();
        return instance;
    }

    public void PrintTestMessage() {
        Log.d("Navigation", "Singleton");
    }

    public void setActivity(AppBaseActivity activity) {
        this.activity = activity;
    }

    public void setView(NavigationView navigation_view) {
        this.navigation_view = navigation_view;
    }

    public void navigateToHome() {
        navigation_view.setCheckedItem(R.id.nav_home);
        ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new HomeFragment());
        ft.commit();
    }

    public void navigateToStores() {
        navigation_view.setCheckedItem(R.id.nav_stores);
        ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new StoreFragment());
        ft.commit();
    }

    public void navigateToFavorites() {
        navigation_view.setCheckedItem(R.id.nav_favorites);
        ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new FavoritesFragment());
        ft.commit();
    }


    public void navigateToStoreDetail(Store store) {
        Log.d("Navigation", "navigate to store details");
        Log.d("Navigation", store.name);

        navigation_view.setCheckedItem(R.id.nav_home);
        ft = activity.getSupportFragmentManager().beginTransaction();
        StoreDetailsFragment st = new StoreDetailsFragment();
        st.setStore(store);
        ft.replace(R.id.mainFrame, st);
        ft.commit();
    }
}
