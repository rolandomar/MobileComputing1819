package com.example.fragments;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements PlusOneFragment.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.addListener(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
        //Log.v("Tag:",newFragment.getCalendar().toString());
        //newFragment.

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        Log.v("Tag: Calendar",calendar.toString());
    }
}
