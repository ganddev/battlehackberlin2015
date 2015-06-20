package de.quisina.battlehackcustomer.rest.service;

import de.quisina.battlehackcustomer.BattlehackCustomerApplication;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class RequestInterceptor implements retrofit.RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        if(BattlehackCustomerApplication.getAccount() != null && BattlehackCustomerApplication.getAccount().getAuthToken() != null && !BattlehackCustomerApplication.getAccount().getAuthToken().isEmpty()) {
            request.addHeader("Authorization", BattlehackCustomerApplication.getAccount().getAuthToken());
        }
    }
}
