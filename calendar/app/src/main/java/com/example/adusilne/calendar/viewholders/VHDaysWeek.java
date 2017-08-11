package com.example.adusilne.calendar.viewholders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.adusilne.calendar.R;

/**
 * Created by adao on 8/10/17.
 */

public class VHDaysWeek extends RecyclerView.ViewHolder{
    public TextView dayWeek;
    public CardView card_view;
    public Context context;
    public VHDaysWeek(final View itemView, Context context) {
        super(itemView);
        dayWeek = itemView.findViewById(R.id.dayWeek);
        card_view = itemView.findViewById(R.id.card_view);
        this.context = context;
    }
}
