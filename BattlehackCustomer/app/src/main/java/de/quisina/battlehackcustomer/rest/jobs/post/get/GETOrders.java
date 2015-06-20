package de.quisina.battlehackcustomer.rest.jobs.post.get;

import android.content.Context;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.List;

import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.models.Order;
import de.quisina.battlehackcustomer.rest.RestClient;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class GETOrders extends Job {


    private final RestClient mRestClient;

    public GETOrders(Context ctx) {
        super(new Params(1000).requireNetwork());
        mRestClient = new RestClient(ctx);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        if(BattlehackCustomerApplication.getAccount() != null && BattlehackCustomerApplication.getAccount().getAuthToken() != null){
            List<Order> orders = mRestClient.getApiService().getOrders();
            ManagerSqlDatabase.saveOrders(orders);
        }
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
