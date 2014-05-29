package com.imcore.common.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.imcore.common.fragment.HomeFragment;
import com.imcore.common.fragment.MallFragment;
import com.imcore.common.fragment.MoreFragment;
import com.imcore.common.fragment.MyAccountFragment;

public class HomeActivity extends ActionBarActivity {

	private DrawerLayout			mDrawerLayout;				// 移动导航布局
	private ActionBarDrawerToggle	mDrawerToggle;				// 切换键
	private ListView				mDrawerList;				// 抽屉信息显示列表
	private CharSequence			mDrawerTitle;				// 抽屉名
	private String[]				mNaviItemText;				// 抽屉条目标签名集合
	private CharSequence			mTitle;						// 抽屉条目标签

	private final static String		NAVI_ITEM_TEXT	= "text";//导航条目标签
	private final static String		NAVI_ITEM_ICON	= "icon";//导航条目图标

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initDrawerLayout();
		selectNaviItem(0);
	}

	/**
	 * 初始化导航布局
	 * 
	 * @author
	 * @time  2014年5月26日 下午8:37:22
	 * Versions
	 */
	private void initDrawerLayout() {
	    //获取导航条目标签
		mNaviItemText = getResources().getStringArray(R.array.navi_items);
	    //获取导航抽屉标题
		mDrawerTitle = getResources().getString(R.string.app_name);
		//找到导航布局控件
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		
		//部署各个导航标签属性
		Map<String, Object> homeItem= new HashMap<String, Object>();
		homeItem.put(NAVI_ITEM_TEXT, mNaviItemText[0]);
		homeItem.put(NAVI_ITEM_ICON, R.drawable.location_map);

		Map<String, Object> mallItem  = new HashMap<String, Object>();
		mallItem.put(NAVI_ITEM_TEXT, mNaviItemText[1]);
		mallItem.put(NAVI_ITEM_ICON, R.drawable.location_place);

		Map<String, Object> myAccoutItem = new HashMap<String, Object>();
		myAccoutItem.put(NAVI_ITEM_TEXT, mNaviItemText[2]);
		myAccoutItem.put(NAVI_ITEM_ICON, R.drawable.social_bcc);

		Map<String, Object> moreItem = new HashMap<String, Object>();
		moreItem.put(NAVI_ITEM_TEXT, mNaviItemText[3]);
		moreItem.put(NAVI_ITEM_ICON, R.drawable.social_chat);

		List<Map<String, Object>> guideList = new ArrayList<Map<String, Object>>();
		//添加导航抽屉条目内容
		guideList.add(homeItem);
		guideList.add(mallItem);
		guideList.add(myAccoutItem);
		guideList.add(moreItem);

		String[] from = new String[] { NAVI_ITEM_TEXT, NAVI_ITEM_ICON };
		int[] to = new int[] { R.id.tv_navi_item_text, R.id.iv_navi_item_icon };
	   //找到导航列表控件
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		//给控件添加适配器
		mDrawerList.setAdapter(new SimpleAdapter(this, guideList,
				R.layout.view_navi_drawer_item, from, to));
		mDrawerList.setOnItemClickListener(new NaviDrawerListItemOnClickListner());

		initialDrawerListener();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	//初始化抽屉导航布局监听
	private void initialDrawerListener() {
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.drawable.ic_drawer,
				R.drawable.ic_drawer) {
			@Override
			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				getSupportActionBar().setTitle(mTitle);
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	//导航条目点击监听器
	private class NaviDrawerListItemOnClickListner implements
			OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectNaviItem(position);
		}
	}
	//导航条目被选中时返回片段的方法
	private void selectNaviItem(int position) {
		Fragment fragment = null;
		switch (position) {
			case 0:
				fragment = new HomeFragment();
				break;
			case 1:
				fragment = new MallFragment();
				break;
			case 2:
				fragment = new MyAccountFragment();
				break;
			case 3:
				fragment = new MoreFragment();
		}
        //更新片段
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.main_content, fragment);
		ft.commit();
        
		//同步更新片段标签
		mDrawerList.setItemChecked(position, true);
		setTitle(mNaviItemText[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		//
		return super.onOptionsItemSelected(item);
	}

}
