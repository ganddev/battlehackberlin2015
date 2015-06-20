package de.quisina.battlehackcustomer.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.quisina.battlehackcustomer.R;

public class DetailOrderActivity extends AppCompatActivity {

    public static final String ORDER_ID = "orderid";

    @InjectView(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        ButterKnife.inject(this);

        setSupportActionBar(mToolBar);
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DetailOrderFragment detailOrderFragment = new DetailOrderFragment();
        Bundle args = new Bundle();
        args.putLong(ORDER_ID, getIntent().getLongExtra(ORDER_ID, 0));
        detailOrderFragment.setArguments(args);
        ft.replace(R.id.fragment_container, detailOrderFragment);
        ft.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
