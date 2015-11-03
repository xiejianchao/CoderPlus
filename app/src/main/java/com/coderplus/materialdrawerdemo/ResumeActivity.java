package com.coderplus.materialdrawerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.coderplus.materialdrawerdemo.Constants.LocalData;
import com.coderplus.materialdrawerdemo.adapter.ResumeAdapter;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.utils.ToastUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 个人简历Activity
 */
public class ResumeActivity extends BaseActivity implements OnItemClickListener,SwipeRefreshLayout.OnRefreshListener{

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.recycler_view)
    private RecyclerView recyclerView;
    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    @Override
    public int getContentView() {
        return R.layout.activity_resume;
    }

    @Override
    public void init(Bundle savedInstanceStat) {
        ViewUtils.inject(this);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setTitle("专家概况");

        //初始化Adapter
        ResumeAdapter adapter = new ResumeAdapter(LocalData.getResumeList());

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        // 设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置RecyclerView的下拉刷新监听
        swipeLayout.setOnRefreshListener(this);

        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);

    }

    private Handler handler = new Handler();

    @Override
    public void onRefresh() {
        swipeLayout.setRefreshing(true);
        swipeLayout.setEnabled(false);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(true);
                swipeLayout.setEnabled(false);
            }
        },2000);
    }

    @Override
    public void onItemclick(View view, int position) {

    }


}
