package com.levko.roma.levkohomework10.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.levko.roma.levkohomework10.AdapterRecycleView;
import com.levko.roma.levkohomework10.R;

import java.util.ArrayList;

/**
 * Created by User on 16.03.2016.
 */
public class ListFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycle_view, container, false);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.list_RV);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        AdapterRecycleView mAdapter = new AdapterRecycleView(getItems(), getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /** recycler view start animation - all visible items move */
        mRecyclerView.startLayoutAnimation();

        return v;

    }

    private ArrayList<String> getItems(){

        ArrayList<String> items = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            items.add("Item #" + i);
        return items;
    }

}
