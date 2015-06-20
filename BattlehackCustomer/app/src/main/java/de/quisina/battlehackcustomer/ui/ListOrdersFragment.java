package de.quisina.battlehackcustomer.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import de.quisina.battlehackcustomer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListOrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOrdersFragment extends Fragment {

    private static final String CLOSED_ORDERS = "closedorders" ;

    public static ListOrdersFragment newInstance(boolean b) {
        ListOrdersFragment fragment = new ListOrdersFragment();
        Bundle args = new Bundle();
        args.putBoolean(CLOSED_ORDERS, b);
        fragment.setArguments(args);
        return fragment;
    }

    public ListOrdersFragment() {
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
        View v  = inflater.inflate(R.layout.fragment_list_bookings, container, false);
        ButterKnife.inject(this, v);

        boolean closedOrders;
        Bundle args = getArguments();
        if(args != null && args.containsKey(CLOSED_ORDERS)) {
            closedOrders = args.getBoolean(CLOSED_ORDERS, false);
        }

        return v;
    }
}
