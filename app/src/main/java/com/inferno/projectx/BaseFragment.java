package com.inferno.projectx;


import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class BaseFragment extends Fragment implements ActivityCallback,FragmentCallback{

    ActivityCallback activityCallback;
    FragmentCallback fragmentCallback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityCallback = (ActivityCallback)context;
        fragmentCallback = (FragmentCallback)context;
    }

    @Override
    public void startActivity() {
        activityCallback.startActivity();
    }

    @Override
    public void startFrgament() {
        fragmentCallback.startFrgament();
    }
}
