
package com.coderplus.materialdrawerdemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.adapter.TalentAdapter;
import com.coderplus.materialdrawerdemo.model.CoderModel;
import com.coderplus.materialdrawerdemo.utils.Logger;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


/**
 * @author xiejianchao
 * 人才Fragment
 */
public class TalentFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = TalentFragment.class.getSimpleName();

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    private LinearLayoutManager mLayoutManager;
    private TalentAdapter mAdapter;
    private ArrayList<CoderModel> coders = new ArrayList<CoderModel>();

    private int [] imgResArr = {R.drawable.p1,R.drawable.p2,R.drawable.p3,
            R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cardview_common, container, false);
        //注入view和事件
        ViewUtils.inject(this, rootView);
        Logger.v(TAG, "TalentFragment onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TalentAdapter(coders);
        mRecyclerView.setAdapter(mAdapter);

        swipeLayout.setOnRefreshListener(this);
        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);
    }

    int i = 1;

    @Override
    public void onRefresh() {
        swipeLayout.setEnabled(false);
        swipeLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i ++;
                if (i == 8) {
                    i = 0;
                }

                CoderModel coder = new CoderModel();
                coder.setName("New CoderModel ");
                coder.setCoverResId(i % 2 == 0 ? imgResArr[5] : imgResArr[6]);
                coder.setJobType(i % 2 == 0 ? "Android" : "iOS");

                mAdapter.addItemAtIndex(0, coder);
                swipeLayout.setRefreshing(false);
                swipeLayout.setEnabled(true);
            }
        }, 2000);

    }


    private void initData() {
        for (int i = 0; i <= imgResArr.length - 1; i++) {
            CoderModel coder = new CoderModel();
            coder.setName("Steve Jobs " + i);
            coder.setCoverResId(imgResArr[i]);
            coder.setJobType(i % 2 == 0 ? "Android" : "iOS");

            coders.add(coder);
        }

    }


}
