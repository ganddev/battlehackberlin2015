package de.quisina.battlehackcustomer;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;

import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.models.Account;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class BattlehackCustomerApplication extends Application {


    private static final String TAG = BattlehackCustomerApplication.class.getSimpleName();
    private static Account sAccount = null;
    private static JobManager sJobManager;


    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this, false);

        sAccount = ManagerSqlDatabase.getAcount();
    }

    public static Account getAccount() {
        return sAccount;
    }

    public static JobManager getJobManager(Context ctx) {
        if (sJobManager == null) {
            Configuration configuration = new Configuration.Builder(ctx)
                    .minConsumerCount(2)
                    .maxConsumerCount(15) //up to # consumers at a time
                    .loadFactor(1) //# jobs per consumer
                    .consumerKeepAlive(3)
                    .build();
            sJobManager = new JobManager(ctx, configuration);
        }
        return sJobManager;
    }
}
