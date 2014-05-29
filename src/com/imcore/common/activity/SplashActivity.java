package com.imcore.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {
	private final int	SPLASH_DELAY_TIME	= 2000; // �ӳ�2��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		if (hasFocus == true) {
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					Intent intent = new Intent(SplashActivity.this,
							LoginActivity.class);
					startActivity(intent);
					SplashActivity.this.finish();
				}
			}, SPLASH_DELAY_TIME);
			

		}
		super.onWindowFocusChanged(hasFocus);
	}

}
