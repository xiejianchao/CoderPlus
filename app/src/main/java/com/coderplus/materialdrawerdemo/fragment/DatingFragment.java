

package com.coderplus.materialdrawerdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderplus.materialdrawerdemo.Constants.LocalData;
import com.coderplus.materialdrawerdemo.DatingDetailsActivity;
import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.adapter.DatingAdapter;
import com.coderplus.materialdrawerdemo.model.DatingModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.utils.DensityUtility;
import com.coderplus.materialdrawerdemo.utils.Logger;
import com.coderplus.materialdrawerdemo.utils.ToastUtil;
import com.coderplus.materialdrawerdemo.view.SpaceItemDecoration;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


/**
 * 约会Fragment
 */
public class DatingFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = DatingFragment.class.getSimpleName();

    private View rootView;

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    private LinearLayoutManager mLayoutManager;
    private DatingAdapter mAdapter;
    private ArrayList<DatingModel> datingList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cardview_common, container, false);
        //注入view和事件
        ViewUtils.inject(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        datingList = LocalData.getDatingData();
        mAdapter = new DatingAdapter(datingList);
        mAdapter.setOnItemClickListener(itemClickListener);
        mRecyclerView.setAdapter(mAdapter);

        swipeLayout.setOnRefreshListener(this);
        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);

        mRecyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtility.dip2px(getContext(), 0)));
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {


        @Override
        public void onItemclick(View view, int position) {
            Logger.d(TAG,"onItemClick");
            startActivity(new Intent(context, DatingDetailsActivity.class));
        }
    };

    @Override
    public void onRefresh() {
        swipeLayout.setRefreshing(true);
        swipeLayout.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtil.showShortToast(context,"暂时没有更多活动了");
                swipeLayout.setRefreshing(false);
                swipeLayout.setEnabled(true);
            }
        }, 2000);
    }


}
