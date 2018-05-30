package xpmxp1.tenderstar;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import xpmxp1.tenderstar.app_objects.Customer;

public class MainActivity
    extends
        AppBaseActivity
    implements
        HomeFragment.OnFragmentInteractionListener,
        StoreFragment.OnFragmentInteractionListener,
        FavoritesFragment.OnFragmentInteractionListener,
        StoreDetailsFragment.OnFragmentInteractionListener,
        ShoppingCartFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener,
        MapsFragment.OnFragmentInteractionListener {

    private Navigation m_Navigation = Navigation.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        View headerView = navigationView.getHeaderView(0);
        TextView userName = headerView.findViewById(R.id.nav_head_username);
        Customer customer = CustomApplication.getLoggedInCustomer();

        userName.setText(customer.getUsername());
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
