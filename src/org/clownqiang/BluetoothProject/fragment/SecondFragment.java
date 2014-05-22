package org.clownqiang.BluetoothProject.fragment;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import org.clownqiang.BluetoothProject.MyApp;
import org.clownqiang.BluetoothProject.R;
import org.clownqiang.BluetoothProject.util.BlueToothUtil;

/**
 * Created by clownqiang on 14-5-18.
 */
public class SecondFragment extends Fragment {


    private View parent_view;

    private FragmentActivity fragmentActivity;

    private SeekBar seekBar;

    private Button button_four,button_five,button_six;

    private static final String TAG = "Second_Fragment";

    private BlueToothUtil blueToothUtil;

    private boolean IsBlueTooth = false;

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
        button_four = (Button)parent_view.findViewById(R.id.button_four);
        button_five = (Button)parent_view.findViewById(R.id.button_five);
        button_six = (Button)parent_view.findViewById(R.id.button_six);

        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsBlueTooth == true) {
                    blueToothUtil.WriteData(104);
                } else {
                    Toast.makeText(fragmentActivity, "No Service", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsBlueTooth == true) {
                    blueToothUtil.WriteData(105);
                } else {
                    Toast.makeText(fragmentActivity, "No Service", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsBlueTooth == true) {
                    blueToothUtil.WriteData(106);
                } else {
                    Toast.makeText(fragmentActivity, "No Service", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG,progress+"");
                if (IsBlueTooth == true) {
                    blueToothUtil.WriteData(seekBar.getProgress());
                }
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

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"on Resume");
        MyApp myApp = (MyApp)fragmentActivity.getApplication();
        BluetoothSocket bluetoothSocket = myApp.getBluetoothSocket();
        blueToothUtil = new BlueToothUtil(fragmentActivity,bluetoothSocket);
        if (blueToothUtil.IsBlueToothOpen()){
            IsBlueTooth = true;
        }else {
            Toast.makeText(getActivity(),"打开蓝牙并重新打开应用",Toast.LENGTH_SHORT).show();
        }
    }
}
