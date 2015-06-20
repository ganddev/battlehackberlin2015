package de.quisina.battlehackcustomer;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.models.Account;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class BattlehackCustomerApplication extends Application {


    private static final String TAG = BattlehackCustomerApplication.class.getSimpleName();
    private static Account sAccount = null;



    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this, false);

        sAccount = ManagerSqlDatabase.getAcount();
    }

    public static Account getAccount() {
        return sAccount;
    }
}
