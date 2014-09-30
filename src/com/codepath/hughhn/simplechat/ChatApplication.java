package com.codepath.hughhn.simplechat;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class ChatApplication extends Application {
	public static final String YOUR_APPLICATION_ID = "xclOs7U9O3xZ3SfCViGJDDZ6Bg09t8tAprmPp58i";
	public static final String YOUR_CLIENT_KEY = "3ftLL5u2rS9x59UelvoNg1kDN169QT50WXL2X09e";

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

		
	}
}
