package com.example.Profile;

import com.example.facebook.slideoutmenu.ConnectionDetector;
import com.example.facebook.slideoutmenu.MainActivity;
import com.example.facebook.slideoutmenu.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateNew_User extends Activity {

	Button btnSave;
	EditText name,experience,phone,c_salry,join_date,desig,idcard,address;
	TextView h_name,h_experince,h_phone,h_salary,h_date,h_desig,h_idcard,h_address;
	Create_UserServices userServices;
	String u_name,u_cell,u_address,u_desig,u_salary,u_id,u_date,u_exper;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createnewuser);
		init();
		cd = new ConnectionDetector(CreateNew_User.this);
		//id card pattern 
		
		click_listner();
		/*idcard.addTextChangedListener(new TextWatcher() {
			   int len=0;
			//   String str = idcard.getText().toString();
			   @Override
			   public void onTextChanged(CharSequence s, int start, int before, int count) {
			    // TODO Auto-generated method stub
			 
			   String str = idcard.getText().toString();
			 
			    if(str.length()==5 && len <str.length() || str.length()==13 && len <str.length()){
			    
			    	idcard.append("-");
			     //Toast.makeText(getBaseContext(), "add minus", Toast.LENGTH_SHORT).show();
			    }
			  
			   }
			   @Override
			   public void beforeTextChanged(CharSequence s, int start, int count,
			     int after) {
			    // TODO Auto-generated method stub
			    String str = idcard.getText().toString();
			    len = str.length();
			    Log.d("Result", ""+len);
			    
			   }
			  
			@Override
			public void afterTextChanged(Editable s) {
				//String str = idcard.getText().toString();
				if(str.length()==13 && len <str.length()){
			    	idcard.append("-");
			    }
				
			}
			  });

*/		
		userServices = new Create_UserServices();
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				validation();
			}
		});
	}
	
	void init(){
		btnSave = (Button) findViewById(R.id.btnSave);
		name = (EditText) findViewById(R.id.txt_UserName);
		experience = (EditText) findViewById(R.id.txt_experience);
		phone = (EditText) findViewById(R.id.txt_cell);
		c_salry = (EditText) findViewById(R.id.txt_salary);
	    join_date       = (EditText) findViewById(R.id.txt_join_date);
		desig = (EditText) findViewById(R.id.txt_designiation);
		idcard = (EditText) findViewById(R.id.txt_idcardnumber);
		address = (EditText) findViewById(R.id.txt_Address);
		
		h_name = (TextView) findViewById(R.id.txt_hintc_name);
		h_experince = (TextView) findViewById(R.id.txt_hintc_experience);
		h_phone = (TextView) findViewById(R.id.txt_hintc_cell);
		h_salary = (TextView) findViewById(R.id.txt_hintc_salary);
		h_date = (TextView) findViewById(R.id.txt_hintc_joindate);
		h_desig = (TextView) findViewById(R.id.txt_hintc_designation);
		h_idcard = (TextView) findViewById(R.id.txt_hintc_idcardno);
		h_address = (TextView) findViewById(R.id.txt_hintc_address);
		
		h_name.setVisibility(View.INVISIBLE);
		h_experince.setVisibility(View.INVISIBLE);
		h_phone.setVisibility(View.INVISIBLE);
		h_salary.setVisibility(View.INVISIBLE);
		h_date.setVisibility(View.INVISIBLE);
		h_desig.setVisibility(View.INVISIBLE);
		h_idcard.setVisibility(View.INVISIBLE);
		h_address.setVisibility(View.INVISIBLE);
		
	}
	void click_listner(){
		idcard.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_idcard.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		name.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_name.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		phone.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_phone.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		desig.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_desig.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		join_date.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_date.setVisibility(View.INVISIBLE);
				return false;
			}
		});		
		experience.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_experince.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		c_salry.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_salary.setVisibility(View.INVISIBLE);
				return false;
			}
		});					
		address.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				h_address.setVisibility(View.INVISIBLE);
				return false;
			}
		});					

	}
	void validation(){
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			
			if (idcard.length() == 0 || idcard.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user identity card number", Toast.LENGTH_SHORT).show();
				h_idcard.setVisibility(View.VISIBLE);
			}
			if (address.length() == 0 || address.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user designation", Toast.LENGTH_SHORT).show();
				h_address.setVisibility(View.VISIBLE);
			}
			if (desig.length() == 0 || desig.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user designation", Toast.LENGTH_SHORT).show();
				h_desig.setVisibility(View.VISIBLE);
			}
			if (join_date.length() == 0 || join_date.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user joinning date", Toast.LENGTH_SHORT).show();
				h_date.setVisibility(View.VISIBLE);
			}
			if (name.length() == 0 || name.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user name", Toast.LENGTH_SHORT).show();
				h_name.setVisibility(View.VISIBLE);
			}	
			if (experience.length() == 0 || experience.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user total experience", Toast.LENGTH_SHORT).show();
				h_experince.setVisibility(View.VISIBLE);
			}		
			if (c_salry.length() == 0 || c_salry.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user salary", Toast.LENGTH_SHORT).show();
				h_salary.setVisibility(View.VISIBLE);
			}
			if (phone.length() == 0 || phone.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user phone number", Toast.LENGTH_SHORT).show();
				h_phone.setVisibility(View.VISIBLE);
			}
			
			else{
				new webservicrs().execute();
			}
			
		}
		else{
			Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
		}
	}
	class webservicrs extends AsyncTask<Void, Void, Void>
	{
		String obj;
		String res;
		@Override
		protected Void doInBackground(Void... params) {

try {
	obj = userServices.data(u_name, u_cell, u_exper, u_salary, u_date, u_desig, u_address, u_id);
	 res = obj.toString();
} catch (Exception e) {
	// TODO: handle exception
}
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			u_name = name.getText().toString();
			u_cell = phone.getText().toString();
			u_address = address.getText().toString();
			u_id  = idcard.getText().toString();
			u_date = join_date.getText().toString();
			u_desig  = desig.getText().toString();
			u_salary = c_salry.getText().toString();
			u_exper  = experience.getText().toString();
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if (res.equals("1")) {
				Toast.makeText(getApplicationContext(), "New user create successfully", Toast.LENGTH_LONG).show();
				Intent i = new Intent(CreateNew_User.this,MainActivity.class);
				startActivity(i);
				
			

			} else {
				Toast.makeText(getApplicationContext(), "New user does not create successfully.Please try again",
						Toast.LENGTH_LONG).show();
			}

			
		}
	}
}
