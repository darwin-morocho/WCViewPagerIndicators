package com.darwindeveloper.wcviewpagerindicatorlibrary;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;

/**
 * Created by Darwin Morocho on 11/3/2017.
 */

public class CircularTextView extends TextView {
    private Paint circlePaint;
    private int circleColor;


    public CircularTextView(Context context) {
        super(context);
    }

    public CircularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //get the attributes specified in attrs.xml using the name we included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CircularTextView, 0, 0);
        try {
            //get the text and colors specified using the names in attrs.xml
            circleColor = a.getColor(R.styleable.CircularTextView_circleColor, Color.parseColor("#0099cc"));

        } finally {
            a.recycle();
        }

        //paint object for drawing in onDraw
        circlePaint = new Paint();


    }

    @Override
    protected void onDraw(Canvas canvas) {

        //get half of the width and height as we are working with a circle
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;

        //get the radius as half of the width or height, whichever is smaller
//subtract ten so that it has some space around it
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf)
            radius = viewHeightHalf - 10;
        else
            radius = viewWidthHalf - 10;

        //circlePaint.setStyle(Style.FILL);
        //circlePaint.setAntiAlias(true);
        //set the paint color using the circle color specified
        circlePaint.setColor(circleColor);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
        super.onDraw(canvas);
    }


    public void setCircleColor(int newColor) {
        //update the instance variable
        circleColor = newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }


}
