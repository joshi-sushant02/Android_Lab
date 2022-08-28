package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.sample.java_codes.AllLayouts;
import com.example.sample.java_codes.Arithmatics;
import com.example.sample.java_codes.DatePicker_TimePicker;
import com.example.sample.java_codes.Fragments;
import com.example.sample.java_codes.Checkbox;
import com.example.sample.java_codes.Intents;
import com.example.sample.java_codes.RadioButtons;
import com.example.sample.java_codes.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androids_list);
        getSupportActionBar().hide();

    }

    public void onListItemClick(View v) {
        Intent intent;
        String id = String.valueOf( v.getTag());
        System.out.println(id);
        switch (id) {
            case "6":
                intent = new Intent(MainActivity.this, Intents.class);

                break;
            case "1":
                intent = new Intent(MainActivity.this, AllLayouts.class);

                break;
            case "2":
                intent = new Intent(MainActivity.this, Arithmatics.class);

                break;
            case "3":
                intent = new Intent(MainActivity.this, Spinner.class);

                break;
            case "4":
                intent = new Intent(MainActivity.this, Checkbox.class);

                break;
            case "5":
                intent = new Intent(MainActivity.this, RadioButtons.class);

                break;
            case "7":
                intent = new Intent(MainActivity.this, DatePicker_TimePicker.class);

                break;
            default:
                intent= new Intent(MainActivity.this,MainActivity.class);

                break;
        }
        startActivity(intent);
    }
}


//package com.example.sample;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.ComponentName;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.example.sample.codess.Area;
//import com.example.java_codes.Arithmatics;
//import com.example.sample.java_codes.Checkbox;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//String list[]= {"Layouts","Arithmatics","Area","checkBox"," RadioButton","Alert DialogBox","Spinner","Intents"};
//String classes[]={"Area","Arithmatics","Checkbox"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.scrap1);
//        ArrayList<Object>classes1= new ArrayList<>();
//        classes1.add(new Arithmatics());
//        classes1.add(new Area());
//        classes1.add(new Checkbox());
//        ListView listView= findViewById(R.id.chapters);
//        ArrayAdapter<String>arrayAdapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,list);
//        listView.setAdapter(arrayAdapter);
//listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.example.java_codes","com.example.java_codes.Arithmatics"));
//
////        Intent intent2=new Intent(MainActivity.this,Arithmatics.class);
//        startActivity(intent);
//    }
//});
//    }
//
//
//}