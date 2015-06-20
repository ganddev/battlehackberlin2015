package de.quisina.battlehackcustomer.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.models.Order;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class OrderAdapter extends ArrayAdapter<Order> {

    private Typeface tfMedium;

    private SimpleDateFormat mSdf;

    public OrderAdapter(Context context, List<Order> objects) {
        super(context, R.layout.list_item_order, objects);
        tfMedium = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
        mSdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderHolder holder;
        if (convertView != null) {
            holder = (OrderHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_order, null);
            holder = new OrderHolder(convertView);
            convertView.setTag(holder);
        }

        final Order order = getItem(position);
        //TODO style the shit!!!
        holder.mCircleLabel.setTypeface(tfMedium);
        holder.mCircleLabel.setText(order.getId().toString());
        holder.mHistoryLabel.setText(order.getName());
        holder.mHistoryTime.setText(mSdf.format(order.getCreatedAt()));
        return convertView;
    }

    public class OrderHolder {

        @InjectView(R.id.history_label_tv)
        TextView mHistoryLabel;

        @InjectView(R.id.history_time_tv)
        TextView mHistoryTime;

        @InjectView(R.id.circle_label_tv)
        TextView mCircleLabel;

        @InjectView(R.id.duration_tv)
        TextView mDurationTv;

        public OrderHolder(View v) {
            ButterKnife.inject(this, v);
        }
    }

}
