package de.quisina.battlehackcustomer.rest.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import de.quisina.battlehackcustomer.models.Order;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class OrderWrapper {

    @SerializedName("state")
    private String state;

    @SerializedName("count")
    private int count;

    @SerializedName("result")
    private List<Order> orders;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
