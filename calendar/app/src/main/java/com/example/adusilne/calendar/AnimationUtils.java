package com.example.adusilne.calendar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by adao on 8/10/17.
 */

public class AnimationUtils {
    public static void animate(RecyclerView.ViewHolder holder , boolean goesDown){
        AnimatorSet animatorSet = new AnimatorSet();

        //ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown==true ? 200 : -200, 0);
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", 0, 0);
        animatorTranslateY.setDuration(1000);


        //ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView,"translationX",-50,50,-30,30,-20,20,-5,5,0);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView,"translationX", -30, 0);
        animatorTranslateX.setDuration(1000);

        animatorSet.playTogether(animatorTranslateX,animatorTranslateY);

        //animatorSet.playTogether(animatorTranslateY);
        animatorSet.start();

    }
}
