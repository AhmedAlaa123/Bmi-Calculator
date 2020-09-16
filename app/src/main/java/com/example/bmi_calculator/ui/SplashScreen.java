package com.example.bmi_calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmi_calculator.R;

public class SplashScreen extends AppCompatActivity {
    private TextView textView_B;
     private TextView textView_M;
     private TextView textView_I;
     private ImageView imageView_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView_B=findViewById(R.id.textView_B);
        textView_I=findViewById(R.id.textView_I);
        textView_M=findViewById(R.id.textView_M);
        imageView_logo=findViewById(R.id.imageView_logo);
        setAnimation();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    private void setAnimation()
    {
        Animation animationLogo= AnimationUtils.loadAnimation(this,R.anim.logo_scale);
        Animation animationM= AnimationUtils.loadAnimation(this,R.anim.m_translate);
        Animation animationB= AnimationUtils.loadAnimation(this,R.anim.b_tanslate);
        Animation animationI= AnimationUtils.loadAnimation(this,R.anim.i_translate);
        imageView_logo.setAnimation(animationLogo);
        textView_M.setAnimation(animationM);
        textView_B.setAnimation(animationB);
        textView_I.setAnimation(animationI);
        animationLogo.start();
        animationB.start();
        animationI.start();
        animationM.start();


    }
}