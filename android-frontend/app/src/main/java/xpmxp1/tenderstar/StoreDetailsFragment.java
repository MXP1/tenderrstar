package xpmxp1.tenderstar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import xpmxp1.tenderstar.app_objects.Store;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StoreDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StoreDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreDetailsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private Store store;

    public StoreDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_details, container, false);
        ((TextView) view.findViewById(R.id.textView_search)).setText(store.getStoreName());
        //TODO: Store Address Query
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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

    public void setStore(Store store) {
        this.store = store;
    }
}
