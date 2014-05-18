package org.clownqiang.BluetoothProject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import org.clownqiang.BluetoothProject.R;

/**
 * Created by clownqiang on 14-5-18.
 */
public class SecondFragment extends Fragment {


    private View parent_view;

    private FragmentActivity fragmentActivity;

    private SeekBar seekBar;

    private static final String TAG = "Second_Fragment";

    public static SecondFragment newInstance(int index) {
        SecondFragment secondFragment = new SecondFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        secondFragment.setArguments(args);

        return secondFragment;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondfragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parent_view = getView();
        fragmentActivity = getActivity();

        seekBar =(SeekBar)parent_view.findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG,progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG,seekBar.getProgress()+"");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG,seekBar.getProgress()+"");
            }
        });
    }
}
