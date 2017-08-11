package com.example.adusilne.calendar.componentes_custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by adao on 8/10/17.
 */

public class FontAwesomeTextView extends android.support.v7.widget.AppCompatTextView {
    public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontAwesomeTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/fontawesome-webfont.ttf");
        setTypeface(tf);
    }
}
