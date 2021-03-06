package xpmxp1.tenderstar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xpmxp1.tenderstar.app_objects.Store;


public class StoreDetailsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private Store store;

    public StoreDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_store_details, container, false);
        ((TextView) view.findViewById(R.id.textView_search)).setText(store.getStoreName());

        ((TextView) view.findViewById(R.id.textView_address)).setText(store.getAddress());
        ((TextView) view.findViewById(R.id.textView_hours)).setText(store.getOpeningHours().toString());
        ((TextView) view.findViewById(R.id.textView_link)).setText(store.getLink());

        final FloatingActionButton buttonNavigate = view.findViewById(R.id.button_navigate);

        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.getInstance().navigateToMap(store);
            }
        });
        return view;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
