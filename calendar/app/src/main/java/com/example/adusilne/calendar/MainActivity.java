package com.example.adusilne.calendar;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.adusilne.calendar.adapter.RVDaysWeek;
import com.example.adusilne.calendar.componentes_custom.FontAwesomeTextView;
import com.example.adusilne.calendar.componentes_custom.OpenSansTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyCalendar calendar;
    private ArrayList<DaysList> listDays;
    private RVDaysWeek adapterDays;
    private RecyclerView mRecyclerView;
    private OpenSansTextView txtMonthAndYear;
    private Context context;
    private int countGeneratedDays = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context     =   getBaseContext();
        this.calendar    =   new MyCalendar( this.context );
        this.listDays    =   this.calendar.getSevenDayAfterCurrentDate();
        String monthYear =   this.calendar.getMonthIn7Days( this.listDays.get( 0 ).getFullDate() );

        final FontAwesomeTextView findNext = (FontAwesomeTextView) findViewById(R.id.iconApplyNext);
        final FontAwesomeTextView findPrev = (FontAwesomeTextView) findViewById(R.id.iconApplyPrev);
        txtMonthAndYear  =  (OpenSansTextView) findViewById(R.id.txtMonthAndYear);
        txtMonthAndYear.setText( monthYear );

        mRecyclerView     =  (RecyclerView) findViewById(R.id.cardView);
        this.adapterDays  =  new RVDaysWeek( this.context, this.listDays );
        this.mRecyclerView.setAdapter( this.adapterDays );
        this.mRecyclerView.setHasFixedSize(true);

        final LinearLayoutPagerManager MyLayoutManager = new LinearLayoutPagerManager(getApplication(), LinearLayoutManager.HORIZONTAL, false, 7 );

        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(MyLayoutManager);
        this.adapterDays.notifyDataSetChanged();

        this.mRecyclerView.addOnScrollListener( new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisiblePos  = MyLayoutManager.findFirstVisibleItemPosition();
                updateMontYear( firstVisiblePos );
            }
        });

        findPrev.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findPrev.setBackgroundColor(ContextCompat.getColor(context, R.color.c4));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findPrev.setBackgroundColor(ContextCompat.getColor(context, R.color.c1));
                        break;
                    }
                }
                return false;
            }
        });

        findPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( countGeneratedDays > 7 ) {
                    countGeneratedDays -= 7;
                    updateMontYear( countGeneratedDays - 7 );
                    mRecyclerView.smoothScrollToPosition(countGeneratedDays -7);
                }
            }
        });

        findNext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findNext.setBackgroundColor(ContextCompat.getColor(context, R.color.c4));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findNext.setBackgroundColor(ContextCompat.getColor(context, R.color.c1));
                        break;
                    }
                }
                return false;
            }
        });

        findNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( countGeneratedDays == listDays.size() ) {
                    listDays  = calendar.getMoreSevenDays( listDays.get( listDays.size() - 1 ).getFullDate() );
                    adapterDays.update( listDays );
                    mRecyclerView.smoothScrollToPosition( adapterDays.getItemCount() -1 );
                    updateMontYear( listDays.size() - 7 );
                    countGeneratedDays  =  listDays.size();
                }else {
                    countGeneratedDays += 7;
                    updateMontYear( countGeneratedDays - 7 );
                    mRecyclerView.smoothScrollToPosition( countGeneratedDays -1 );
                }
            }
        });
    }

    public void updateMontYear( int lengthList ) {
        String monthYear =   calendar.getMonthIn7Days( listDays.get( lengthList ).getFullDate() );
        txtMonthAndYear.setText( monthYear );
    }

}
