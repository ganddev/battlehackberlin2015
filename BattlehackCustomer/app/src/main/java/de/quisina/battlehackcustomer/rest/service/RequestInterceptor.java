package de.quisina.battlehackcustomer.rest.service;

import java.util.UUID;

import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.BuildConfig;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class RequestInterceptor implements retrofit.RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("request_id", String.valueOf(UUID.randomUUID()));
        request.addQueryParam("app_version", BuildConfig.VERSION_NAME);
        request.addQueryParam("os", "android");
        if(BattlehackCustomerApplication.getAccount() != null && BattlehackCustomerApplication.getAccount().getAuthToken() != null && !BattlehackCustomerApplication.getAccount().getAuthToken().isEmpty()) {
            request.addHeader("auth-token", BattlehackCustomerApplication.getAccount().getAuthToken());
        }
    }
}
