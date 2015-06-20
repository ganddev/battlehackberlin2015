package de.quisina.battlehackcustomer.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import de.quisina.battlehackcustomer.R;
import de.quisina.battlehackcustomer.ui.ListOrdersFragment;

/**
 * Created by bjornahlfeld on 20.06.15.
 */
public class MainPageAdapter extends FragmentStatePagerAdapter {


    private static final int[] PAGE_TITLES = {R.string.open_orders, R.string.closed_orders};
    private final Context mCtx;

    public MainPageAdapter(FragmentManager fm, Context ctx) {
        super(fm);
        mCtx = ctx;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ListOrdersFragment.newInstance(false);
            case 1:
                return ListOrdersFragment.newInstance(true);
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCtx.getString(PAGE_TITLES[position]);
    }


    @Override
    public int getCount() {
        return PAGE_TITLES.length;
    }
}
