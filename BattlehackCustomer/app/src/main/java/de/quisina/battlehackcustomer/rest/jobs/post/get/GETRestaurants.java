package de.quisina.battlehackcustomer.rest.jobs.post.get;

import android.content.Context;
import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import de.greenrobot.event.EventBus;
import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.events.RestaurantsLoaded;
import de.quisina.battlehackcustomer.rest.RestClient;
import de.quisina.battlehackcustomer.rest.wrappers.RestaurantWrapper;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class GETRestaurants extends Job {

    private static final String TAG = GETRestaurants.class.getSimpleName();
    private final RestClient mRestClient;

    public GETRestaurants(Context ctx) {
        super(new Params(1000).requireNetwork());
        mRestClient = new RestClient(ctx);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        Log.d(TAG, "run");
        if(BattlehackCustomerApplication.getAccount() != null && BattlehackCustomerApplication.getAccount().getAuthToken() != null) {
            RestaurantWrapper wrapper = mRestClient.getApiService().getRestaurants();
            ManagerSqlDatabase.saveRestaurants(wrapper.getRestaurants());
            EventBus.getDefault().post(new RestaurantsLoaded());
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
