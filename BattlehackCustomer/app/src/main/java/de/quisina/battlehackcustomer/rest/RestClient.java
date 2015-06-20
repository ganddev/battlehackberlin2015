package de.quisina.battlehackcustomer.rest;

import android.content.Context;

import com.google.gson.GsonBuilder;

import de.quisina.battlehackcustomer.models.Account;
import de.quisina.battlehackcustomer.rest.service.ApiService;
import de.quisina.battlehackcustomer.rest.service.RequestInterceptor;
import de.quisina.battlehackcustomer.utils.Const;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class RestClient {

    private ApiService mApiService;

    public RestClient(Context ctx) {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Account.class, new Account());
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Const.BASE_URL)
                .setConverter(new GsonConverter(gson.create()))
                .setRequestInterceptor(new RequestInterceptor())
                .build();

        mApiService = restAdapter.create(ApiService.class);


    }

    public ApiService getApiService() { return mApiService; }



}
