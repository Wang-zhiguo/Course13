package cn.androidstudy.course13;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/16.
 */

public class DrawShape extends View {
    Paint paint;

    public DrawShape(Context context) {
        super(context);
    }

    public DrawShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //初始化画笔
        paint = new Paint();
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔颜色
        paint.setColor(getResources().getColor(
                R.color.colorAccent));
        //设置画笔要是，圆形/方形/其他
        paint.setStrokeCap(Paint.Cap.BUTT);
        //设置实心圆
        paint.setStyle(Paint.Style.FILL);
        //设置画笔大小
        paint.setStrokeWidth(2);
        //设置阴影
        paint.setShadowLayer(5, 5, 5, Color.BLUE);
        //绘制实心圆
        canvas.drawCircle(300, 200, 100, paint);
        //设置为空心
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔大小
        paint.setStrokeWidth(3);
        //绘制
        canvas.drawCircle(500, 200, 100, paint);

        //实例化路径类
        Path path = new Path();
        //设置移动，不绘制
        path.moveTo(200, 400);
        //从(200，400)画到(400,600)
        path.lineTo(400, 600);
        //从(400,600)画到(200,600)
        path.lineTo(200, 600);
        //封闭曲线
        path.close();
        //绘制路径
        canvas.drawPath(path, paint);

        //初始化路径
        Path path2 = new Path();
        //设置矩形
        RectF rectF = new RectF(420, 400, 620, 700);
        //取矩形包裹椭圆0°到270°的弧
        path2.arcTo(rectF, 0, 270);
        //封闭弧形
        path2.close();
        //设置填充实心
        paint.setStyle(Paint.Style.FILL);
        //设置画笔颜色
        paint.setColor(getResources().getColor(R.color.colorAccent));
        //绘制图形
        canvas.drawPath(path2, paint);

        //绘制贝塞尔曲线
        Path path3 = new Path();
        //移动到(200,820)点
        path3.moveTo(200, 820);
        //绘制贝塞尔曲线
        path3.quadTo(300, 620, 400, 820);
        //设置空心
        paint.setStyle(Paint.Style.STROKE);
        //绘制曲线
        canvas.drawPath(path3, paint);

        //cubicTo()绘制贝塞尔曲线
        Path path4 = new Path();
        //移动到(300,300)点
        path4.moveTo(300, 300);
        //绘制曲线
        path4.cubicTo(300, 300, 5, 500, 300, 700);
        //设置不填充
        paint.setStyle(Paint.Style.STROKE);
        //绘制
        canvas.drawPath(path4, paint);

        paint.clearShadowLayer();
        //设置画笔颜色
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        //设置画笔大小
        paint.setStrokeWidth(2);
        //设置字体大小
        paint.setTextSize(30);
        //设置文字样式
        //paint.setTypeface(Typeface.DEFAULT_BOLD);
        String str = "Android文字绘制！Android文字绘制！Android文字绘制！";
        //全部显示，起点在(50,50)点
        canvas.drawText(str, 50, 50, paint);
        //截取字符串显示
        canvas.drawText(str, 0, 7, 100, 100, paint);
        //实例化路径
        Path path5 = new Path();
        //设置圆形状路径，Direction指示文字显示是逆时针向外还是顺时针向内
        // Path.Direction.CW|Path.Direction.CCW
        path5.addCircle(500, 900, 110, Path.Direction.CCW);
        //更具路径绘制文本
        canvas.drawTextOnPath(str, path5, 0, 0, paint);
    }
}
