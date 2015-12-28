package com.example.facebook.slideoutmenu;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ReceiveData {
	String result;
	public ReceiveData(){
		
	}
       public String receiveData(){
    	   try {
    		   
    		   HttpClient httpCllient = new DefaultHttpClient();
    		   HttpGet httpGet = new HttpGet("http://192.168.1.4/myphp/receive.php");
    		   HttpResponse httpResponse = httpCllient.execute(httpGet);
    		   HttpEntity httpEntity = httpResponse.getEntity();
    		   result  =EntityUtils.toString(httpEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   
		return result;
       }
	
	
   }