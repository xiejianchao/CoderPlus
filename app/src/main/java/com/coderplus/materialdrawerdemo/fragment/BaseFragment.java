package com.coderplus.materialdrawerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by xiejianchao on 15/10/20.
 */
public class BaseFragment extends Fragment {

    protected Context context;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.context = getActivity();
    }
}
