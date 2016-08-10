package com.example.dell.textapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView img,img1;
    private TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageview);
        img1 = (ImageView) findViewById(R.id.imageview1);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text1:
//                ObjectAnimator anim = ObjectAnimator//
//                        .ofFloat(img, "typ", 1.0F,  0.0F)//
//                        .setDuration(500);//
//                anim.start();
//                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//                {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation)
//                    {
//                        float cVal = (Float) animation.getAnimatedValue();
//                        img.setAlpha(cVal);
//                        img.setScaleX(cVal);
//                        img.setScaleY(cVal);
//                    }
//
//                });
                //缩小淡出
                AnimationSet animationSet = new AnimationSet(false);  //interpolator设置
                Animation animation = new AlphaAnimation(1.0f,0.0f);
                Animation animation1 = new ScaleAnimation(1.0f,0.0f,1.0f,0.0f);
                animation.setDuration(2000);
                animation1.setDuration(2000);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(animation1);
                img.setAnimation(animationSet);
                img.startAnimation(animationSet);
                break;
            case R.id.text2:
                ObjectAnimator visToInvis1 = ObjectAnimator.ofFloat(img, "rotationX", 180f, 0f);
                visToInvis1.start();
                break;
            case R.id.text3:
                ObjectAnimator visToInvis = ObjectAnimator.ofFloat(img, "rotationY", 0f, 90f);
               final ObjectAnimator visFromInvis = ObjectAnimator.ofFloat(img1,"rotationY",-90f,0f);
                visToInvis.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator anim) {
                        img.setVisibility(View.GONE);
                        visFromInvis.start();
                        img1.setVisibility(View.VISIBLE);
                        //firstView.clearAnimation();
                       // towView.clearAnimation();
                    }
                });
                visToInvis.start();
                break;
            case R.id.text4:
                Intent intent = new Intent(this,ResultActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_bottom,R.anim.slide_out_to_top);
                break;
        }
    }
}
