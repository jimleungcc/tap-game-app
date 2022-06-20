package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton ib_play, ib_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib_play = findViewById(R.id.ib_play);
        ib_credit = findViewById(R.id.ib_credit);
        ib_play.setOnClickListener(ib_listener);
        ib_credit.setOnClickListener(ib_listener);
    }

    private View.OnClickListener ib_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ib_play: {
                    Intent in = new Intent(MainActivity.this, Level_select.class);
                    startActivity(in);
                }
                    break;
                case R.id.ib_credit: {
                    Intent in = new Intent(MainActivity.this, Credit.class);
                    startActivity(in);
                }
                    break;
            }
        }
    };
}