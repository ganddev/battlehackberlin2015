package de.quisina.battlehackcustomer.rest.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import de.quisina.battlehackcustomer.models.Account;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class CustomerWrapper {

    @SerializedName("state")
    private String state;

    @SerializedName("count")
    private int count;


    @SerializedName("result")
    private List<Account> customers;


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

    public void setCustomers(List<Account> customers) {
        this.customers = customers;
    }



    public List<Account> getCustomers () { return  customers; }
}
