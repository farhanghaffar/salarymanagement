package com.example.Profile;

import com.example.facebook.slideoutmenu.MainActivity;
import com.example.facebook.slideoutmenu.R;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends Activity {

	String u_name, u_cell, u_address, u_desig, u_salary, u_id, u_date, u_exper,prviouse_id;
	TextView name, phone, salary, address, date, desig, id_card, experience, edit, inactive;
	InactiveEmployee objInactiveEmployee;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.employeelist);
		init();
		Bundle extras = new Bundle();
		objInactiveEmployee = new InactiveEmployee();
		String get_name = MainActivity.name_list.get(MainActivity.number).toString();
		name.setText(get_name);
		String get_phone = MainActivity.cell.get(MainActivity.number).toString();
		phone.setText(get_phone);
		String get_salary = MainActivity.salary.get(MainActivity.number).toString();
		salary.setText(get_salary);
		String get_address = MainActivity.address.get(MainActivity.number).toString();
		address.setText(get_address);
		String get_date = MainActivity.Join_date.get(MainActivity.number).toString();
		date.setText(get_date);
		String get_desig = MainActivity.desig.get(MainActivity.number).toString();
		desig.setText(get_desig);
		String get_IdCard = MainActivity.id_Cards.get(MainActivity.number).toString();
		id_card.setText(get_IdCard);
		String get_experience = MainActivity.experience.get(MainActivity.number).toString();
		experience.setText(get_experience);
		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EditProfile.this, Edit_Employee.class);
	
				startActivity(intent);

			}
		});
inactive.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		new webservicrs().execute();
		
	}
});
	}

	void init() {

		name = (TextView) findViewById(R.id.txtName);
		phone = (TextView) findViewById(R.id.txt_Phone);
		salary = (TextView) findViewById(R.id.txtTotalSalary);
		address = (TextView) findViewById(R.id.txt_Address);
		date = (TextView) findViewById(R.id.txt_JoinDate);
		desig = (TextView) findViewById(R.id.txt_Designiation);
		id_card = (TextView) findViewById(R.id.txt_Id);
		experience = (TextView) findViewById(R.id.txt_Experience);
		edit = (TextView) findViewById(R.id.txt_Edit);

		inactive = (TextView) findViewById(R.id.txt_InActive);
	}

	class webservicrs extends AsyncTask<Void, Void, Void> {
		String obj;
		String res;

		@Override
		protected Void doInBackground(Void... params) {

			try {
				obj = objInactiveEmployee.data(u_name, u_cell, u_exper, u_salary, u_date, u_desig, u_address, u_id,
						prviouse_id);
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
			u_id = id_card.getText().toString();
			u_date = date.getText().toString();
			u_desig = desig.getText().toString();
			u_salary = salary.getText().toString();
			u_exper = experience.getText().toString();
			prviouse_id = MainActivity.id_Cards.get(MainActivity.number).toString();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (res.equals("1")) {
				Intent i = new Intent(EditProfile.this, MainActivity.class);
				startActivity(i);

				Toast.makeText(getApplicationContext(), "User inactive successfully", Toast.LENGTH_LONG).show();

			} else {
				Toast.makeText(getApplicationContext(), "User  does not inactive successfully.Please try again",
						Toast.LENGTH_LONG).show();
			}

		}
	}

}
