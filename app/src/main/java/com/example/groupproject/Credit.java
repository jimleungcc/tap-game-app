package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Credit extends AppCompatActivity{
    private ImageView iv_credit1, iv_credit2, iv_credit3, iv_credit4, iv_credit5, iv_credit6;
    private ImageButton ib_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        ib_back = findViewById(R.id.ib_back);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_credit1 = findViewById(R.id.iv_credit1);
        iv_credit2 = findViewById(R.id.iv_credit2);
        iv_credit3 = findViewById(R.id.iv_credit3);
        iv_credit4 = findViewById(R.id.iv_credit4);
        iv_credit5 = findViewById(R.id.iv_credit5);
        iv_credit6 = findViewById(R.id.iv_credit6);

        CreditAnimation(iv_credit1);
        CreditAnimation(iv_credit2);
        CreditAnimation(iv_credit3);
        CreditAnimation(iv_credit4);
        CreditAnimation(iv_credit5);
        CreditAnimation(iv_credit6);

    }

    private void CreditAnimation(ImageView iv) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        iv.setAnimation(animation);
        iv.startAnimation(animation);
    }

}