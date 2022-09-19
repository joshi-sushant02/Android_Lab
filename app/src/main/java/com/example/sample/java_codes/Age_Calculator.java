package com.example.sample.java_codes;
import com.example.sample.R;
import com.example.sample.code;
import com.example.sample.xml_codes.JAVACODE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Age_Calculator extends AppCompatActivity {
    Button b1,b2,b3;
    TextView t1,t2;
    String jcode= JAVACODE.AgeJCode;
    String xcode=JAVACODE.AgeXCode;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
        b1= findViewById(R.id.bd);
        b2= findViewById(R.id.td);
        b3= findViewById(R.id.age);
        t1= findViewById(R.id.bdate);
        t2= findViewById(R.id.ans);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

        int year= Calendar.getInstance().get(Calendar.YEAR);
        int month= Calendar.getInstance().get(Calendar.MONTH);
        int date= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        String today=sdf.format(Calendar.getInstance().getTime());
        b2.setText(today);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dp= new DatePickerDialog(Age_Calculator.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int m=i1+1;
                         String datee = i2+"/"+m+"/"+i;
                        t1.setText(datee);

                    }
                }, year,month,date);
                dp.show();
            }
        });

b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        try {
            Date d1= sdf.parse(today);
            Date d2= sdf.parse(t1.getText().toString());
            long d11= d1.getTime();
            long d22= d2.getTime();
            if(d11>=d22) {
                System.out.println("i was here");
                org.joda.time.Period p = new Period(d11, d22, PeriodType.yearMonthDay());
                int year=p.getYears();
                int month=p.getMonths();
                int day=p.getDays();
                t2.setText( year +" Years" + month + " months"+day+"days");

            }else
            {
                t2.setText( "invalid");
                System.out.println(" iwas in else");
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
});
    }

    public void viewCode(View v) {
        String tag = v.getTag().toString();

        switch (tag) {
            case "java":
                Intent i1 = new Intent(Age_Calculator.this, code.class);
                i1.putExtra("code", jcode);
                startActivity(i1);
                break;
            case "xml":
                Intent i2 = new Intent(Age_Calculator.this, code.class);
                i2.putExtra("code", xcode);
                startActivity(i2);
                break;
        }
    }
}