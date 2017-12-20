package cn.androidstudy.course13;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void start(View view){
//        imageView.setImageResource(R.drawable.frame_anim);
//        animationDrawable = (AnimationDrawable) imageView.getDrawable();
//        animationDrawable.start();

        animationDrawable = new AnimationDrawable();
        for (int i = 1; i <= 6; i++) {
            int id = getResources().getIdentifier("icon" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable, 300);
        }
        animationDrawable.setOneShot(false);
        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();
    }
    public void end(View view){
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
    }
}
