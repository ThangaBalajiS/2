package com.sooperbala.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class selectPeople extends AppCompatActivity {

    ImageView imPerson;
    TextView tvName, tvNum;
    SharedPreferences sharedpreferences ;

    ArrayList<People> arOfPeople;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_people);

        sharedpreferences = getPreferences(Context.MODE_PRIVATE);

        tvName = (TextView) findViewById(R.id.tvName);
        tvNum = (TextView) findViewById(R.id.tvNum);
        imPerson = (ImageView) findViewById(R.id.imPeople);

        try {
            DBHelper db = new DBHelper(this);


            arOfPeople = db.getAllPeople();


            imPerson.setImageBitmap(BitmapUtility.getImage(arOfPeople.get(0).getPic()));
            imPerson.setTag(0);

            tvName.setText(arOfPeople.get(0).getName());
            tvNum.setText((arOfPeople.get(0).getNum()));
        }catch (Exception e){

            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,AddPeople.class);
            startActivity(i);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);

        int a = (int) (Math.random()*10);
        int b = (int) (Math.random()*10);
        final int c = a + b;

        alert.setMessage(String.valueOf(a) + " + " + String.valueOf(b) +" = ?");
        alert.setTitle("solve to access settings");
        alert.setView(edittext);
        alert.setNeutralButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(edittext.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter Value",Toast.LENGTH_SHORT).show();
                }else {

                    if(Integer.parseInt(edittext.getText().toString()) == c){
                        Intent inte = new Intent(getApplicationContext(),Settings.class);
                        startActivity(inte);
                    }else{
                        Toast.makeText(getApplicationContext(),"Adult Supervision Required",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        alert.show();

        return super.onOptionsItemSelected(item);
    }

    public void proceed(View view){

        Intent in = new Intent(this,Need.class);
        in.putExtra("num", arOfPeople.get(i).getNum());
        startActivity(in);

    }


}
