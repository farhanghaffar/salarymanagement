package com.example.facebook.slideoutmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListAdapter extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] itemname;
	private final String[] designiation;
	// private final Integer[] imgid;
	private Bitmap[] bmp;

	public CustomListAdapter(Activity context, String[] itemname, String[] designiation) {
		super(context, R.layout.singllist, itemname);
		this.context = context;
		this.itemname = itemname;
		// this.imgid = imgid;
		this.designiation =designiation;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.singllist, null, true);

		TextView txtname = (TextView) rowView.findViewById(R.id.name);
		TextView txtposition = (TextView) rowView.findViewById(R.id.position);
	

		txtname.setText(itemname[position]);
		txtposition.setText(designiation[position]);;

		return rowView;

	};
}
