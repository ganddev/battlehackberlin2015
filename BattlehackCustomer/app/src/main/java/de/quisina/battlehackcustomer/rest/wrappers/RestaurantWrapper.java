package de.quisina.battlehackcustomer.rest.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import de.quisina.battlehackcustomer.models.Restaurant;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class RestaurantWrapper {

    @SerializedName("state")
    private String state;

    @SerializedName("count")
    private int count;


    @SerializedName("result")
    private List<Restaurant> restaurants;


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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
