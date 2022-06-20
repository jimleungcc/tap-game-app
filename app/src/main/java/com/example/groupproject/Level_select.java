package com.example.groupproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Level_select extends AppCompatActivity {
    private ImageButton[] ib_lvs = new ImageButton[40];
    private ImageButton ib_back, ib_next;
    private int[] imageResource = new int[100];
    private int pageNum;
    private int max_lv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        Database db = new Database(this);
        max_lv = db.getMaxLevel();
        if (max_lv == -1) {
            db.initializeLevel();
            max_lv = db.getMaxLevel();
        }
        initialization();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Database db = new Database(this);
        max_lv = db.getMaxLevel();
        setImageResource();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initialization(){
        pageNum = 1;
        ib_lvs[0] = findViewById(R.id.lv1);
        ib_lvs[1] = findViewById(R.id.lv2);
        ib_lvs[2] = findViewById(R.id.lv3);
        ib_lvs[3] = findViewById(R.id.lv4);
        ib_lvs[4] = findViewById(R.id.lv5);
        ib_lvs[5] = findViewById(R.id.lv6);
        ib_lvs[6] = findViewById(R.id.lv7);
        ib_lvs[7] = findViewById(R.id.lv8);
        ib_lvs[8] = findViewById(R.id.lv9);
        ib_lvs[9] = findViewById(R.id.lv10);
        ib_lvs[10] = findViewById(R.id.lv11);
        ib_lvs[11] = findViewById(R.id.lv12);
        ib_lvs[12] = findViewById(R.id.lv13);
        ib_lvs[13] = findViewById(R.id.lv14);
        ib_lvs[14] = findViewById(R.id.lv15);
        ib_lvs[15] = findViewById(R.id.lv16);
        ib_lvs[16] = findViewById(R.id.lv17);
        ib_lvs[17] = findViewById(R.id.lv18);
        ib_lvs[18] = findViewById(R.id.lv19);
        ib_lvs[19] = findViewById(R.id.lv20);
        ib_lvs[20] = findViewById(R.id.lv21);
        ib_lvs[21] = findViewById(R.id.lv22);
        ib_lvs[22] = findViewById(R.id.lv23);
        ib_lvs[23] = findViewById(R.id.lv24);
        ib_lvs[24] = findViewById(R.id.lv25);
        ib_lvs[25] = findViewById(R.id.lv26);
        ib_lvs[26] = findViewById(R.id.lv27);
        ib_lvs[27] = findViewById(R.id.lv28);
        ib_lvs[28] = findViewById(R.id.lv29);
        ib_lvs[29] = findViewById(R.id.lv30);
        ib_lvs[30] = findViewById(R.id.lv31);
        ib_lvs[31] = findViewById(R.id.lv32);
        ib_lvs[32] = findViewById(R.id.lv33);
        ib_lvs[33] = findViewById(R.id.lv34);
        ib_lvs[34] = findViewById(R.id.lv35);
        ib_lvs[35] = findViewById(R.id.lv36);
        ib_lvs[36] = findViewById(R.id.lv37);
        ib_lvs[37] = findViewById(R.id.lv38);
        ib_lvs[38] = findViewById(R.id.lv39);
        ib_lvs[39] = findViewById(R.id.lv40);
        imageResource[0] = R.drawable.lv_1;
        imageResource[1] = R.drawable.lv_2;
        imageResource[2] = R.drawable.lv_3;
        imageResource[3] = R.drawable.lv_4;
        imageResource[4] = R.drawable.lv_5;
        imageResource[5] = R.drawable.lv_6;
        imageResource[6] = R.drawable.lv_7;
        imageResource[7] = R.drawable.lv_8;
        imageResource[8] = R.drawable.lv_9;
        imageResource[9] = R.drawable.lv_10;
        imageResource[10] = R.drawable.lv_11;
        imageResource[11] = R.drawable.lv_12;
        imageResource[12] = R.drawable.lv_13;
        imageResource[13] = R.drawable.lv_14;
        imageResource[14] = R.drawable.lv_15;
        imageResource[15] = R.drawable.lv_16;
        imageResource[16] = R.drawable.lv_17;
        imageResource[17] = R.drawable.lv_18;
        imageResource[18] = R.drawable.lv_19;
        imageResource[19] = R.drawable.lv_20;
        imageResource[20] = R.drawable.lv_21;
        imageResource[21] = R.drawable.lv_22;
        imageResource[22] = R.drawable.lv_23;
        imageResource[23] = R.drawable.lv_24;
        imageResource[24] = R.drawable.lv_25;
        imageResource[25] = R.drawable.lv_26;
        imageResource[26] = R.drawable.lv_27;
        imageResource[27] = R.drawable.lv_28;
        imageResource[28] = R.drawable.lv_29;
        imageResource[29] = R.drawable.lv_30;
        imageResource[30] = R.drawable.lv_31;
        imageResource[31] = R.drawable.lv_32;
        imageResource[32] = R.drawable.lv_33;
        imageResource[33] = R.drawable.lv_34;
        imageResource[34] = R.drawable.lv_35;
        imageResource[35] = R.drawable.lv_36;
        imageResource[36] = R.drawable.lv_37;
        imageResource[37] = R.drawable.lv_38;
        imageResource[38] = R.drawable.lv_39;
        imageResource[39] = R.drawable.lv_40;
        imageResource[40] = R.drawable.lv_41;
        imageResource[41] = R.drawable.lv_42;
        imageResource[42] = R.drawable.lv_43;
        imageResource[43] = R.drawable.lv_44;
        imageResource[44] = R.drawable.lv_45;
        imageResource[45] = R.drawable.lv_46;
        imageResource[46] = R.drawable.lv_47;
        imageResource[47] = R.drawable.lv_48;
        imageResource[48] = R.drawable.lv_49;
        imageResource[49] = R.drawable.lv_50;
        imageResource[50] = R.drawable.lv_51;
        imageResource[51] = R.drawable.lv_52;
        imageResource[52] = R.drawable.lv_53;
        imageResource[53] = R.drawable.lv_54;
        imageResource[54] = R.drawable.lv_55;
        imageResource[55] = R.drawable.lv_56;
        imageResource[56] = R.drawable.lv_57;
        imageResource[57] = R.drawable.lv_58;
        imageResource[58] = R.drawable.lv_59;
        imageResource[59] = R.drawable.lv_60;
        imageResource[60] = R.drawable.lv_61;
        imageResource[61] = R.drawable.lv_62;
        imageResource[62] = R.drawable.lv_63;
        imageResource[63] = R.drawable.lv_64;
        imageResource[64] = R.drawable.lv_65;
        imageResource[65] = R.drawable.lv_66;
        imageResource[66] = R.drawable.lv_67;
        imageResource[67] = R.drawable.lv_68;
        imageResource[68] = R.drawable.lv_69;
        imageResource[69] = R.drawable.lv_70;
        imageResource[70] = R.drawable.lv_71;
        imageResource[71] = R.drawable.lv_72;
        imageResource[72] = R.drawable.lv_73;
        imageResource[73] = R.drawable.lv_74;
        imageResource[74] = R.drawable.lv_75;
        imageResource[75] = R.drawable.lv_76;
        imageResource[76] = R.drawable.lv_77;
        imageResource[77] = R.drawable.lv_78;
        imageResource[78] = R.drawable.lv_79;
        imageResource[79] = R.drawable.lv_80;
        imageResource[80] = R.drawable.lv_81;
        imageResource[81] = R.drawable.lv_82;
        imageResource[82] = R.drawable.lv_83;
        imageResource[83] = R.drawable.lv_84;
        imageResource[84] = R.drawable.lv_85;
        imageResource[85] = R.drawable.lv_86;
        imageResource[86] = R.drawable.lv_87;
        imageResource[87] = R.drawable.lv_88;
        imageResource[88] = R.drawable.lv_89;
        imageResource[89] = R.drawable.lv_90;
        imageResource[90] = R.drawable.lv_91;
        imageResource[91] = R.drawable.lv_92;
        imageResource[92] = R.drawable.lv_93;
        imageResource[93] = R.drawable.lv_94;
        imageResource[94] = R.drawable.lv_95;
        imageResource[95] = R.drawable.lv_96;
        imageResource[96] = R.drawable.lv_97;
        imageResource[97] = R.drawable.lv_98;
        imageResource[98] = R.drawable.lv_99;
        imageResource[99] = R.drawable.lv_100;
        for(ImageButton ib : ib_lvs){
            ib.setOnClickListener(ib_listener);
        }
        ib_back = findViewById(R.id.ib_back);
        ib_next = findViewById(R.id.ib_next);
        ib_back.setOnClickListener(backPg_listener);
        ib_next.setOnClickListener(nextPg_listener);
        for (int k = 0; k < ib_lvs.length; k++) {
            if(k < max_lv) {
                ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, android.R.color.transparent));
                ib_lvs[k].setClickable(true);
            }
            else {
                ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, R.color.grey));
                ib_lvs[k].setClickable(false);
            }
        }
    }

    public static void startGameActivity(Context packageContext, int level){
        long game_time = 300 - (level / 5 * 5);
        int game_time_mins = (int) game_time / 60;
        int game_time_secs = (int) game_time % 60;
        int availableFishes = 9;
        int max_fishes = 15;
        int maxScore = 1000 + (level - 1)  * 50;
        double fishSize = 1 - 0.005 * (level - 1);
        startGameActivity(packageContext, level, game_time_mins, game_time_secs, availableFishes, max_fishes, maxScore, fishSize);
    }

    private static void startGameActivity(Context packageContext, int level, int minutes, int seconds, int availableFishesType, int maxFishes, int maxScore, double fishSize){
        Intent i = new Intent(packageContext, GameActivity.class);
        i.putExtra("Level", level);
        long time = (minutes * 60  + seconds) * 1000;
        i.putExtra("Time", time);
        i.putExtra("FishesType", availableFishesType);
        i.putExtra("MaxFishes", maxFishes);
        i.putExtra("MaxScore", maxScore);
        i.putExtra("FishSize", fishSize);
        packageContext.startActivity(i);
    }

    private View.OnClickListener ib_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (pageNum == 1) {
                switch (v.getId()) {
                    case R.id.lv1:
                        startGameActivity(Level_select.this, 1);
                        break;
                    case R.id.lv2:
                        startGameActivity(Level_select.this, 2);
                        break;
                    case R.id.lv3:
                        startGameActivity(Level_select.this, 3);
                        break;
                    case R.id.lv4:
                        startGameActivity(Level_select.this, 4);
                        break;
                    case R.id.lv5:
                        startGameActivity(Level_select.this, 5);
                        break;
                    case R.id.lv6:
                        startGameActivity(Level_select.this, 6);
                        break;
                    case R.id.lv7:
                        startGameActivity(Level_select.this, 7);
                        break;
                    case R.id.lv8:
                        startGameActivity(Level_select.this, 8);
                        break;
                    case R.id.lv9:
                        startGameActivity(Level_select.this, 9);
                        break;
                    case R.id.lv10:
                        startGameActivity(Level_select.this, 10);
                        break;
                    case R.id.lv11:
                        startGameActivity(Level_select.this, 11);
                        break;
                    case R.id.lv12:
                        startGameActivity(Level_select.this, 12);
                        break;
                    case R.id.lv13:
                        startGameActivity(Level_select.this, 13);
                        break;
                    case R.id.lv14:
                        startGameActivity(Level_select.this, 14);
                        break;
                    case R.id.lv15:
                        startGameActivity(Level_select.this, 15);
                        break;
                    case R.id.lv16:
                        startGameActivity(Level_select.this, 16);
                        break;
                    case R.id.lv17:
                        startGameActivity(Level_select.this, 17);
                        break;
                    case R.id.lv18:
                        startGameActivity(Level_select.this, 18);
                        break;
                    case R.id.lv19:
                        startGameActivity(Level_select.this, 19);
                        break;
                    case R.id.lv20:
                        startGameActivity(Level_select.this, 20);
                        break;
                    case R.id.lv21:
                        startGameActivity(Level_select.this, 21);
                        break;
                    case R.id.lv22:
                        startGameActivity(Level_select.this, 22);
                        break;
                    case R.id.lv23:
                        startGameActivity(Level_select.this, 23);
                        break;
                    case R.id.lv24:
                        startGameActivity(Level_select.this, 24);
                        break;
                    case R.id.lv25:
                        startGameActivity(Level_select.this, 25);
                        break;
                    case R.id.lv26:
                        startGameActivity(Level_select.this, 26);
                        break;
                    case R.id.lv27:
                        startGameActivity(Level_select.this, 27);
                        break;
                    case R.id.lv28:
                        startGameActivity(Level_select.this, 28);
                        break;
                    case R.id.lv29:
                        startGameActivity(Level_select.this, 29);
                        break;
                    case R.id.lv30:
                        startGameActivity(Level_select.this, 30);
                        break;
                    case R.id.lv31:
                        startGameActivity(Level_select.this, 31);
                        break;
                    case R.id.lv32:
                        startGameActivity(Level_select.this, 32);
                        break;
                    case R.id.lv33:
                        startGameActivity(Level_select.this, 33);
                        break;
                    case R.id.lv34:
                        startGameActivity(Level_select.this, 34);
                        break;
                    case R.id.lv35:
                        startGameActivity(Level_select.this, 35);
                        break;
                    case R.id.lv36:
                        startGameActivity(Level_select.this, 36);
                        break;
                    case R.id.lv37:
                        startGameActivity(Level_select.this, 37);
                        break;
                    case R.id.lv38:
                        startGameActivity(Level_select.this, 38);
                        break;
                    case R.id.lv39:
                        startGameActivity(Level_select.this, 39);
                        break;
                    case R.id.lv40:
                        startGameActivity(Level_select.this, 40);
                        break;
                }
            }
            else if (pageNum == 2) {
                switch (v.getId()) {
                    case R.id.lv1:
                        startGameActivity(Level_select.this, 41);
                        break;
                    case R.id.lv2:
                        startGameActivity(Level_select.this, 42);
                        break;
                    case R.id.lv3:
                        startGameActivity(Level_select.this, 43);
                        break;
                    case R.id.lv4:
                        startGameActivity(Level_select.this, 44);
                        break;
                    case R.id.lv5:
                        startGameActivity(Level_select.this, 45);
                        break;
                    case R.id.lv6:
                        startGameActivity(Level_select.this, 46);
                        break;
                    case R.id.lv7:
                        startGameActivity(Level_select.this, 47);
                        break;
                    case R.id.lv8:
                        startGameActivity(Level_select.this, 48);
                        break;
                    case R.id.lv9:
                        startGameActivity(Level_select.this, 49);
                        break;
                    case R.id.lv10:
                        startGameActivity(Level_select.this, 50);
                        break;
                    case R.id.lv11:
                        startGameActivity(Level_select.this, 51);
                        break;
                    case R.id.lv12:
                        startGameActivity(Level_select.this, 52);
                        break;
                    case R.id.lv13:
                        startGameActivity(Level_select.this, 53);
                        break;
                    case R.id.lv14:
                        startGameActivity(Level_select.this, 54);
                        break;
                    case R.id.lv15:
                        startGameActivity(Level_select.this, 55);
                        break;
                    case R.id.lv16:
                        startGameActivity(Level_select.this, 56);
                        break;
                    case R.id.lv17:
                        startGameActivity(Level_select.this, 57);
                        break;
                    case R.id.lv18:
                        startGameActivity(Level_select.this, 58);
                        break;
                    case R.id.lv19:
                        startGameActivity(Level_select.this, 59);
                        break;
                    case R.id.lv20:
                        startGameActivity(Level_select.this, 60);
                        break;
                    case R.id.lv21:
                        startGameActivity(Level_select.this, 61);
                        break;
                    case R.id.lv22:
                        startGameActivity(Level_select.this, 62);
                        break;
                    case R.id.lv23:
                        startGameActivity(Level_select.this, 63);
                        break;
                    case R.id.lv24:
                        startGameActivity(Level_select.this, 64);
                        break;
                    case R.id.lv25:
                        startGameActivity(Level_select.this, 65);
                        break;
                    case R.id.lv26:
                        startGameActivity(Level_select.this, 66);
                        break;
                    case R.id.lv27:
                        startGameActivity(Level_select.this, 67);
                        break;
                    case R.id.lv28:
                        startGameActivity(Level_select.this, 68);
                        break;
                    case R.id.lv29:
                        startGameActivity(Level_select.this, 69);
                        break;
                    case R.id.lv30:
                        startGameActivity(Level_select.this, 70);
                        break;
                    case R.id.lv31:
                        startGameActivity(Level_select.this, 71);
                        break;
                    case R.id.lv32:
                        startGameActivity(Level_select.this, 72);
                        break;
                    case R.id.lv33:
                        startGameActivity(Level_select.this, 73);
                        break;
                    case R.id.lv34:
                        startGameActivity(Level_select.this, 74);
                        break;
                    case R.id.lv35:
                        startGameActivity(Level_select.this, 75);
                        break;
                    case R.id.lv36:
                        startGameActivity(Level_select.this, 76);
                        break;
                    case R.id.lv37:
                        startGameActivity(Level_select.this, 77);
                        break;
                    case R.id.lv38:
                        startGameActivity(Level_select.this, 78);
                        break;
                    case R.id.lv39:
                        startGameActivity(Level_select.this, 79);
                        break;
                    case R.id.lv40:
                        startGameActivity(Level_select.this, 80);
                        break;
                }
            }
            if (pageNum == 3) {
                switch (v.getId()) {
                    case R.id.lv1:
                        startGameActivity(Level_select.this, 81);
                        break;
                    case R.id.lv2:
                        startGameActivity(Level_select.this, 82);
                        break;
                    case R.id.lv3:
                        startGameActivity(Level_select.this, 83);
                        break;
                    case R.id.lv4:
                        startGameActivity(Level_select.this, 84);
                        break;
                    case R.id.lv5:
                        startGameActivity(Level_select.this, 85);
                        break;
                    case R.id.lv6:
                        startGameActivity(Level_select.this, 86);
                        break;
                    case R.id.lv7:
                        startGameActivity(Level_select.this, 87);
                        break;
                    case R.id.lv8:
                        startGameActivity(Level_select.this, 88);
                        break;
                    case R.id.lv9:
                        startGameActivity(Level_select.this, 89);
                        break;
                    case R.id.lv10:
                        startGameActivity(Level_select.this, 90);
                        break;
                    case R.id.lv11:
                        startGameActivity(Level_select.this, 91);
                        break;
                    case R.id.lv12:
                        startGameActivity(Level_select.this, 92);
                        break;
                    case R.id.lv13:
                        startGameActivity(Level_select.this, 93);
                        break;
                    case R.id.lv14:
                        startGameActivity(Level_select.this, 94);
                        break;
                    case R.id.lv15:
                        startGameActivity(Level_select.this, 95);
                        break;
                    case R.id.lv16:
                        startGameActivity(Level_select.this, 96);
                        break;
                    case R.id.lv17:
                        startGameActivity(Level_select.this, 97);
                        break;
                    case R.id.lv18:
                        startGameActivity(Level_select.this, 98);
                        break;
                    case R.id.lv19:
                        startGameActivity(Level_select.this, 99);
                        break;
                    case R.id.lv20:
                        startGameActivity(Level_select.this, 100);
                        break;
                }
            }
        }
    };

    private void setImageResource(){
        switch (pageNum){
            case 1: {
                for (int k = 0; k < ib_lvs.length; k++) {
                    ib_lvs[k].setImageResource(imageResource[k]);
                    ib_lvs[k].setVisibility(ib_lvs[k].VISIBLE);
                    if (k < max_lv) {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, android.R.color.transparent));
                        ib_lvs[k].setClickable(true);
                    }
                    else {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, R.color.grey));
                        ib_lvs[k].setClickable(false);
                    }
                }
                ib_next.setVisibility(ib_back.VISIBLE);
            }
            break;
            case 2: {
                for (int k = 0; k < ib_lvs.length; k++) {
                    ib_lvs[k].setImageResource(imageResource[40 + k]);
                    ib_lvs[k].setVisibility(ib_lvs[k].VISIBLE);
                    if (k + 40 < max_lv) {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, android.R.color.transparent));
                        ib_lvs[k].setClickable(true);
                    }
                    else {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, R.color.grey));
                        ib_lvs[k].setClickable(false);
                    }
                }
                ib_next.setVisibility(ib_back.VISIBLE);
            }
            break;
            case 3: {
                for (int k = 0; k < 20; k++) {
                    ib_lvs[k].setImageResource(imageResource[80 + k]);
                    if (k + 80 < max_lv) {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, android.R.color.transparent));
                        ib_lvs[k].setClickable(true);
                    }
                    else {
                        ib_lvs[k].setColorFilter(ActivityCompat.getColor(this, R.color.grey));
                        ib_lvs[k].setClickable(false);
                    }
                }
                for (int k = 20; k < 40; k++) {
                    ib_lvs[k].setVisibility(ib_lvs[k].INVISIBLE);
                }
                ib_next.setVisibility(ib_back.INVISIBLE);
            }
            break;
        }
    }

    private View.OnClickListener backPg_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (pageNum){
                case 1:
                    finish();
                    break;
                case 2:
                case 3:
                    pageNum--;
                    setImageResource();
                    break;
            }
        }
    };

    private View.OnClickListener nextPg_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (pageNum){
                case 1:
                case 2:
                    pageNum++;
                    setImageResource();
                    break;
            }
        }
    };
}