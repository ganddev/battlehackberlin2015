package de.quisina.battlehackcustomer.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.adapters.OrderAdapter;
import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListOrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOrdersFragment extends Fragment {

    private static final String CLOSED_ORDERS = "closedorders" ;

    @InjectView(R.id.lv_orders)
    ListView mOrdersLV;

    OrderAdapter mAdapter;

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

        boolean closedOrders = false;
        Bundle args = getArguments();
        if(args != null && args.containsKey(CLOSED_ORDERS)) {
            closedOrders = args.getBoolean(CLOSED_ORDERS, false);
        }

        if(closedOrders) {
            mAdapter = new OrderAdapter(getActivity(), ManagerSqlDatabase.getClosedOrders());
        } else {
            mAdapter = new OrderAdapter(getActivity(), ManagerSqlDatabase.getOpenOrders());
        }

        mOrdersLV.setAdapter(mAdapter);
        mOrdersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent detailActivity = new Intent(getActivity(), DetailOrderActivity.class);
                detailActivity.putExtra(DetailOrderActivity.ORDER_ID, mAdapter.getItemId(position));
                startActivity(detailActivity);
            }
        });
        return v;
    }


    @Override
    public void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }
}
