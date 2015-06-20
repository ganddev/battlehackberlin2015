package de.quisina.battlehackcustomer.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import de.quisina.battlehackcustomer.models.Order;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class OrderAdapter extends ArrayAdapter<Order> {
    public OrderAdapter(Context context, int resource) {
        super(context, resource);
    }
}
