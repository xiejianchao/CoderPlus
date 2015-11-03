package com.coderplus.materialdrawerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.coderplus.materialdrawerdemo.Constants.Constants;
import com.coderplus.materialdrawerdemo.adapter.TalentAdapter;
import com.coderplus.materialdrawerdemo.model.CoderModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.utils.Logger;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


/**
 * 人才详情Activity
 */
public class TalentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = TalentActivity.class.getSimpleName();

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    private LinearLayoutManager mLayoutManager;
    private TalentAdapter mAdapter;
    private ArrayList<CoderModel> coders = new ArrayList<CoderModel>();

    private int [] imgResArr = {R.drawable.p1,R.drawable.p2,R.drawable.p3,
            R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};

    private String coderType;


    @Override
    public int getContentView() {
        return R.layout.activity_talent;
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

        Intent intent = getIntent();
        if (intent != null) {
            coderType = intent.getStringExtra(Constants.CODER_TYPE);
        }

        getSupportActionBar().setTitle(coderType + "(共" + imgResArr.length + "人)");

        initData();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TalentAdapter(coders);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(itemClickListener);

        swipeLayout.setOnRefreshListener(this);
        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);

    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {


        @Override
        public void onItemclick(View view, int position) {
            Intent intent = new Intent(context,ResumeActivity.class);
            startActivity(intent);
        }
    };


    private int i = 1;

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
                coder.setJobType(coderType);

                mAdapter.addItemAtIndex(0, coder);
                swipeLayout.setRefreshing(false);
                swipeLayout.setEnabled(true);
                mRecyclerView.scrollToPosition(0);
            }
        }, 2000);

    }


    private void initData() {
        for (int i = 0; i <= imgResArr.length - 1; i++) {
            CoderModel coder = new CoderModel();
            coder.setName("Steve Jobs ");
            coder.setCoverResId(imgResArr[i]);
            coder.setJobType(coderType);

            coders.add(coder);
        }

    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.d(TAG,"onKeyDown keyCode = " + keyCode);
        Toast.makeText(this,"onKeyDown keyCode = " + keyCode,Toast.LENGTH_SHORT).show();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Logger.d(TAG,"press back key");
        }

        return super.onKeyDown(keyCode, event);
    }
}
