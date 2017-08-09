package com.btesto.serbah.spinnerpokemon;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private AppCompatImageView mSpinnerView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mGestureDetector = new GestureDetector(this, this);

    }

    private void initView() {
        mSpinnerView = (AppCompatImageView) findViewById(R.id.spinnerView);
    }

    private void startAnimateSpinner() {
        final RotateAnimation rotate = new RotateAnimation(0, 1080,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        rotate.setDuration(100);
        rotate.setInterpolator(new AccelerateInterpolator());
        rotate.setRepeatCount(10);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                stopAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSpinnerView.startAnimation(rotate);

    }

    private void stopAnimation() {
        final RotateAnimation rotate = new RotateAnimation(0, 1080,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        rotate.setDuration(2000);
        rotate.setInterpolator(new DecelerateInterpolator());
        rotate.setRepeatCount(0);
        mSpinnerView.startAnimation(rotate);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        // down to up
        if (motionEvent.getY() - motionEvent1.getY() > 50) {

            return true;
        }

        // Up to down
        if (motionEvent1.getY() - motionEvent.getY() > 50) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                startAnimateSpinner();
            }

            return true;
        }

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}
