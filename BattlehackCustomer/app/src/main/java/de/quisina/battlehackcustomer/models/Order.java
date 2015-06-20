package de.quisina.battlehackcustomer.models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
@Table(name = "orders" , id = BaseColumns._ID)
public class Order extends Model {


    @Column(name = "customer")
    private Account customer;


    @Column(name = "meal")
    private Meal meal;

    @Column(name = "orderd_at")
    private Date orderedAt;

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    @Column(name = "closed")
    private boolean closed;

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Order() { super(); }
}
