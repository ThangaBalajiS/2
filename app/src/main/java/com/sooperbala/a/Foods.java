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

public class Foods extends AppCompatActivity {

    Intent in;
    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        in = getIntent();
        sharedpref = this.getPreferences(Context.MODE_PRIVATE);
    }

    public void water(View view){


        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.b1);
        mPlayer.start();

        if(Settings.smsal) {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "I Need Water :)", null, null);
            Log.i("appinfo", "water: ");
        }
        Log.i("appinfo", "water: out");
    }
    public void snacks(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.b2);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, " I Need Snacks :)", null, null);
        }
    }
    public void soru(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.b3);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, "I Need to have food :(", null, null);
        }
    }
    public void juice(View view){
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.b4);
        mPlayer.start();
        if(Settings.smsal) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(in.getStringExtra("num"), null, " It\'ll be good to have a juice :)", null, null);
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
