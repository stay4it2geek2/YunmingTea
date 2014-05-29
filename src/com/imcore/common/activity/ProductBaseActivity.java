package com.imcore.common.activity;

import java.util.ArrayList;
import java.util.List;

import com.imcore.common.fragment.DhpFragment;
import com.imcore.common.fragment.HcFragment;
import com.imcore.common.fragment.PeFragment;
import com.imcore.common.fragment.TgyFragment;

import android.os.Bundle;
import android.provider.CalendarContract.Instances;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.BaseAdapter;

/**
 * 
 * 项目名称：芸茗茶叶 类名称：ProductViewpagerActivity 类描述： 产品列表小类选项卡 创建人：Administrator
 * 创建时间：2014年5月28日 上午10:17:34
 * 
 * @version
 */
public class ProductBaseActivity extends ActionBarActivity {
	private ViewPager				mViewPager;
	private List<Fragment>			frgmtList;
	private ProductViewpagerAdapter	pViewpagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_pager);

		mViewPager = (ViewPager) findViewById(R.id.vp_mall_product);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		frgmtList = new ArrayList<Fragment>();
		frgmtList.add(new DhpFragment());
		frgmtList.add(new TgyFragment());
		frgmtList.add(new PeFragment());
		frgmtList.add(new HcFragment());

		pViewpagerAdapter = new ProductViewpagerAdapter();
		mViewPager.setAdapter(pViewpagerAdapter);
		mViewPager.setOnPageChangeListener(pageChangeListener);

		List<String> tabTextList = new ArrayList<String>();
		tabTextList.add("大红袍");
		tabTextList.add("铁观音");
		tabTextList.add("普洱茶");
		tabTextList.add("红茶");

		for (String str : tabTextList) {
			Tab tab = actionBar.newTab();
			tab.setText(str);
			tab.setTabListener(new TabListener() {
				
				@Override
				public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
					mViewPager.setCurrentItem(arg0.getPosition());
					
				}
				
				@Override
				public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
					// TODO Auto-generated method stub
					
				}
			});
			actionBar.addTab(tab);
		}
	}

	public OnPageChangeListener	pageChangeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			getSupportActionBar().setSelectedNavigationItem(arg0);
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	class ProductViewpagerAdapter extends FragmentStatePagerAdapter {

		public ProductViewpagerAdapter() {
			super(getSupportFragmentManager());

		}

		@Override
		public Fragment getItem(int position) {

			return frgmtList.get(position);
		}

		@Override
		public int getCount() {

			return frgmtList.size();
		}

	}
}