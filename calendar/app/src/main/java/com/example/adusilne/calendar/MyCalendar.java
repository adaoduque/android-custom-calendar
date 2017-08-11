package com.example.adusilne.calendar;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.text.format.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by adao on 8/10/17.
 */

public class MyCalendar {
    private Context context;
    private ArrayList<DaysList> listDays;
    private Calendar cal;

    public MyCalendar( Context context ) {
        this.context  = context;
        this.listDays = new ArrayList<>();
        cal = GregorianCalendar.getInstance();
    }

    public String getMonthIn7Days( String date ) {

        String response = "";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date mDate = new Date();
        try {
            mDate = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        cal.setTime(mDate);
        for(int i = 0; i < 2; i++) {
            if( i > 0 )
                cal.add(Calendar.DAY_OF_YEAR, 6);
            else
                cal.add(Calendar.DAY_OF_YEAR, 0);

            Date getMes = cal.getTime();
            String mes =  (String) DateFormat.format("MMM", getMes);

            if( i == 1 ) {
                String ano = (String) DateFormat.format("yyyy", getMes);
                if( mes.compareTo( response ) != 0 )
                    response  += "/" + mes;
                response += " " + ano + "   ";
            }else {
                response = mes;
            }

        }

        return response;

    }

    public ArrayList<DaysList> getMoreSevenDays( String nextDate ) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        Date mDate = new Date();
        try {
            mDate = dateFormat.parse( nextDate );
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        cal.setTime(mDate);

        for(int i = 1; i <= 7; i++) {

            cal.add(Calendar.DAY_OF_YEAR, 1);

            Date date = cal.getTime();

            listDays.add(
                    new DaysList(
                            (String) DateFormat.format("dd",   date), //20
                            (String) DateFormat.format("MM",   date), // 06
                            (String) DateFormat.format("yyyy", date), // 2013
                            ((String) DateFormat.format("EEEE", date)).substring(0,3), // Thursday
                            (String) DateFormat.format("MMM", date), // Jun
                            (String) DateFormat.format("yyyy-MM-dd", date) // Full date
                    )
            );
        }

        return listDays;
    }

    public ArrayList<DaysList> getSevenDayAfterCurrentDate() {

        cal.setTime(new Date());
        for(int i = 1; i <= 7; i++) {
            if( i > 1 )
                cal.add(Calendar.DAY_OF_YEAR, 1);
            else
                cal.add(Calendar.DAY_OF_YEAR, 0);
            Date date = cal.getTime();
            listDays.add(
                    new DaysList(
                            (String) DateFormat.format("dd",   date), //20
                            (String) DateFormat.format("MM",   date), // 06
                            (String) DateFormat.format("yyyy", date), // 2013
                            ((String) DateFormat.format("EEEE", date)).substring(0,3), // Thursday
                            (String) DateFormat.format("MMM", date), // Jun
                            (String) DateFormat.format("yyyy-MM-dd", date) // Full date
                    )
            );
        }

        return listDays;

    }
}
