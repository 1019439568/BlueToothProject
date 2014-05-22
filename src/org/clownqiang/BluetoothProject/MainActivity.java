package org.clownqiang.BluetoothProject;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import org.clownqiang.BluetoothProject.util.BlueToothUtil;
import org.clownqiang.BluetoothProject.widget.FragmentIndicator;

public class MainActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */

    private static Fragment[] fragments;

    private static final String TAG = "MAIN_ACTIVITY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        setFragmentIndicator(0);
    }

    private void setFragmentIndicator(int whichIsDefault) {
        fragments = new android.support.v4.app.Fragment[3];
        fragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_home);
        fragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_second);
        fragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_about);
        getSupportFragmentManager().beginTransaction().hide(fragments[0])
                .hide(fragments[1]).hide(fragments[2]).show(fragments[whichIsDefault]).commit();

        FragmentIndicator mIndicator = (FragmentIndicator) findViewById(R.id.indicator);
        FragmentIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new FragmentIndicator.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                getSupportFragmentManager().beginTransaction()
                        .hide(fragments[0]).hide(fragments[1])
                        .hide(fragments[2]).show(fragments[which]).commit();
            }
        });
    }

}
