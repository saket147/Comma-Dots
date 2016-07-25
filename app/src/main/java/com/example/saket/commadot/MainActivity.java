package com.example.saket.commadot;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity
{
    String []animals={"dog","zebra","human","cow","fox"};
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    Context context;
    Button b1,b2,b3;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getBaseContext();
        multiAutoCompleteTextView=(MultiAutoCompleteTextView)findViewById(R.id.multi);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        b3=(Button)findViewById(R.id.btn3);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,animals);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextView.setThreshold(2);
        multiAutoCompleteTextView.setAdapter(adapter);
         mediaPlayer=MediaPlayer.create(context,R.raw.sample);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mediaPlayer!=null && !mediaPlayer.isPlaying())
                    mediaPlayer.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                getCurrentFocus();

            }
        });
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(context,NewMainActivity.class);
                startActivity(intent);

            }
        });
    }
}
