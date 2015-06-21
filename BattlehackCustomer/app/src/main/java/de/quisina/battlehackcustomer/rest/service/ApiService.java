package de.quisina.battlehackcustomer.rest.service;

import com.google.gson.JsonObject;

import de.quisina.battlehackcustomer.models.Account;
import de.quisina.battlehackcustomer.rest.wrappers.MealWrapper;
import de.quisina.battlehackcustomer.rest.wrappers.OrderWrapper;
import de.quisina.battlehackcustomer.rest.wrappers.RestaurantWrapper;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public interface ApiService {

    @POST("/users/login")
    Account login(@Body JsonObject object);

    @POST("/order/received")
    Response setOrderReceived();

    @GET("/restaurants/{id}/orders")
    OrderWrapper getOrders(@Path("id") long restaurantId);

    @GET("/restaurants/{id}/meals")
    MealWrapper getMeals(@Path("id") long restaurantId);

    @GET("/restaurants")
    RestaurantWrapper getRestaurants();
}
