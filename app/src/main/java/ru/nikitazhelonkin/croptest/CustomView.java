package ru.nikitazhelonkin.croptest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nikita on 24.08.17.
 */

public class CustomView extends AppCompatImageView {

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (drawable == null || drawable instanceof CropDrawable) {
            super.setImageDrawable(drawable);
        } else {
            super.setImageDrawable(new CropDrawable(drawable));
        }
    }

}
