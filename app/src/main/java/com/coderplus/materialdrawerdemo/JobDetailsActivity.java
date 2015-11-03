package com.coderplus.materialdrawerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class JobDetailsActivity extends BaseActivity {

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.fab)
    private FloatingActionButton fab;

    @ViewInject(R.id.tv_job_describe)
    private TextView tvJobDesc;

    @Override
    public int getContentView() {
        return R.layout.activity_job_details;
    }

    @Override
    public void init(Bundle savedInstanceStat) {
        ViewUtils.inject(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setTitle("高级工程师");

        tvJobDesc.setText("1.  熟悉面向对象思想，熟悉至少一种软件开发模式，良好的设计功底与文档编写能力\n" +
                "\n" +
                "2.  对数据敏感，乐于分析数据。\n" +
                "\n" +
                "3.  精通Java语言，熟悉J2EE架构体系，精通设计模式并可熟练运用\n" +
                "\n" +
                "4.  熟悉SQL语言，拥有丰富的SQL调优经验\n" +
                "\n" +
                "5.  2年以上带领小型团队完成开发工作的经验,良好的沟通协调能力和进度控制能力\n" +
                "\n" +
                "6.  具备较强的逻辑思维能力，能快速分析并解决出现的问题\n" +
                "\n" +
                "7.  具备数据分析、BI或数据仓库、报表等相关开发经验\n" +
                "\n" +
                "8.  熟悉hadoop、storm、spark、hbase、hive任意一种者优先（非必须）");

    }
}
