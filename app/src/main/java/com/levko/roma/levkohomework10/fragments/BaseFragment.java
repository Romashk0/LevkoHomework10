package com.levko.roma.levkohomework10.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.levko.roma.levkohomework10.MainActivity;

/**
 * Created by User on 17.03.2016.
 */
public class BaseFragment extends Fragment {
    protected MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
}
