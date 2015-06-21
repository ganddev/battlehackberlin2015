package de.quisina.battlehackcustomer;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;

import java.util.Date;

import de.quisina.battlehackcustomer.database.ManagerSqlDatabase;
import de.quisina.battlehackcustomer.models.Account;
import de.quisina.battlehackcustomer.models.Meal;
import de.quisina.battlehackcustomer.models.Order;

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
        //setUpTestUser();
        setUpTestOrder();
        setUpTestMeals();
        setUpTestCusomter();
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

    private void setUpTestUser() {
        sAccount = new Account();
        sAccount.setId(1L);
        sAccount.setEmail("test@test.de");
        sAccount.setUserName("Testor");
        sAccount.setAuthToken("fasdfasdf");
        sAccount.setPassword("123456");
    }

    private void setUpTestCusomter() {
        Account testCustomer = new Account();
        testCustomer.setId(2L);
        testCustomer.setEmail("test@customer.de");
        testCustomer.setUserName("Test Customer");
        testCustomer.setRole("customer");
        testCustomer.save();
    }
    private void setUpTestMeals() {
        Meal testMeal = new Meal();
        testMeal.setId(1L);
        testMeal.setName("Pasta");
        testMeal.setPrice(3.59f);
        testMeal.save();
    }

    private void setUpTestOrder() {
        Order testOrder = new Order();
        testOrder.setId(2L);
        testOrder.setName("TEST ORDER");
        testOrder.setCreatedAt(new Date());
        testOrder.setStatus("paid");
        testOrder.setCustomerName("Test buyer");
        testOrder.setTransactionId(123134);
        testOrder.save();
    }
}
