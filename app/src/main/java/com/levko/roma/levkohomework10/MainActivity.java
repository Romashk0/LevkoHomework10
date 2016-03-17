package com.levko.roma.levkohomework10;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.levko.roma.levkohomework10.fragments.BallFragment;
import com.levko.roma.levkohomework10.fragments.HeartFragment;
import com.levko.roma.levkohomework10.fragments.ListFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()) {
            case R.id.ball_M:
                BallFragment ballFragment = new BallFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container_AM, ballFragment)
                        .commit();
                break;
            case R.id.list_M:
                ListFragment listFragment = new ListFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container_AM, listFragment)
                        .commit();
                break;
            case R.id.heart_M:
                HeartFragment heartFragment = new HeartFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_container_AM, heartFragment)
                        .commit();
                break;
        }
        return true;
    }
}