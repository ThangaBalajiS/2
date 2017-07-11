package com.sooperbala.a;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Need extends AppCompatActivity {

    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need);

        Intent in = getIntent();
        num = in.getStringExtra("num");

    }

    public void goFood(View view){
        Intent i = new Intent(this,Foods.class);
        i.putExtra("num",num);
        startActivity(i);
    }
    public void goOut(View view){
        Intent i = new Intent(this,Outing.class);
        i.putExtra("num",num);
        startActivity(i);
    }
    public void React(View view){
        Intent i = new Intent(this,React.class);
        i.putExtra("num",num);
        startActivity(i);
    }
    public void goGame(View view){
        Intent i = new Intent(this,Game.class);
        i.putExtra("num",num);
        startActivity(i);
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