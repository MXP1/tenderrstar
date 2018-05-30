package xpmxp1.tenderstar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductAdapter;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.StoreAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private ListView listView;
    private ProductAdapter productAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerViewProduct;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mLayoutManagerProduct;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapterProduct;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onFragmentInteraction(Uri.parse("Home"));
        }

        // Create List view
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final Button buttonSearch = view.findViewById(R.id.button_search);
        final Button buttonReset = view.findViewById(R.id.button_reset);
        final EditText search = view.findViewById(R.id.editText_search);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ProductAdapter)mRecyclerViewProduct.getAdapter()).clear();
                String search_string_product = search.getText().toString();
                Filter filter_products = new Filter(Database.getInstance().getProducts());
                filter_products.setSearchString(search_string_product);
                List<Product> productList = filter_products.results();
                ((ProductAdapter)mRecyclerViewProduct.getAdapter()).setProductList(productList);


                ((StoreAdapter)mRecyclerView.getAdapter()).clear();
                String search_string_store = search.getText().toString();
                Filter filter_stores = new Filter(Database.getInstance().getStores(), 1);
                filter_stores.setSearchString(search_string_store);
                List<Store> storeList = filter_stores.resultsStore();
                ((StoreAdapter)mRecyclerView.getAdapter()).setStoreList(storeList);
                mRecyclerView.setVisibility(View.VISIBLE);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.getText().clear();
                ((StoreAdapter)mRecyclerView.getAdapter()).setStoreList(Database.getInstance().getStores());
                ((ProductAdapter)mRecyclerViewProduct.getAdapter()).setProductList(Database.getInstance().getProducts());
                mRecyclerView.setVisibility(View.INVISIBLE);
            }
        });

        mRecyclerView = (RecyclerView) view.findViewById(R.id.stores_list);

        mRecyclerViewProduct = (RecyclerView) view.findViewById(R.id.products_list);



        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerViewProduct.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManagerProduct = new LinearLayoutManager(this.getActivity());
        mRecyclerViewProduct.setLayoutManager(mLayoutManagerProduct);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new StoreAdapter(Database.getInstance().getStores(), false);
        mAdapterProduct = new ProductAdapter(Database.getInstance().getProducts(), false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerViewProduct.setAdapter(mAdapterProduct);

        // return the View
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
