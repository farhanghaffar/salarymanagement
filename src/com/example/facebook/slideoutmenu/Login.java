package com.example.facebook.slideoutmenu;

import java.util.Map;

import org.json.JSONObject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends MainActivity {
	Button btnLogin;
	EditText txt_name, txt_password;
	String name, pass;
	public static boolean Error;
	SendData sendData;
	Boolean isInternetPresent = false;
	ConnectionDetector cd;
	TextView hint_name, hint_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.activity_main);
		cd = new ConnectionDetector(Login.this);
		init();
		sendData = new SendData();

		txt_name.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				hint_name.setVisibility(View.INVISIBLE);

			}
		});
		txt_name.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				hint_name.setVisibility(View.INVISIBLE);
				return false;
			}
		});

		txt_password.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				hint_password.setVisibility(View.INVISIBLE);

			}
		});
		txt_password.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				hint_password.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isInternetPresent = cd.isConnectingToInternet();
				if (isInternetPresent) {
					if (txt_name.length() == 0 || txt_name.equals("")) {
						Toast.makeText(getApplicationContext(), "Please enter user name", Toast.LENGTH_SHORT).show();
						hint_name.setVisibility(View.VISIBLE);
					}
					if (txt_password.equals("") || txt_password.length() == 0) {
						Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
						hint_password.setVisibility(View.VISIBLE);
					} else {
						new webservices().execute();

					}
				} else {

					/*
					 * Dialog dialog = new Dialog(Login.this);
					 * dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					 * dialog.setTitle("Salary Management");
					 * dialog.setContentView(R.layout.customdialog);
					 * dialog.show();
					 */

					Toast.makeText(getApplicationContext(), "Not internet connection", Toast.LENGTH_LONG).show();
				}

			}
		});

	}

	void init() {
		btnLogin = (Button) findViewById(R.id.btnLogin);
		txt_name = (EditText) findViewById(R.id.txt_Name);
		txt_password = (EditText) findViewById(R.id.txt_Password);
		hint_name = (TextView) findViewById(R.id.txt_hint_name);
		hint_password = (TextView) findViewById(R.id.txt_hint_password);
		hint_name.setVisibility(View.INVISIBLE);
		hint_password.setVisibility(View.INVISIBLE);
	}

	class webservices extends AsyncTask<Void, Void, Void> {
		String obj;
		String res = "";
		String fina;

		@Override
		protected Void doInBackground(Void... params) {
			try {
				obj = sendData.data(name, pass);
				res = obj.toString();
				Log.d("Response----", res);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (res.equals("1")) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				// Toast.makeText(getApplicationContext(), "Login seccessfully",
				// Toast.LENGTH_LONG).show();

			} else {
				Toast.makeText(getApplicationContext(), "User name/password does not exixt.Please try again",
						Toast.LENGTH_LONG).show();
			}

		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			name = txt_name.getText().toString();
			pass = txt_password.getText().toString();

		}
	}

}
