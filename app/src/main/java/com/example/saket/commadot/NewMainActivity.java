package com.example.saket.commadot;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class NewMainActivity extends AppCompatActivity
{
    MediaController controller;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView=(VideoView)findViewById(R.id.video);
        Uri uri=Uri.parse("android.resource://package com.example.saket.commadot/"+ R.raw.sample2 );
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        controller=new MediaController(NewMainActivity.this);
        videoView.setMediaController(controller);
        videoView.start();


    }
}
