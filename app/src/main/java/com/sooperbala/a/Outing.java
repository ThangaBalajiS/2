package com.sooperbala.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;

public class Outing extends AppCompatActivity {

    Intent in;
    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outing);
        in = getIntent();
        sharedpref = this.getPreferences(Context.MODE_PRIVATE);

    }


    public void temple(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.d1);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "let\'s go to temple :)", null, null);
        }
    }
    public void park(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.d2);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "I would like to go to park :)", null, null);
        }
    }
    public void d3(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.d1);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "let\'s go to temple :)", null, null);
        }
    }
    public void d4(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.d2);
        mPlayer.start();
        if(Settings.smsal) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(in.getStringExtra("num"), null, "let\'s go to temple :)", null, null);
        }
    }



    public void yess(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.yes);
        mPlayer.start();
    }

    public void backit(View view){
        super.onBackPressed();
    }

    public void noo(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.no);
        mPlayer.start();
    }
}
