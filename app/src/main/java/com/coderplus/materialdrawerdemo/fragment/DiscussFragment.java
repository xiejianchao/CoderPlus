

package com.coderplus.materialdrawerdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.utils.Logger;


/**
 * 讨论Fragment
 */
public class DiscussFragment extends BaseFragment {

    private static final String TAG = DiscussFragment.class.getSimpleName();

    private View tab3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        Logger.v(TAG, "DatingFragment onCreateView");

        tab3 = inflater.inflate(R.layout.fragment_dating, container, false);


        return tab3;


    }


}
