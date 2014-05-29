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
 * ��Ŀ���ƣ�������Ҷ �����ƣ�HomeFragment �������� ��ҳƬ�� �����ˣ�Administrator ����ʱ�䣺2014��5��27��
 * ����11:26:29
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
