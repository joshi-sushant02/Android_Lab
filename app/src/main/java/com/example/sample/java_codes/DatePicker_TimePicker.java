package com.example.sample.java_codes;

import com.example.sample.R;
import com.example.sample.code;
import com.example.sample.xml_codes.JAVACODE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.OffsetTime;
import java.util.Calendar;
import java.util.Date;

public class DatePicker_TimePicker extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextView date;
    int hour;
    Button btime;
    Button btime2;
   String jcode= JAVACODE.dtimeJcode;
   String xcode= JAVACODE.dtimeXcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_timepicker);
        date = findViewById(R.id.showDate);
        Button btdate = findViewById(R.id.picker);

        btime = findViewById(R.id.btime);
        btime2 = findViewById(R.id.btime2);
        btdate.setOnClickListener(btdateListener);
        btime.setOnClickListener(btimeListener);
        btime.setOnClickListener(btime2Listener);
    }

    View.OnClickListener btdateListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

//                 DatePickerDialog dateDialog= new DatePickerDialog(DatePicker.this,  DatePicker.this, Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
            showDate();

        }
    };
    View.OnClickListener btimeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TimePickerDialog tdialog = new TimePickerDialog(DatePicker_TimePicker.this, DatePicker_TimePicker.this, Time.HOUR, Time.MINUTE, true);
            tdialog.show();

        }
    };View.OnClickListener btime2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TimePickerDialog tdialog2 = new TimePickerDialog(DatePicker_TimePicker.this, android.R.style.Theme_Holo_Light_Dialog ,DatePicker_TimePicker.this, Time.HOUR, Time.MINUTE, true);
            tdialog2.show();

        }
    };


    private void showDate() {
        DatePickerDialog dateDialog = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DATE));

        dateDialog.show();
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
        String datee = i2 + "/" + i1 + "/" + i;
        date.setText(datee);
        btime2.setText(datee);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        btime.setText(i + ":" + i1);
    }


    public void getcode(View v){
        String tag= v.getTag().toString();
        switch (tag){
            case "java":
                Intent i1= new Intent(DatePicker_TimePicker.this, code.class);
                i1.putExtra("code",jcode);
                startActivity(i1);
                break;
            case "xml":
                Intent i2= new Intent(DatePicker_TimePicker.this, code.class);
                i2.putExtra("code",xcode);
                startActivity(i2);
                break;
        }
    }
}






