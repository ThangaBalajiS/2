package com.sooperbala.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Switch st;
    static boolean smsal = false;
    SharedPreferences sharedpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedpref = this.getPreferences(Context.MODE_PRIVATE);

        st = (Switch) findViewById(R.id.switch1);
        if(sharedpref.getBoolean("smsal",false)){
            st.setChecked(true);
        }

        st.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i("appinfo",String.valueOf(sharedpref.getBoolean("smsal",false)));
                if(b){
                    smsal = true;
                    SharedPreferences.Editor editor = sharedpref.edit();
                    editor.putBoolean("smsal", smsal );
                    editor.apply();
                }else{
                    smsal = false;
                    SharedPreferences.Editor editor = sharedpref.edit();
                    editor.putBoolean("smsal", smsal );
                    editor.apply();
                }
                Log.i("appinfo",String.valueOf(sharedpref.getBoolean("smsal",false)));

            }
        });
    }

    public void adPeople(View view){
        Intent intent = new Intent(this,AddPeople.class);
        startActivity(intent);
    }

}
