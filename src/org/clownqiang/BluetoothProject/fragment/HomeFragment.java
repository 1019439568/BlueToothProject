package org.clownqiang.BluetoothProject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.clownqiang.BluetoothProject.R;

/**
 * Created by clownqiang on 14-5-18.
 */
public class HomeFragment extends Fragment {


    private View parent_view;

    private FragmentActivity fragmentActivity;

    private Button button_one,button_two,button_three;

    private static final String TAG = "HomeFragment";

    public static HomeFragment newInstance(int index) {
        HomeFragment homeFragment = new HomeFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        homeFragment.setArguments(args);

        return homeFragment;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parent_view = getView();
        fragmentActivity = getActivity();

        button_one = (Button)parent_view.findViewById(R.id.button_one);
        button_two = (Button)parent_view.findViewById(R.id.button_two);
        button_three = (Button)parent_view.findViewById(R.id.button_three);

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"button one click");
            }
        });

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"button two click");
            }
        });

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"button three click");
            }
        });
    }
}
