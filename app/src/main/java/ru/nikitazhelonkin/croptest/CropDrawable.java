package ru.nikitazhelonkin.croptest;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/**
 * Created by nikita on 24.08.17.
 */

class CropDrawable extends DrawableWrapper {

    private Path mClipPath = new Path();

    CropDrawable(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(Canvas canvas) {
        int clipSave = canvas.save();
        canvas.clipPath(mClipPath, Region.Op.DIFFERENCE);
        super.draw(canvas);
        canvas.restoreToCount(clipSave);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        int radius = Math.min(bounds.width(), bounds.height()) / 4;
        mClipPath.reset();
        mClipPath.addCircle(bounds.width() / 2, bounds.height() / 2,
                radius, Path.Direction.CW);
    }
}
