package cn.androidstudy.course13;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/16.
 */

public class CustomView extends View {
    Bitmap bitmap = null;
    Matrix matrix = null;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap==null) return;
        if(matrix==null) return;
        canvas.drawBitmap(bitmap,matrix,null);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
