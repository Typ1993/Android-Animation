package com.example.dell.textapplication;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ScreenUtils.initScreen(this);
        text = (TextView) findViewById(R.id.txt_falali);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testKeyFrames(v);
//                 RotateAnimation roationAnimation =new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,
//                        0.5f, Animation.RELATIVE_TO_SELF,0.5f);
//                float height = ScreenUtils.getScreenH()/2;
//                float width = ScreenUtils.getScreenW()/2;
//                ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(text,"translationX",0f,width);
//               // TranslateAnimation translateAnimation = new TranslateAnimation(0f,-width,0f,-height);
//                translateAnimation.setDuration(2000);
//                roationAnimation.setRepeatCount(100);
//                text.startAnimation(roationAnimation);
//                translateAnimation.start();
               // animationSet.addAnimation(roationAnimation);
            }

        });
    }
    public void testKeyFrames(final View v) {
        float h = v.getHeight();
        float w = v.getWidth();
        float x = v.getX();
        float y = v.getY();

        Keyframe kf0 = Keyframe.ofFloat(0.2f, 360);
        Keyframe kf1 = Keyframe.ofFloat(0.5f, 30);
        Keyframe kf2 = Keyframe.ofFloat(0.8f, 1080);
        Keyframe kf3 = Keyframe.ofFloat(1f, 0);
//        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe(
//                "rotation", kf0, kf1, kf2, kf3);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofFloat("rotation",0f,1080f,Animation.RELATIVE_TO_SELF,
                       0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("x", x, -x+20);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", y, -y+20);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",1,0);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1,0);
        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(v,
                pvhRotation, pvhX, pvhY,scaleX,scaleY);
        anim.setDuration(1500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }
}
