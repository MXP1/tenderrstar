package xpmxp1.tenderstar;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

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
}
