package com.example.Profile;

import com.example.Profile.CreateNew_User.webservicrs;
import com.example.facebook.slideoutmenu.ConnectionDetector;
import com.example.facebook.slideoutmenu.MainActivity;
import com.example.facebook.slideoutmenu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_Employee extends Activity {

	Button btnSave;
	EditText name,experience,phone,c_salry,join_date,desig,idcard,address;
	Edit_WebServices objEdit_WebServices;
	String u_name,u_cell,u_address,u_desig,u_salary,u_id,u_date,u_exper,prviouse_id;
	TextView h_name,h_experince,h_phone,h_salary,h_date,h_desig,h_idcard,h_address;
	Boolean isInternetPresent = false;
	ConnectionDetector cd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		cd = new ConnectionDetector(Edit_Employee.this);
		init();
		click_listner();
		objEdit_WebServices = new Edit_WebServices();
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			
				isInternetPresent = cd.isConnectingToInternet();
				if (isInternetPresent) {
					
					if (idcard.length() == 0 || idcard.equals("")) {
						Toast.makeText(getApplicationContext(), "id card" +idcard.length(), Toast.LENGTH_SHORT).show();
						h_idcard.setVisibility(View.VISIBLE);
					}
					if (address.length() == 0 || address.equals("")) {
						Toast.makeText(getApplicationContext(), "address"  +address.length(), Toast.LENGTH_SHORT).show();
						h_address.setVisibility(View.VISIBLE);
					}
					if (desig.length() == 0 || desig.equals("")) {
						Toast.makeText(getApplicationContext(), "desig" +desig.length(), Toast.LENGTH_SHORT).show();
						h_desig.setVisibility(View.VISIBLE);
					}
					if (join_date.length() == 0 || join_date.equals("")) {
						Toast.makeText(getApplicationContext(), "date"+join_date.length(), Toast.LENGTH_SHORT).show();
						h_date.setVisibility(View.VISIBLE);
					}
					if (name.length() == 0 || name.equals("")) {
						Toast.makeText(getApplicationContext(), "name"+ name.length(), Toast.LENGTH_SHORT).show();
						h_name.setVisibility(View.VISIBLE);
					}	
					if (experience.length() == 0 || experience.equals("")) {
						Toast.makeText(getApplicationContext(), "experience" +experience.length(), Toast.LENGTH_SHORT).show();
						h_experince.setVisibility(View.VISIBLE);
					}
					if (c_salry.length() == 0 || c_salry.equals("")) {
						Toast.makeText(getApplicationContext(), "salry"+ c_salry.length(), Toast.LENGTH_SHORT).show();
						h_salary.setVisibility(View.VISIBLE);
					}
					if (phone.length() == 0 || phone.equals("")) {
						Toast.makeText(getApplicationContext(), "phone"+ phone.length(), Toast.LENGTH_SHORT).show();
						h_phone.setVisibility(View.VISIBLE);
					}
					
					 /*if(phone.length()!=0 || phone!=null && experience.length() != 0 || experience!=null&&
					experience.length() != 0 || experience!=null &&name.length() != 0 || name!=null&&
					join_date.length() != 0 || join_date!=null && desig.length() != 0 || desig!=null&&
					address.length() != 0 || address!=null && idcard.length() != 0 || idcard!=null&&
					c_salry.length() != 0 || c_salry!=null){*/
					else{
						new webservicrs().execute();
						Toast.makeText(getApplicationContext(), "else if", Toast.LENGTH_SHORT).show();
					}
					
				}
				else{
					Toast.makeText(getApplicationContext(), "No Internet Connection.Please try again", Toast.LENGTH_SHORT).show();
				}
			
			}
		});
	}
	
	void init(){
		btnSave = (Button) findViewById(R.id.btnSave_e);
		name = (EditText) findViewById(R.id.txt_UserName_e);
		experience = (EditText) findViewById(R.id.txt_experience_e);
		phone = (EditText) findViewById(R.id.txt_cell_e);
		c_salry = (EditText) findViewById(R.id.txt_salary_e);
	    join_date       = (EditText) findViewById(R.id.txt_join_date_e);
		desig = (EditText) findViewById(R.id.txt_designiation_e);
		idcard = (EditText) findViewById(R.id.txt_idcardnumber_e);
		address = (EditText) findViewById(R.id.txt_Address_e);
		
		h_name = (TextView) findViewById(R.id.txt_hinte_name);
		h_experince = (TextView) findViewById(R.id.txt_hinte_experience);
		h_phone = (TextView) findViewById(R.id.txt_hinte_cell);
		h_salary = (TextView) findViewById(R.id.txt_hinte_salary);
		h_date = (TextView) findViewById(R.id.txt_hinte_date);
		h_desig = (TextView) findViewById(R.id.txt_hinte_designiation);
		h_idcard = (TextView) findViewById(R.id.txt_hinte_idcard);
		h_address = (TextView) findViewById(R.id.txt_hinte_address);
		
		h_name.setVisibility(View.INVISIBLE);
		h_experince.setVisibility(View.INVISIBLE);
		h_phone.setVisibility(View.INVISIBLE);
		h_salary.setVisibility(View.INVISIBLE);
		h_date.setVisibility(View.INVISIBLE);
		h_desig.setVisibility(View.INVISIBLE);
		h_idcard.setVisibility(View.INVISIBLE);
		h_address.setVisibility(View.INVISIBLE);
		
		String get_name = MainActivity.name_list.get(MainActivity.number).toString();
		name.setText(get_name);
		String get_phone = MainActivity.cell.get(MainActivity.number).toString();
		phone.setText(get_phone);
		String get_salary = MainActivity.salary.get(MainActivity.number).toString();
		c_salry.setText(get_salary);
		String get_address = MainActivity.address.get(MainActivity.number).toString();
		address.setText(get_address);
		String get_date = MainActivity.Join_date.get(MainActivity.number).toString();
		join_date.setText(get_date);
		String get_desig = MainActivity.desig.get(MainActivity.number).toString();
		desig.setText(get_desig);
		String get_IdCard = MainActivity.id_Cards.get(MainActivity.number).toString();
		idcard.setText(get_IdCard);
		String get_experience = MainActivity.experience.get(MainActivity.number).toString();
		experience.setText(get_experience);
		
		
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
			if (phone.length() == 0 || phone.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user phone number", Toast.LENGTH_SHORT).show();
				h_phone.setVisibility(View.VISIBLE);
			}
			if (c_salry.length() == 0 || c_salry.equals("")) {
				//Toast.makeText(getApplicationContext(), "Please enter user salary", Toast.LENGTH_SHORT).show();
				h_salary.setVisibility(View.VISIBLE);
			}
			else{
				new webservicrs().execute();
			}
			
		}
		else{
			Toast.makeText(getApplicationContext(), "No Internet Connection.Please try again", Toast.LENGTH_SHORT).show();
		}
	}
	class webservicrs extends AsyncTask<Void, Void, Void>
	{
		String obj;
		String res;
		@Override
		protected Void doInBackground(Void... params) {

try {
	obj = objEdit_WebServices.data(u_name, u_cell, u_exper, u_salary, u_date, u_desig, u_address, u_id,prviouse_id);
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
			prviouse_id =  MainActivity.id_Cards.get(MainActivity.number).toString();
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if (res.equals("1")) {
				Intent i = new Intent(Edit_Employee.this,MainActivity.class);
				startActivity(i);
				
				Toast.makeText(getApplicationContext(), "User data update successfully", Toast.LENGTH_LONG).show();

			} else {
				Toast.makeText(getApplicationContext(), "User data does not update successfully.Please try again",
						Toast.LENGTH_LONG).show();
			}

			
		}
	}
}
