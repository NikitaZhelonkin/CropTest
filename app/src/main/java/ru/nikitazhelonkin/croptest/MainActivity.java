package ru.nikitazhelonkin.croptest;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ObjectAnimator mAnimator;

    private View mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        mCustomView = findViewById(R.id.customView);
    }

    @Override
    public void onClick(View v) {
        stopAnimation();
        startAnimation();
    }

    private void startAnimation() {
        mAnimator = ObjectAnimator.ofFloat(mCustomView, "rotation", 0, 360);
        mAnimator.setDuration(1000);
        mAnimator.start();
    }

    private void stopAnimation() {
        if (mAnimator != null) {
            mAnimator.cancel();
        }
    }

}
