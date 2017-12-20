package cn.androidstudy.course13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void alphaAnim(View view){
        //第一种方式：XML方式
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        //imageView.startAnimation(animation);

        //第二种方式：编码实现
        //参数1 开始的透明度（完全不透明），0.0f 完全透明
        AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);
        alpha.setDuration(1000);
        imageView.startAnimation(alpha);
    }

    public void scaleAnim(View view){
        //第一种方式：XML方式
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        //imageView.startAnimation(animation);

        //第二种方式：编码实现
        ScaleAnimation animation_scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation_scale.setDuration(1000);
        animation_scale.setInterpolator(new AccelerateDecelerateInterpolator());
        imageView.startAnimation(animation_scale);
    }

    public void translateAnim(View view){
        //第一种方式：XML方式
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        //imageView.startAnimation(animation);

        //第二种方式：编码实现
        TranslateAnimation translateAnimation = new TranslateAnimation(30,-80,30,300);
        translateAnimation.setDuration(2000);
        imageView.startAnimation(translateAnimation);
    }

    public void rotateAnim(View view){
        //第一种方式：XML方式
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        //imageView.startAnimation(animation);

        //第二种方式：编码实现
        RotateAnimation rotateAnimation = new RotateAnimation(0,350,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(3000);
        imageView.startAnimation(rotateAnimation);
    }

    public void allAnim(View view){
        //第一种方式：XML方式
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.all_anim);
        //imageView.startAnimation(animation);

        //第二种方式：编码实现
        AnimationSet set = new AnimationSet(false);

        AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);
        alpha.setDuration(3000);

        ScaleAnimation animation_scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation_scale.setDuration(3000);
        animation_scale.setInterpolator(new AccelerateDecelerateInterpolator());

        RotateAnimation rotateAnimation = new RotateAnimation(0,350,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(3000);

        TranslateAnimation translateAnimation = new TranslateAnimation(30,-80,30,300);
        translateAnimation.setDuration(3000);
        translateAnimation.setStartOffset(3000);
        imageView.startAnimation(translateAnimation);

        set.addAnimation(alpha);
        set.addAnimation(animation_scale);
        set.addAnimation(rotateAnimation);
        set.addAnimation(translateAnimation);

        imageView.startAnimation(set);
    }
}
