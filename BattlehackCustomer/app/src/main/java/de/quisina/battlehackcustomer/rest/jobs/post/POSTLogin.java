package de.quisina.battlehackcustomer.rest.jobs.post;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import de.greenrobot.event.EventBus;
import de.quisina.battlehackcustomer.events.LoginEvent;
import de.quisina.battlehackcustomer.models.Account;
import de.quisina.battlehackcustomer.rest.RestClient;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class POSTLogin extends Job {

    private static final String TAG = POSTLogin.class.getSimpleName();
    private final RestClient mRestClient;
    private final JsonObject jsonObject;

    public POSTLogin(Context ctx, String username, String password) {
        super(new Params(1000).requireNetwork());
        mRestClient = new RestClient(ctx);
        jsonObject = new JsonObject();
        jsonObject.addProperty("email", username);
        jsonObject.addProperty("password", password);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        if(jsonObject != null) {
            Account account = mRestClient.getApiService().login(jsonObject);
            account.save();
            Log.d(TAG, "account: " + account.toString());
            EventBus.getDefault().post(new LoginEvent(true));
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
