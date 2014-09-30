package com.codepath.hughhn.simplechat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ChatActivity extends Activity {

	private static String userId;
	private Button btnSend;
	private EditText etChat;

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
        
        setUpChat();
    }

    private void setUpChat() {
    	etChat = (EditText) findViewById(R.id.etChat);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ParseObject messages = new ParseObject("messages");
				messages.put("messages", etChat.getText().toString());
				messages.saveInBackground(new SaveCallback() {

					@Override
					public void done(ParseException e) {
						Log.d("DEBUG", "Chat message saved!");
						// TODO Auto-generated method stub
						if (e != null) {
							e.printStackTrace();
						}

					}

				});
				
			}
		});
		
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
