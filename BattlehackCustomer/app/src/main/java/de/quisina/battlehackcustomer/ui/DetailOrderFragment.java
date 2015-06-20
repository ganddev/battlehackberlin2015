package de.quisina.battlehackcustomer.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doomonafireball.betterpickers.numberpicker.NumberPickerBuilder;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.melnykov.fab.FloatingActionButton;

import java.text.SimpleDateFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.models.Order;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailOrderFragment extends Fragment implements NumberPickerDialogFragment.NumberPickerDialogHandler  {


    private static final String TAG = DetailOrderFragment.class.getSimpleName();
    @InjectView(R.id.fab)
    FloatingActionButton mFab;

    @InjectView(R.id.tv_meal_name)
    TextView mMealName;

    @InjectView(R.id.tv_customer_name)
    TextView mCustomerName;

    @InjectView(R.id.tv_date)
    TextView mOrderDate;

    @InjectView(R.id.tv_receipe)
    TextView mReceipe;


    public DetailOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_order, container, false);
        ButterKnife.inject(this, v);

        Bundle args = getArguments();
        Order order = null;
        if(args != null && args.containsKey(DetailOrderActivity.ORDER_ID)) {
             order = ManagerSqlDatabase.getOrderById(args.getLong(DetailOrderActivity.ORDER_ID));
        }
        if(order != null) {
            mMealName.setText(order.getName());
            mCustomerName.setText(order.getCustomerName());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
            mOrderDate.setText(sdf.format(order.getCreatedAt()));

        }
        return v;
    }

    @Override
    public void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void onFab(View V) {
        NumberPickerBuilder npb = new NumberPickerBuilder()
                .setFragmentManager(getFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment)
                .setPlusMinusVisibility(View.INVISIBLE)
                .setDecimalVisibility(View.INVISIBLE)
                .setTargetFragment(DetailOrderFragment.this);
        npb.show();
    }

    @Override
    public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
        Log.d(TAG, "{ reference : " + reference + ", number: " + number + ", decimal : " + decimal + ", isNegative: " + isNegative + ", fullNumber: " + fullNumber + "}");
    }
}
