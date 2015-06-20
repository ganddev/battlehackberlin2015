package de.quisina.battlehackcustomer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.path.android.jobqueue.JobManager;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.quisina.battlehackcustomer.BattlehackCustomerApplication;
import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.events.LoginEvent;
import de.quisina.battlehackcustomer.rest.jobs.post.POSTLogin;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @InjectView(R.id.editText_username)
    EditText mUsername;
    @InjectView(R.id.editText_password)
    EditText mPassword;
    private LoadToast mLt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_login)
    public void onLogin(View v) {
        if(mUsername != null && mPassword != null) {
            POSTLogin postLoginJob = new POSTLogin(this, mUsername.getText().toString(), mPassword.getText().toString());
            mLt = new LoadToast(this);
            mLt.setText("Verbinde...");
            mLt.show();
            JobManager jm = BattlehackCustomerApplication.getJobManager(this);
            jm.addJob(postLoginJob);
        }
    }

    @Override
    protected void onDestroy() {
        // Unregister
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(LoginEvent event) {
        Log.d(TAG, "got event");
        if(event.isSucceed() && mLt != null) {
            mLt.success();
        } else {
            mLt.error();
        }
    }
}
