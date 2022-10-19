package com.example.sample.java_codes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sample.R;
import com.example.sample.databinding.ActivitySqliteBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class SQLite extends AppCompatActivity {
ActivitySqliteBinding sqliteBinding;
SQLiteDatabase sqLiteDatabase;
boolean isCreated=true;
ContentValues name1;
HashMap<String,String>map= new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   sqliteBinding= ActivitySqliteBinding.inflate(getLayoutInflater());
        setContentView(sqliteBinding.getRoot());

    }
    public void insert(View v){
       sqLiteDatabase= openOrCreateDatabase("me",MODE_PRIVATE,null);
       if(sqLiteDatabase!=null){
           sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS teachers (id integer NOT NULL PRIMARY KEY AUTOINCREMENT, name varchar) ");
           name1 = new ContentValues();
           name1.put("name",sqliteBinding.editTextTextPersonName.getText().toString());
           sqLiteDatabase.insert("teachers",null,name1);
           sqliteBinding.editTextTextPersonName.setText("");
           Toast.makeText(this, "Inserted successfully", Toast.LENGTH_SHORT).show();
           Toast.makeText(this, "Table created", Toast.LENGTH_SHORT).show();
       }
       else if(sqLiteDatabase==null){
           Toast.makeText(this, "unable to connect to db", Toast.LENGTH_SHORT).show();
       }else{

       }
    }

    public void show(View v){
        sqLiteDatabase= openOrCreateDatabase("me",MODE_PRIVATE,null);
        File dbFile = getDatabasePath("me");
        System.out.println(dbFile.getAbsoluteFile());
        Cursor c=sqLiteDatabase.rawQuery("select * from teachers",null);
        String allvalues=
"";        if (c.moveToFirst()){
            do {
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                allvalues+=column1+":"+column2+"\n";
            } while(c.moveToNext());
        }
        Toast.makeText(this, allvalues, Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){
        sqLiteDatabase= openOrCreateDatabase("me",MODE_PRIVATE,null);
        String[] s={sqliteBinding.editTextTextPersonName.getText().toString()};

        sqLiteDatabase.delete("teachers","name=?" ,s);


        Toast.makeText(this, "all rows deleted", Toast.LENGTH_SHORT).show();
    }
    public void update(View v){
        sqLiteDatabase= openOrCreateDatabase("me",MODE_PRIVATE,null);
        sqLiteDatabase.delete("teachers",null,null);

        Toast.makeText(this, name1+"deleted", Toast.LENGTH_SHORT).show();
    }
}