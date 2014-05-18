package org.clownqiang.BluetoothProject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.clownqiang.BluetoothProject.R;

/**
 * Created by clownqiang on 14-5-18.
 */
public class AboutFragment extends Fragment {


    private View parent_view;

    private FragmentActivity fragmentActivity;

    public static AboutFragment newInstance(int index) {
        AboutFragment aboutFragment = new AboutFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        aboutFragment.setArguments(args);

        return aboutFragment;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutfragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parent_view = getView();
        fragmentActivity = getActivity();
    }
}
