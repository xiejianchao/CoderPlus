package com.coderplus.materialdrawerdemo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coderplus.materialdrawerdemo.Constants.Constants;
import com.coderplus.materialdrawerdemo.Constants.Constants;
import com.coderplus.materialdrawerdemo.Constants.LocalData;
import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.TalentActivity;
import com.coderplus.materialdrawerdemo.adapter.CoderTypeAdapter;
import com.coderplus.materialdrawerdemo.model.CoderTypeModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.utils.DensityUtility;
import com.coderplus.materialdrawerdemo.utils.Logger;
import com.coderplus.materialdrawerdemo.view.SpaceItemDecoration;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


public class CoderTypeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private static final String TAG = TalentFragment.class.getSimpleName();

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.swipe_layout)
    private SwipeRefreshLayout swipeLayout;

    private LinearLayoutManager mLayoutManager;
    private CoderTypeAdapter mAdapter;
    private ArrayList<CoderTypeModel> coderTypes;

    public static CoderTypeFragment newInstance(String param1, String param2) {
        CoderTypeFragment fragment = new CoderTypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CoderTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coder_type_cardview, container, false);
        //注入view和事件
        ViewUtils.inject(this, rootView);
        Logger.v(TAG, "TalentFragment onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        coderTypes = LocalData.getCoderTypes();
        mAdapter = new CoderTypeAdapter(coderTypes);
        mAdapter.setOnItemClickListener(itemClickListener);
        mRecyclerView.setAdapter(mAdapter);

        swipeLayout.setOnRefreshListener(this);
        //设置下拉刷新圆圈箭头的颜色
        swipeLayout.setColorSchemeResources(R.color.color_swiperefresh_color);

//        mRecyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtility.dip2px(getContext(),10)));
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {


        @Override
        public void onItemclick(View view, int position) {
            Intent intent = new Intent(getActivity(), TalentActivity.class);
            switch (coderTypes.get(position).getType()) {
                case LocalData.CODER_TYPE_ANDROID:
                    intent.putExtra(Constants.CODER_TYPE,getString(R.string.plus_android));
                    break;
                case LocalData.CODER_TYPE_IOS:
                    intent.putExtra(Constants.CODER_TYPE,getString(R.string.plus_ios));
                    break;
                case LocalData.CODER_TYPE_JAVA:
                    intent.putExtra(Constants.CODER_TYPE,getString(R.string.plus_java));
                    break;
            }
            startActivity(intent);
        }
    };

    @Override
    public void onRefresh() {
        swipeLayout.setRefreshing(true);
        swipeLayout.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "已经是最新数据啦", Toast.LENGTH_SHORT).show();
                swipeLayout.setRefreshing(false);
                swipeLayout.setEnabled(true);
            }
        }, 2000);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
