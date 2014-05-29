package com.imcore.common.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.imcore.common.activity.ProductBaseActivity;
import com.imcore.common.activity.R;

public class MallFragment extends Fragment {
	private ListView	listView;
	private SimpleAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mall_home, null);

		listView = (ListView) view.findViewById(R.id.lv_mall_product);
		
		 adapter = new SimpleAdapter(getActivity(),getData(),R.layout.fragment_product_category,
                new String[]{"title","img"},
                new int[]{R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a});
		 listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				switch (position) {
					case 0:
						Intent intent = new Intent();
						intent.setClass(getActivity(),
								ProductBaseActivity.class);
						startActivity(intent);
						break;
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

						break;

				}

			}

		});

		return view;
	}

	 private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "¥Û∫Ï≈€");
         map.put("img", R.drawable.a);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "Ã˙π€“Ù");
         map.put("img", R.drawable.a);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "∆’∂˝≤Ë");
         map.put("img", R.drawable.a);
         list.add(map);
         
         map = new HashMap<String, Object>();
         map.put("title", "∫Ï≤Ë");
         map.put("img", R.drawable.a);
         list.add(map);
          
         return list;
     }
 }


