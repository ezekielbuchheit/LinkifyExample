package com.ezekielbuchheit.linkifyexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class VideoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        TextView linkText = (TextView) findViewById(R.id.video_activity_text);

        Uri data = getIntent().getData();
        if (data != null) {
            String parsedMessage = data.toString().substring(MyActivity.VIDEO_SCHEME.length());
            linkText.setText("Message: " + parsedMessage);
        }
    }
}
