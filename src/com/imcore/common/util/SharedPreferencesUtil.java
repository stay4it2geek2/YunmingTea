package com.imcore.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtil {

	public static void saveLoginInfo(Context context, String username,
			String password) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("phoneNumber", username);
		editor.putString("password", password);
		editor.commit();
	}
	
	

	public static void saveLoginKey(Context context, String id,
			String token) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("id", id);
		editor.putString("token", token);
		editor.commit();
	}
	

	


}
