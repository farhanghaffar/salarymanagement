/* Created by Srikanth gr.
 */

package com.example.facebook.slideoutmenu;

import com.example.Profile.CreateNew_User;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

//Right Menu
public class RightMenuFragment extends Fragment {
	Button btn_NewUser, btn_InactiveUser;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.rightmenu, container, false);
		btn_NewUser = (Button) view.findViewById(R.id.new_user);
		btn_NewUser.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), CreateNew_User.class);

				startActivity(i);

			}
		});
		btn_InactiveUser = (Button) view.findViewById(R.id.inactive_user);
		btn_InactiveUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), InactiveSingleDetails.class);
				startActivity(i);
				
			}
		});

		return view;// inflater.inflate(R.layout.rightmenu, container, false);

	}

}
