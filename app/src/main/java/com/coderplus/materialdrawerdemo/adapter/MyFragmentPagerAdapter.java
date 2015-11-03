package com.coderplus.materialdrawerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> list;

	private String[] titles;

	public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> pages,String[] titles) {

		super(fm);

		this.list = pages;
		this.titles=titles;
	}


	@Override
	public CharSequence getPageTitle(int position) {

		return   this.titles[position];
	}


	@Override
	public int getCount() {
		Log.v("zms", "MyFragmentPagerAdapter里的getCount:" + list.size() + "个");
		return list.size();
	}

	@Override
	public Fragment getItem(int arg0) {
		Log.v("zms", "MyFragmentPagerAdapter里的 getitem:"+arg0);
		return list.get(arg0);
	}




}
