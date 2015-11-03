
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

import com.coderplus.materialdrawerdemo.Constants.AppConfig;
import com.coderplus.materialdrawerdemo.JobDetailsActivity;
import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.adapter.JobAdapter;
import com.coderplus.materialdrawerdemo.model.JobModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.utils.Logger;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 工作Fragment
 */
public class JobFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,OnItemClickListener{

    private static final String TAG = JobFragment.class.getSimpleName();

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    private LinearLayoutManager mLayoutManager;
    private JobAdapter mAdapter;
    private ArrayList<JobModel> jobs = new ArrayList<JobModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        Logger.v(TAG, "JobFragment onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_cardview_common, container, false);
        //注入view和事件
        ViewUtils.inject(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new JobAdapter(jobs);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

        swipeLayout.setOnRefreshListener(this);
        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);
    }

    @Override
    public void onItemclick(View view, int position) {

        Intent intent = new Intent(context,JobDetailsActivity.class);
        startActivity(intent);

    }

    int i = 1;

    @Override
    public void onRefresh() {
        swipeLayout.setRefreshing(true);
        swipeLayout.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i++;

                if (i == 8) {
                    i = 0;
                }
                JobModel job = new JobModel();
                job.setJobTitle(jobTitleArr[i]);
                job.setCompanyLogoResId(AppConfig.imgResArr[i]);
                job.setCompany(i % 2 == 0 ? "百度" : "阿里巴巴");
                job.setJobIntroduction(i % 2 == 0 ? "北京 3-5年 本科" : "北京 1-3年 本科");
                job.setSalary(i % 2 == 0 ? 50 : 20);
                job.setPublishDate(sdf.format(new Date()));

                mAdapter.addItemAtIndex(0, job);
                swipeLayout.setRefreshing(false);
                swipeLayout.setEnabled(true);
                mRecyclerView.scrollToPosition(0);
            }
        }, 2000);

    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String [] jobTitleArr = {"前端工程师","高级iOS工程师","高级Android工程师","高级Java Web工程师","技术总监","javascript工程师","高级Ruby工程师","运维工程师"};

    private void initData() {
        for (int i = 0; i <= AppConfig.imgResArr.length - 1; i++) {
            JobModel job = new JobModel();
            job.setJobTitle(jobTitleArr[i]);
            job.setCompanyLogoResId(AppConfig.imgResArr[i]);
            job.setCompany(i % 2 == 0 ? "百度" : "阿里巴巴");
            job.setJobIntroduction(i % 2 == 0 ? "北京 3-5年 本科" : "北京 1-3年 本科");
            job.setSalary(i % 2 == 0 ? 50 : 20);
            job.setPublishDate(sdf.format(new Date()));

            jobs.add(job);
        }

    }


}
