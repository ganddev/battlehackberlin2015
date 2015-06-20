package de.quisina.battlehackcustomer.rest.jobs.post;

import android.content.Context;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.rest.RestClient;
import retrofit.client.Response;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class POSTOrderReceived extends Job {

    private final RestClient mRestClient;

    public POSTOrderReceived(Context ctx) {
        super(new Params(1000).requireNetwork());
        mRestClient = new RestClient(ctx);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        if(BattlehackCustomerApplication.getAccount() != null && BattlehackCustomerApplication.getAccount().getAuthToken() != null) {
            Response resp = mRestClient.getApiService().setOrderReceived();
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
