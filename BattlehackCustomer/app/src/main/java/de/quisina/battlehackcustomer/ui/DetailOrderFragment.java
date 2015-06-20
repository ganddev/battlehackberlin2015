package de.quisina.battlehackcustomer.ui;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.quisina.battlehackcustomer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailOrderFragment extends Fragment {


    @InjectView(R.id.fab)
    FloatingActionButton mFab;

    public DetailOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_order, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void onFab(View V) {
        //TODO post code
    }
}
