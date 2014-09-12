package com.ezekielbuchheit.linkifyexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyActivity extends Activity {

    static final String VIDEO_TEXT = "Quentin posted a new video!";
    static final String PROFILE_TEXT = "Lucas liked Quentin's video!";
    static final String EXTERNAL_TEXT = "Exciting new Zelda Wii U details!";

    public static final String VIDEO_SCHEME = "com.videoscheme.example:\\";
    public static final String PROFILE_SCHEME = "com.profilescheme.example:\\";
    public static final String EXTERNAL_SCHEME = "http://zelda.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        TextView videoLink = (TextView) findViewById(R.id.link_to_video);
        videoLink.setText(VIDEO_TEXT);

        TextView profileLink = (TextView) findViewById(R.id.link_to_profile);
        profileLink.setText(PROFILE_TEXT);

        TextView externalLink = (TextView) findViewById(R.id.link_to_zelda);
        externalLink.setText(EXTERNAL_TEXT);

        Pattern videoPattern = Pattern.compile("video");
        Pattern quentinOrGeorge = Pattern.compile("Quentin|Lucas");
        Pattern externalPattern = Pattern.compile("Zelda");

        Linkify.TransformFilter videoLinkTransformFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "Transformed!";
            }
        };

        Linkify.TransformFilter externalLinkFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "";
            }
        };

        Linkify.addLinks(videoLink, videoPattern, VIDEO_SCHEME, null, videoLinkTransformFilter);
        Linkify.addLinks(videoLink, quentinOrGeorge, PROFILE_SCHEME);

        Linkify.addLinks(profileLink, quentinOrGeorge, PROFILE_SCHEME);
        Linkify.addLinks(profileLink, videoPattern, VIDEO_SCHEME);

        Linkify.addLinks(externalLink, externalPattern, EXTERNAL_SCHEME, null, externalLinkFilter);
    }
}
