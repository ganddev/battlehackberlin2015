package de.quisina.battlehackcustomer.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.path.android.jobqueue.JobManager;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.adapters.OrderAdapter;
import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.events.OrdersLoaded;
import de.quisina.battlehackcustomer.events.RestaurantsLoaded;
import de.quisina.battlehackcustomer.rest.jobs.post.get.GETOrders;
import de.quisina.battlehackcustomer.rest.jobs.post.get.GETRestaurants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListOrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOrdersFragment extends Fragment {

    private static final String CLOSED_ORDERS = "closedorders" ;
    private static final String TAG = ListOrdersFragment.class.getSimpleName();

    @InjectView(R.id.lv_orders)
    ListView mOrdersLV;

    OrderAdapter mAdapter;
    private JobManager jm;
    private LoadToast mLt;

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
        jm = BattlehackCustomerApplication.getJobManager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_list_bookings, container, false);
        ButterKnife.inject(this, v);

        mLt = new LoadToast(getActivity());

        boolean closedOrders = false;
        Bundle args = getArguments();
        if(args != null && args.containsKey(CLOSED_ORDERS)) {
            closedOrders = args.getBoolean(CLOSED_ORDERS, false);
        }
        mAdapter = new OrderAdapter(getActivity(), ManagerSqlDatabase.getOpenOrders());


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
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        loadRestaurants();
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    private void loadRestaurants() {
        GETRestaurants restaurants = new GETRestaurants(getActivity());
        jm.addJobInBackground(restaurants);
    }

    private void loadOrders() {
        mLt.setText("Load orders");
        mLt.show();
        GETOrders orders = new GETOrders(getActivity());
        jm.addJobInBackground(orders);
    }

    @Override
    public void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }

    public void onEventMainThread(RestaurantsLoaded event) {
        Log.d(TAG, "got event");
        loadOrders();
    }

    public void onEventMainThread(OrdersLoaded event) {
        mLt.success();
    }
}
