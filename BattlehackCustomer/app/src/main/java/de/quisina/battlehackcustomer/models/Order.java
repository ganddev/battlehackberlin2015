package de.quisina.battlehackcustomer.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class Order extends Model {


    @Column(name = "customer")
    private Account customer;


    @Column(name = "meal")
    private Meal meal;

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
