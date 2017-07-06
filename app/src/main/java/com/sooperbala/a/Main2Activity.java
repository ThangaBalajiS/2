package com.sooperbala.a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView pic = (ImageView) findViewById(R.id.imageView2);

        DBHelper db = new DBHelper(this);

        //pic.setImageBitmap(getImage(db.giveImage()));

    }
}
