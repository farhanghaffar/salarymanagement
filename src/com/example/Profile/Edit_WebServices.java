package com.example.Profile;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Edit_WebServices {

	public Edit_WebServices() {

	}

	public static String data(String name,String cell,String experience,String c_salary,
			String join_date,String desig, String address,String idcard,String key) {
		//
		String response = "";

		ArrayList<NameValuePair> list = new ArrayList();
		try {
			HttpClient httpClient = new DefaultHttpClient();
		//	HttpPost httpPost = new HttpPost("http://10.0.2.2/deliverysystem/order/add");
			HttpPost httpPost = new HttpPost("http://192.168.1.4/myphp/update.php");
			list.add(new BasicNameValuePair("name", name));
			list.add(new BasicNameValuePair("cell", cell));
			list.add(new BasicNameValuePair("experience", experience));
			list.add(new BasicNameValuePair("c_salary", c_salary));
			list.add(new BasicNameValuePair("join_date", join_date));
			list.add(new BasicNameValuePair("desig", desig));
			list.add(new BasicNameValuePair("address", address));
			list.add(new BasicNameValuePair("id_card", idcard));
			list.add(new BasicNameValuePair("key", key));
			httpPost.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity);
			Log.d("Response----", response);

		} catch (Exception e) {
			Log.d("Execption----", "result----" + e.toString());
			e.printStackTrace();
		
		}

		return response;

	}

}
