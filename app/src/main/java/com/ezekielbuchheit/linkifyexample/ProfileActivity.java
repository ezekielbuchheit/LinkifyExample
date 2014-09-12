package com.ezekielbuchheit.linkifyexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ezekielbuchheit on 9/7/14.
 */
public class ProfileActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView linkText = (TextView) findViewById(R.id.profile_activity_text);

        Uri data = getIntent().getData();
        if (data != null) {
            String parsedMessage = data.toString().substring(MyActivity.PROFILE_SCHEME.length());
            linkText.setText("Message: " + parsedMessage);
        }
    }
}
