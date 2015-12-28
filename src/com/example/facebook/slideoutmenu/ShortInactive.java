/* Created by Srikanth gr.
 */

package com.example.facebook.slideoutmenu;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.Profile.EditProfile;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ShortInactive extends Activity {

	// Declare
	private GestureDetector gesturedetector = null;
	private LinearLayout slidingPanel;
	private boolean isExpanded;
	private DisplayMetrics metrics;
	private RelativeLayout headerPanel;
	private int panelWidth;
	private int panelWidth1;
	boolean checked = true;
	private ImageView menuViewButton, menuRightButton;

	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	public static List name_list;
	public static List desig;
	public static List cell;
	public static List id_Cards;
	public	static List experience;
	public static List salary;
	public static List Join_date;
	public static List address;
	ListView employeeList;
	ReceiveData receiveData;
public static int number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layer_stack);
		
		employeeList = (ListView) findViewById(R.id.main_list);
		// String[] str = { "farhan", "Adnan", "Mohsan", "Rahat", "ali", "usama"
		// };
		// String[] desig = { "Android", "QA", ".Net", "Java", "PHP", "IOS" };
		name_list = new ArrayList();
		desig = new ArrayList();
		cell = new ArrayList();
		id_Cards = new ArrayList();
		experience = new ArrayList();
		salary = new ArrayList();
		Join_date = new ArrayList();
		address = new ArrayList();
		receiveData = new ReceiveData();
		new webservices().execute();
		/*
		 * ArrayAdapter<String> arrayAdapter = new
		 * ArrayAdapter<String>(MainActivity.this,
		 * android.R.layout.simple_list_item_1, str);
		 */
		// CustomListAdapter arrayAdapter = new
		// CustomListAdapter(MainActivity.this, str, desig);
		// employeeList.setAdapter(arrayAdapter);
		employeeList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int item = (int) parent.getItemIdAtPosition(position);
				String p = String.valueOf(item);
				Intent intent  = new Intent(getApplicationContext(), EditProfile.class);
				//intent.putExtra("inedx", p);
				number = Integer.parseInt(p);
				startActivity(intent);
				//Toast.makeText(getApplicationContext(), p, Toast.LENGTH_SHORT).show();

			}
		});

		// Initialize
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * -0.75);
		panelWidth1 = (int) ((metrics.widthPixels) * 0.75);

		headerPanel = (RelativeLayout) findViewById(R.id.header);
		headerPanelParameters = (LinearLayout.LayoutParams) headerPanel.getLayoutParams();
		headerPanelParameters.width = metrics.widthPixels;
		headerPanel.setLayoutParams(headerPanelParameters);

		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		gesturedetector = new GestureDetector(new MyGestureListener());
		slidingPanel.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				gesturedetector.onTouchEvent(event);

				// this command hide keyboard
				/*
				 * getWindow() .setSoftInputMode(
				 * WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
				 * 
				 * InputMethodManager imm = (InputMethodManager)
				 * getSystemService(getApplication().INPUT_METHOD_SERVICE);
				 * imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				 */
				return true;
			}
		});
		// Slide the Panel
		/*
		 * menuRightButton = (ImageView) findViewById(R.id.menuViewButton);
		 * menuRightButton.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { if (!isExpanded) { isExpanded
		 * = true; // Expand
		 * 
		 * FragmentManager fragmentManager = getFragmentManager();
		 * 
		 * FragmentTransaction fragmentTransaction = fragmentManager
		 * .beginTransaction(); fragmentTransaction.replace(R.id.menuPanel, new
		 * LeftMenuFragment()); fragmentTransaction.commit(); new
		 * ExpandAnimation(slidingPanel, panelWidth1,
		 * Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.75f,
		 * 0, 0.0f, 0, 0.0f);
		 * 
		 * } else { isExpanded = false; // Collapse
		 * 
		 * new CollapseAnimation(slidingPanel, panelWidth1,
		 * TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
		 * TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);
		 * 
		 * } } });
		 */
		menuViewButton = (ImageView) findViewById(R.id.menuRightButton);
		menuViewButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!isExpanded) {
					isExpanded = true;
					checked = false;
					// Expand

					FragmentManager fragmentManager = getFragmentManager();

					FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.menuPanel, new RightMenuFragment());
					fragmentTransaction.commit();
					new ExpandAnimation(slidingPanel, panelWidth, Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -0.75f, 0, 0.0f, 0, 0.0f);

				} else {
					isExpanded = false;
					checked = true;
					// Collapse
					new CollapseAnimation(slidingPanel, panelWidth, TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
							TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

				}
			}
		});
	}

	protected InputMethodManager getSystemService(OnTouchListener onTouchListener) {
		// TODO Auto-generated method stub
		return null;
	}

	protected InputMethodManager getSystemService(OnClickListener onClickListener) {
		// TODO Auto-generated method stub
		return null;
	}

	public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

			int SWIPE_THRESHOLD = 100;
			int SWIPE_VELOCITY_THRESHOLD = 100;
			boolean result = false;
			try {
				float diffY = e2.getY() - e1.getY();
				float diffX = e2.getX() - e1.getX();
				if (Math.abs(diffX) > Math.abs(diffY)) {
					if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
						if (diffX > 0) {
							onSwipeRight();
							Log.d("Check", "-----right");
						} else {
							onSwipeLeft();
							Log.d("Check", "-----left");
						}
					}
					result = true;
				} else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
					if (diffY > 0) {
						onSwipeBottom();
					} else {
						onSwipeTop();
					}
				}
				result = true;

			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return result;

		}

	}

	public void onSwipeRight() {

		if (isExpanded == false) {

		} else {
			isExpanded = false;
			checked = true;
			// Collapse
			new CollapseAnimation(slidingPanel, panelWidth, TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

		}

	}

	public void onSwipeLeft() {

		if (!isExpanded) {
			isExpanded = true;

			new CollapseAnimation(slidingPanel, panelWidth, TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);
			FragmentManager fragmentManager = getFragmentManager();

			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.menuPanel, new RightMenuFragment());
			fragmentTransaction.commit();
			new ExpandAnimation(slidingPanel, panelWidth, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
					-0.75f, 0, 0.0f, 0, 0.0f);

		}
	}

	public void onSwipeTop() {

	}

	public void onSwipeBottom() {

	}

	class webservices extends AsyncTask<Void, Void, Void> {
		String obj;
		String check ;
		@Override
		protected Void doInBackground(Void... params) {

			try {
				obj = receiveData.receiveData();
				JSONObject jsonobject = new JSONObject(obj);
				JSONArray Jsonarray = jsonobject.getJSONArray("employee");
				for (int i = 0; i < Jsonarray.length(); i++) {
					JSONObject obj = Jsonarray.getJSONObject(i);
					check= obj.getString("work");
					if (check.equals("inactive")) {
						
					
					String name = obj.getString("name");
					name_list.add(name);
					String designaition = obj.getString("designaition");
					desig.add(designaition);
					String c_s = obj.getString("c_salary");
					salary.add(c_s);
					String add = obj.getString("address");
					address.add(add);
					String exper  = obj.getString("experience");
					experience.add(exper);
					String phone = obj.getString("phone");
					cell.add(phone);
					String id = obj.getString("id_no");
					id_Cards.add(id);
					String date = obj.getString("join_date");
					Join_date.add(date);
					Log.d("Result", name);
					}
				}
				Log.d("Result", obj);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			super.onPostExecute(result);
			String[] name = new String[name_list.size()];
			String[] designaition = new String[desig.size()];
			for (int i = 0; i < designaition.length; i++) {

				name[i] = (String) name_list.get(i);
				designaition[i] = desig.get(i).toString();
			}
			CustomListAdapter arrayAdapter = new CustomListAdapter(ShortInactive.this, name, designaition);
			employeeList.setAdapter(arrayAdapter);
		}

	}
}
