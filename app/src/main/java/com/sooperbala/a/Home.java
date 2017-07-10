package com.sooperbala.a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ImageView imp1,imp2,imp3,imp4,imp5,imp6;
    ArrayList<People> peopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imp1 = (ImageView) findViewById(R.id.imp1);
        imp2 = (ImageView) findViewById(R.id.imp2);
        imp3 = (ImageView) findViewById(R.id.imp3);
        imp4 = (ImageView) findViewById(R.id.imp4);
        imp5 = (ImageView) findViewById(R.id.imp5);
        imp6 = (ImageView) findViewById(R.id.imp6);

        DBHelper db = new DBHelper(this);

        peopleList =  db.getAllPeople();

        imp1.setImageBitmap(BitmapUtility.getImage(peopleList.get(0).getPic()));
        imp2.setImageBitmap(BitmapUtility.getImage(peopleList.get(1).getPic()));
        imp3.setImageBitmap(BitmapUtility.getImage(peopleList.get(2).getPic()));
        imp4.setImageBitmap(BitmapUtility.getImage(peopleList.get(3).getPic()));
        imp5.setImageBitmap(BitmapUtility.getImage(peopleList.get(4).getPic()));
        imp6.setImageBitmap(BitmapUtility.getImage(peopleList.get(5).getPic()));


    }
}
