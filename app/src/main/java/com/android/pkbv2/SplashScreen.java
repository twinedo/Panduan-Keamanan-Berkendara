package com.android.pkbv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/*
* Update oleh Twin Edo
* 04/Mei/2019
* */

public class SplashScreen extends AppCompatActivity {

    Animation app_splash, btt;

    TextView logo_text;
    ImageView logo_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //run anim
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        //initialize id
        logo_text = findViewById(R.id.logo_text);
        logo_img = findViewById(R.id.logo_img);

        //logo x anim
        logo_text.startAnimation(app_splash);
        logo_img.startAnimation(btt);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(SplashScreen.this, BerandaActivity.class);
                startActivity(intent);
                finish();
            }

        }, 3000);
    }
}