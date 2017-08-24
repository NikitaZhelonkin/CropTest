package ru.nikitazhelonkin.croptest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by nikita on 24.08.17.
 */

public class CustomView extends AppCompatImageView {

    private Path mClipPath = new Path();

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
    protected void onDraw(Canvas canvas) {
        int radius = Math.min(getWidth(), getHeight()) / 4;
        mClipPath.reset();
        mClipPath.addCircle(getWidth() / 2, getHeight() / 2,
                radius, Path.Direction.CW);
        int clipSave = canvas.save();
        canvas.clipPath(mClipPath, Region.Op.DIFFERENCE);
        super.onDraw(canvas);
        canvas.restoreToCount(clipSave);
    }
}
