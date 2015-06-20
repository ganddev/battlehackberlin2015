package de.quisina.battlehackcustomer.rest.service;

import com.google.gson.JsonObject;

import java.util.List;

import de.quisina.battlehackcustomer.models.Order;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public interface ApiService {


    @POST("/login")
    String login(@Body JsonObject object);


    @GET("/orders")
    List<Order> getOrders();


}
