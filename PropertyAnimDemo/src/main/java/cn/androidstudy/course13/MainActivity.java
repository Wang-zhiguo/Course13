package cn.androidstudy.course13;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
    }
    public void valueAnim(View view){
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(2000);
        anim.start();

//        ValueAnimator anim = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_anim);
//        anim.start();

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "value = " + currentValue);
                imageView.setAlpha(currentValue);
            }
        });
    }

    public void objectAnim(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"alpha",0.0f,1.0f);
        objectAnimator.setDuration(200);
        objectAnimator.start();

//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.object_anim);
//        animator.setTarget(imageView);
//        animator.start();
    }

    public void animSet(View view){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(imageView, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();


//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_set);
//        animator.setTarget(imageView);
//        animator.start();
    }
}
