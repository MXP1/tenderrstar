package xpmxp1.tenderstar;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductAdapter;

/**
 * Created by baran on 18.04.2018.
 */

public class FavoritesFragment extends Fragment {

    public String name;
    public List<Product> favorites;

    private HomeFragment.OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Home"));
        }

        // Create List view
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        view.setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.products_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        
        mRecyclerView.setAdapter(mAdapter);

        // return the View
        return view;
    }
}
