package xpmxp1.tenderstar;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity
    extends
        AppBaseActivity
    implements
        HomeFragment.OnFragmentInteractionListener,
        StoreFragment.OnFragmentInteractionListener,
        FavoritesFragment.OnFragmentInteractionListener,
        StoreDetailsFragment.OnFragmentInteractionListener,
        ShoppingCartFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    private Navigation m_Navigation = Navigation.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        getSupportActionBar().setTitle(uri.toString());
    }

    public Navigation getNavigation()
    {
        return m_Navigation;
    }
}
