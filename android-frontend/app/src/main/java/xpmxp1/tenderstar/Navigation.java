package xpmxp1.tenderstar;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import xpmxp1.tenderstar.app_objects.Store;

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

    public void setActivity(AppBaseActivity activity) {
        this.activity = activity;
    }

    public void setView(NavigationView navigation_view) {
        this.navigation_view = navigation_view;
    }

    public void navigateToHome() {
        navigation_view.setCheckedItem(R.id.nav_home);
        showFragment(new HomeFragment());
    }

    public void navigateToHomeWithoutBackStack() {
        navigation_view.setCheckedItem(R.id.nav_home);
        ft = activity.getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.mainFrame, new HomeFragment());
        ft.commit();
    }

    public void navigateToStores() {
        navigation_view.setCheckedItem(R.id.nav_stores);
        showFragment(new StoreFragment());
    }

    public void navigateToFavorites() {
        navigation_view.setCheckedItem(R.id.nav_favorites);
        showFragment(new FavoritesFragment());
    }

    public void navigateToShoppingCart() {
        navigation_view.setCheckedItem(R.id.nav_shopping_cart);
        showFragment(new ShoppingCartFragment());
    }

    public void navigateToStoreDetail(Store store) {
        navigation_view.setCheckedItem(R.id.nav_home);

        StoreDetailsFragment st = new StoreDetailsFragment();
        st.setStore(store);
        showFragment(st);
    }

    public void navigateToMap() {
        navigation_view.setCheckedItem(R.id.nav_map);

        MapsFragment f = new MapsFragment();
        f.setStoreList(Database.getInstance().getStores());
        showFragment(f);
    }

    public void navigateToMap(Store store) {
        navigation_view.setCheckedItem(R.id.nav_map);

        MapsFragment f = new MapsFragment();
        f.activateNavigation(store);
        showFragment(f);
    }

    private void showFragment(Fragment fragment)
    {
        ft = activity.getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.mainFrame, fragment).addToBackStack( fragment.getTag() );
        ft.commit();
    }
}
