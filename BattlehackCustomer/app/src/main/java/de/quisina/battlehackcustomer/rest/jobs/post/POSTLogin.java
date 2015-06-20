package de.quisina.battlehackcustomer.rest.jobs.post;

import android.content.Context;

import com.google.gson.JsonObject;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import de.quisina.battlehackcustomer.rest.RestClient;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class POSTLogin extends Job {

    private final RestClient mRestClient;
    private final JsonObject jsonObject;

    public POSTLogin(Context ctx, String username, String password) {
        super(new Params(1000).requireNetwork());
        mRestClient = new RestClient(ctx);
        jsonObject = new JsonObject();
        jsonObject.addProperty("username", username);
        jsonObject.addProperty("password", password);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        if(jsonObject != null) {
            mRestClient.getApiService().login(jsonObject);
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
