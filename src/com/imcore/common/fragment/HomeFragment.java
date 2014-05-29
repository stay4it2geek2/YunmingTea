package com.imcore.common.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.imcore.common.activity.ProductBaseActivity;
import com.imcore.common.activity.R;
import com.imcore.common.model.ProductCategory;

/**
 * 
 * 项目名称：云铭茶叶 类名称：HomeFragment 类描述： 主页片段 创建人：Administrator 创建时间：2014年5月27日
 * 上午11:26:29
 * 
 * @version
 */
public class HomeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_home, null);
		return view;
	}
}
