package de.quisina.battlehackcustomer.rest.wrappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import de.quisina.battlehackcustomer.models.Meal;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class MealWrapper {

    @SerializedName("state")
    private String state;

    @SerializedName("count")
    private int count;


    @SerializedName("result")
    private List<Meal> meals;

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

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}