package cn.androidstudy.course13;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap = null;
    Matrix matrix = null;
    CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //从资源加载图片
        bitmap = ((BitmapDrawable) getResources().getDrawable(
                R.drawable.messi)).getBitmap();
        //获得CustomView控件
        customView = (CustomView)findViewById(R.id.customView);
        customView.setBitmap(bitmap);//设置绘制的图片
        matrix = new Matrix();
        customView.setMatrix(matrix);//设置变换矩阵
        customView.invalidate();//使customView失效，重画
    }

    public void handlerBitmap(View view){
        matrix = new Matrix();
        switch (view.getId()){
            case R.id.button://缩小
                matrix.setScale(0.2f,0.2f);
                break;
            case R.id.button2://旋转
                matrix.setScale(0.2f,0.2f);
                //1.不指定中心点，默认为左上角
                matrix.postRotate(180);//顺时针旋转180
                //将图片向下、向右移动，否则无法看到图片
                matrix.postTranslate(bitmap.getWidth()*0.2f,bitmap.getHeight()*0.2f);
                //2.旋转时，指定中心点（第2个参数，第3个参数）
                // matrix.postRotate(180,bitmap.getWidth()*0.1f,bitmap.getHeight()*0.1f);
                break;
            case R.id.button3://移动
                matrix.setScale(0.2f,0.2f);
                matrix.postTranslate(bitmap.getWidth()*0.2f,bitmap.getHeight()*0.2f);
                break;
            case R.id.button4://翻转
                float matrix_values[] = {-1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
                matrix.setValues(matrix_values);
                matrix.postScale(0.2f,0.2f);
                matrix.postTranslate(bitmap.getWidth()*0.2f,0);
                break;
        }
        customView.setMatrix(matrix);
        customView.invalidate();
    }
}
