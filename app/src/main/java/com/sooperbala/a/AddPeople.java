package com.sooperbala.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.sooperbala.a.BitmapUtility.getBytes;

public class AddPeople extends AppCompatActivity {

    ImageView imperson ;
    EditText etName;
    EditText etNum;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);

        imperson = (ImageView) findViewById(R.id.imageView);
        etName = (EditText) findViewById(R.id.name);
        etNum = (EditText) findViewById(R.id.mobile);
    }

    public void addImg(View view){

        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, 5);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
                //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                bmp = BitmapFactory.decodeStream(bufferedInputStream);
                imperson.setImageBitmap(bmp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void addAll(View view){


        String name = etName.getText().toString();
        String num = etNum.getText().toString();
        DBHelper db = new DBHelper(this);



        Toast.makeText(this,String.valueOf(db.insertContact(name,num,getBytes(bmp))),Toast.LENGTH_LONG).show();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        Toast.makeText(this,"Added Successfully",Toast.LENGTH_SHORT).show();
    }

}
