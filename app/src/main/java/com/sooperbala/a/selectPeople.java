package com.sooperbala.a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class selectPeople extends AppCompatActivity {

    ImageView imPerson;
    TextView tvName, tvNum;

    ArrayList<People> arOfPeople;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_people);

        tvName = (TextView) findViewById(R.id.tvName);
        tvNum = (TextView) findViewById(R.id.tvNum);
        imPerson = (ImageView) findViewById(R.id.imPeople);

        DBHelper db = new DBHelper(this);

        arOfPeople = db.getAllPeople();


        imPerson.setImageBitmap(BitmapUtility.getImage(arOfPeople.get(0).getPic()));
        imPerson.setTag(0);

        tvName.setText(arOfPeople.get(0).getName());
        tvNum.setText((arOfPeople.get(0).getNum()));


    }

    public void next(View view) {
    if( i < (arOfPeople.size()-1) ) {
        i = Integer.parseInt(imPerson.getTag().toString()) + 1;
        imPerson.setImageBitmap(BitmapUtility.getImage(arOfPeople.get(i).getPic()));
        tvName.setText(arOfPeople.get(i).getName());

        tvNum.setText((arOfPeople.get(i).getNum()));
        imPerson.setTag(i);
    }
    }

    public void prev(View view) {
        if (i != 0) {
            i = Integer.parseInt(imPerson.getTag().toString()) - 1;
            imPerson.setImageBitmap(BitmapUtility.getImage(arOfPeople.get(i).getPic()));
            tvName.setText(arOfPeople.get(i).getName());
            tvNum.setText((arOfPeople.get(i).getNum()));
            imPerson.setTag(i);
        }
    }


}
