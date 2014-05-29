package com.imcore.common.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.imcore.common.http.HttpHelper;
import com.imcore.common.http.RequestEntity;
import com.imcore.common.http.ResponseJsonEntity;
import com.imcore.common.util.ConnectivityUtil;
import com.imcore.common.util.JsonUtil;
import com.imcore.common.util.SharedPreferencesUtil;
import com.imcore.common.util.TextUtil;
import com.imcore.common.util.ToastUtil;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText	mUserNameET;
	private EditText	mPasswordET;
	private Button		mRegistButton;
	private Button		mLoginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mUserNameET = (EditText) findViewById(R.id.account_edit);
		mPasswordET = (EditText) findViewById(R.id.password_edit);
		mRegistButton = (Button) findViewById(R.id.register_button);
		mLoginButton = (Button) findViewById(R.id.login_button);
		mRegistButton.setOnClickListener(this);
		mLoginButton.setOnClickListener(this);
		// 若已经有保存记住密码，则延时实现直接登录
	/**	if (mUserNameET != null && mPasswordET != null) {
			SharedPreferences sharedPre = getSharedPreferences("config",
					MODE_PRIVATE);
			String username = sharedPre.getString("username", "");
			String password = sharedPre.getString("password", "");
			mUserNameET.setText(username);
			mPasswordET.setText(password);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				doLogin();
			}
		}
*/
	}

		
	//执行注册和登录
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.register_button:
				// doRegister();
				break;

			case R.id.login_button:
				doLogin();
				break;
		}
	}

	// 接口没有提供，略去
	// protected void doRegister() {
	// }

	/**
	 * 登录到Home界面
	 * 
	 * @author
	 * @time 2014年5月26日 下午3:57:25 Versions
	 */

	protected void doLogin() {
		// 网络有链接，输入用户名和密码可实现登录
//  		if (ConnectivityUtil.isOnline(this)) {
//			String inputUserName = mUserNameET.getText().toString();
//			String inputPassword = mPasswordET.getText().toString();
//			// 记住密码
//			SharedPreferencesUtil.saveLoginInfo(LoginActivity.this,
//					inputUserName, inputPassword);
//			// 异步加载登录减少耗时操作，通过AsyncTask异步请求网络服务
//			new LoginTask(inputUserName, inputPassword).execute();
//		} else {
//			// 网络无连接弹出提醒吐司
//			ToastUtil.showToast(LoginActivity.this, "没有网络连接");
//		}
//
//	}
//
//	// 构造新的异步任务类，通过构造函数传递参数数据
//	class LoginTask extends AsyncTask<Void, Void, String> {
//		private String	mUserName;
//		private String	mPassword;
//
//		public LoginTask(String userName, String password) {
//			mUserName = userName;
//			mPassword = password;
//		}
//
//		// 负责执行很耗时的后台计算工作
//		@Override
//		protected String doInBackground(Void... params) {
//
//			String url = "/passport/login.do";
//			// 把请求参数(即用户名和密码)包装到Map中
//			Map<String, Object> args = new HashMap<String, Object>();
//			args.put("phoneNumber", mUserName);
//			args.put("password", mPassword);
//			args.put("client", "android");
//
//			// 构造RequestEntity参数(请求实体)，并把请求实体所需要的参数传递进去
//			RequestEntity entity = new RequestEntity(url, args);
//			String jsonResponse = null;
//			try {
//				// 提交请求参数实体，获得响应数据
//				jsonResponse = HttpHelper.execute(entity);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// 得到服务器响应的json格式的字符串
//			return jsonResponse;
//
//		}
//
//		// 被UI thread调用，后台的计算结果将通过该方法传递到UI thread.
//		@Override
//		protected void onPostExecute(String result) {
//			// 响应回来之后构建ResponseEntity(响应实体)
//			if (TextUtil.isEmptyString(result)) {
//				ToastUtil.showToast(LoginActivity.this, "登录信息缺失或不正确");
//				return;
//			}
//			ResponseJsonEntity resEntity = ResponseJsonEntity.fromJSON(result);
//			// 根据服务器响应码判断登录情况
//			if (resEntity.getStatus() == 200) {
//				String jsonData = resEntity.getData();
//				Log.i("user", jsonData);
//				String usreId = JsonUtil.getJsonValueByKey(jsonData, "usreId");
//				String token = JsonUtil.getJsonValueByKey(jsonData, "token");
//				// 保存userId和token
//				SharedPreferencesUtil.saveLoginKey(LoginActivity.this, usreId,
//						token);
				//跳转至主页面
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this,HomeActivity.class);
				startActivity(intent);
				//销毁登陆界面
				LoginActivity.this.finish();
//			} else {
//				// 响应码不是200的错误判断
//				ToastUtil.showToast(LoginActivity.this, resEntity.getMessage());
//			}
//		}
//	};
//		
   }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
