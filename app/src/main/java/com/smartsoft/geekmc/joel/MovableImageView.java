package com.smartsoft.geekmc.joel;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Shadaï ALI on 16/06/16.
 */
public class MovableImageView extends ImageView implements ImageView.OnTouchListener{

    float x,y =0;

    public MovableImageView(Context context) {
        super(context);
        setOnTouchListener(this);

    }

    public MovableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public MovableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e("pos","x:"+String.valueOf(x)+"y:"+String.valueOf(y));
        switch (event.getAction()) {


            case MotionEvent.ACTION_DOWN:

                x = this.getX() - event.getRawX();
                y = this.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                this.animate()
                        .x(event.getRawX() + x)
                        .y(event.getRawY() + y)
                        .setDuration(0)
                        .start();
                break;
            default:
                return false;
        }
        return true;
    }

}
