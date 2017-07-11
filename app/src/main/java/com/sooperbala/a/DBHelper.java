package com.sooperbala.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by bala on 15-06-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "balabase";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table people " +
                        "(num text primary key, name text, image blob)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS people");
        onCreate(sqLiteDatabase);
    }

    public boolean insertContact (String name,String num,byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("num",num);
        contentValues.put("image",image);
        db.insert("people", null, contentValues);
        return true;
    }



    public ArrayList<People> getAllPeople() {
        ArrayList<People> array_list = new ArrayList<>();

        int j = 0;



        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i(TAG, "getAllPeople: im here");
        Cursor res =  db.rawQuery( "select * from people", null );
        res.moveToFirst();



        Log.i(TAG, "getAllPeople: im here");

        while(!res.isAfterLast()){


            array_list.add(new People());
            array_list.get(j).setName(res.getString(res.getColumnIndex("name")));
            array_list.get(j).setNum(res.getString(res.getColumnIndex("num")));
            array_list.get(j).setPic(res.getBlob(res.getColumnIndex("image")));
            res.moveToNext();
            j+=1;
        }
        return array_list;
    }



}
