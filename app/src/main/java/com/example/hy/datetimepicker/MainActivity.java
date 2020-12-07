package com.example.hy.datetimepicker;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnTime;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate= findViewById(R.id.btnDate);
        btnTime=findViewById(R.id.btnTime);
        tvShow=findViewById(R.id.textView);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar myCalendar=Calendar.getInstance();
                int d,m,y;

                myCalendar.setTimeInMillis(System.currentTimeMillis());

                y=myCalendar.get(Calendar.YEAR);
                m=myCalendar.get(Calendar.MONTH);
                d=myCalendar.get(Calendar.DAY_OF_MONTH);

                tvShow.setText(""+d+"/"+m+"/"+y);   // showing current date of the day

                //showing datePickerDialog
                DatePickerDialog datePickerDialog =new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        String date=dayOfMonth+"/"+month+"/"+year;
                        tvShow.setText(""+date);   //showing date after selection from dialog
                    }
                },y,m,d);

                datePickerDialog.show();  //showing datePickerdialog

            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar=Calendar.getInstance();

                calendar.setTimeInMillis(System.currentTimeMillis());

                int h=calendar.get(Calendar.HOUR_OF_DAY);
                int minute=calendar.get(Calendar.MINUTE);
                final int s=calendar.get(Calendar.SECOND);
                tvShow.setText(""+h+":"+minute+":"+s); // showing current time

                //showing timePickerDialog
                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String time=hourOfDay+":"+minute+":"+s;
                        tvShow.setText(""+time);     //showing time after selection from dialog

                    }
                },h,minute,false);

                timePickerDialog.show();  //showing timePickerdialog
            }
        });
    }
}
