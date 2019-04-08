package com.example.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {

    Calendar mCalendar = null;
    DatePickerDialog.OnDateSetListener mListener = null;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    void addListener(DatePickerDialog.OnDateSetListener listener){
        mListener = listener;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        mCalendar = Calendar.getInstance();
        mCalendar.set(year,month,day);
        // Do something with the date chosen by the user
        //DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        if(mListener != null){
            mListener.onDateSet(view, year, month, day);
        }
    }
    public Calendar getCalendar(){
        return mCalendar;
    }
}
