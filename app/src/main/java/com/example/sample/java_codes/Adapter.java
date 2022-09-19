package com.example.sample.java_codes;
import com.example.sample.R;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.Spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
String str[]={"abcd","gcxgs","chgvdhc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        ImageView imf= findViewById(R.id.adpt_get_javacode);
        Spinner spinner= (Spinner) findViewById(R.id.spin);
        Spinner spinnerCountShoes=findViewById(R.id.spin2);
        ArrayAdapter<String> spinnerCountShoesArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.shoes));
        spinnerCountShoes.setAdapter(spinnerCountShoesArrayAdapter);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,str);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Selected Item is:"+str[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}