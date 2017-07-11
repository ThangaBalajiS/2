package com.sooperbala.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

public class React extends AppCompatActivity {

    Intent in;
    SharedPreferences sharedpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_react);
        in = getIntent();

    }

    public void happy(View view){


        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.c2);
        mPlayer.start();
        sharedpref = getPreferences(Context.MODE_PRIVATE);
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, " I\'m Feeling Happy now :)", null, null);
        }
    }
    public void sad(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.c1);
        mPlayer.start();
        sharedpref = getPreferences(Context.MODE_PRIVATE);
        Log.i("appinfo",String.valueOf(Settings.smsal));
        if(Settings.smsal) {
            Log.i("appinfo",String.valueOf(Settings.smsal));
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "I\'m Not feeling Okay :(", null, null);
        }
    }
    public void angry(View view){

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.c3);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "Attention Required!", null, null);
        }
    }
    public void hungry(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.c4);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "I\'m feeling Hungry :(", null, null);
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
