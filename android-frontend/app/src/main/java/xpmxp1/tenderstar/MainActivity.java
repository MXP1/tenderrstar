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
        NavigationView.OnNavigationItemSelectedListener,
        FavoritesFragment.OnFragmentInteractionListener{

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
}
