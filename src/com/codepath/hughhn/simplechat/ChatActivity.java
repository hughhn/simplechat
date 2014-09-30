package com.codepath.hughhn.simplechat;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ChatActivity extends Activity {

	private static String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
          userId = ParseUser.getCurrentUser().getObjectId();
        } else {
        	login();
        }
    }

    private void login() {
    	ParseAnonymousUtils.logIn(new LogInCallback() {
    		  @Override
    		  public void done(ParseUser user, ParseException e) {
    		    if (e != null) {
    		      Log.d("MyApp", "Anonymous login failed.");
    		    } else {
    		      ChatActivity.this.userId = user.getObjectId();
    		    }
    		  }
    		});
    }
}
