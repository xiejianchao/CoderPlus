package com.coderplus.materialdrawerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class DatingDetailsActivity extends BaseActivity {

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @Override
    public int getContentView() {
        return R.layout.activity_dating;
    }

    @Override
    public void init(Bundle savedInstanceStat) {
        ViewUtils.inject(this);
        setSupportActionBar(toolbar);

        EditText edit=(EditText)findViewById(R.id.et_content1);
//        edit.setInputType(InputType.TYPE_NULL);

    }

}
