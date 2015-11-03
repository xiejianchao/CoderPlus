package com.coderplus.materialdrawerdemo;

import android.content.Context;
import android.os.Bundle;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by xiejianchao on 15/10/20.
 */
public abstract class BaseActivity extends SwipeBackActivity {

    protected Context context;

    protected SwipeBackLayout mSwipeBackLayout;

    public abstract int getContentView();
    public abstract void init(Bundle savedInstanceStat);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        this.context = this;
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        init(savedInstanceState);
    }

    protected void enableSwipeBack(boolean enable) {
        setSwipeBackEnable(enable);
    }


}
