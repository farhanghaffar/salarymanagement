package com.example.facebook.slideoutmenu;

import android.app.Activity;
import android.graphics.Paint.Join;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.TextView;

public class InactiveUser extends Activity {
	private GestureDetector gesturedetector = null;
	String u_name, u_cell, u_address, u_desig, u_salary, u_id, u_date, u_exper,id;
	TextView name, phone, salary, address, date, desig, id_card, experience, edit, inactive;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inactivedetails);
	}
	void init(){
		name = (TextView) findViewById(R.id.intxtName);
		phone = (TextView) findViewById(R.id.intxt_Phone);
		salary = (TextView) findViewById(R.id.intxtTotalSalary);
		address = (TextView) findViewById(R.id.intxt_Address);
		date = (TextView) findViewById(R.id.intxt_JoinDate);
		desig = (TextView) findViewById(R.id.intxt_Designiation);
		id_card = (TextView) findViewById(R.id.intxt_Id);
		experience = (TextView) findViewById(R.id.intxt_Experience);
	}
	void setValue(){
		u_name = (String) InactiveSingleDetails.name_list.get(InactiveSingleDetails.number);
		name.setText(u_name);
		u_cell = (String) InactiveSingleDetails.cell.get(InactiveSingleDetails.number);
		phone.setText(u_cell);
		u_salary = (String) InactiveSingleDetails.salary.get(InactiveSingleDetails.number);
		salary.setText(u_salary);
		u_address = (String) InactiveSingleDetails.address.get(InactiveSingleDetails.number);
		address.setText(u_address);
		u_date = (String) InactiveSingleDetails.Join_date.get(InactiveSingleDetails.number);
		date.setText(u_date);
		u_desig = (String) InactiveSingleDetails.desig.get(InactiveSingleDetails.number);
		desig.setText(u_desig);
		u_exper = (String) InactiveSingleDetails.experience.get(InactiveSingleDetails.number);
		experience.setText(u_exper);
		id = (String) InactiveSingleDetails.id_Cards.get(InactiveSingleDetails.number);
		id_card.setText(id);
		
	}
	
}
