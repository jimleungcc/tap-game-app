package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private int fish_height, fish_width;
    private int fish_spawn_time = 500;
    private long time;
    private int score, level, availableFishesType, maxFishes, maxScore;
    private TextView game_lv, game_score, tv_clock;
    private ImageButton ib_pause, ib_quit, ib_retry;
    private boolean pause, ended, isWin;
    private CountDownTimer CountDownTimer;
    private GameThread gameThread;
    private int screen_height, screen_width;
    private int[] fishes = new int[]{R.drawable.game_fish_1, R.drawable.game_fish_2, R.drawable.game_fish_3,
            R.drawable.game_fish_4, R.drawable.game_fish_5, R.drawable.game_fish_6,
            R.drawable.game_fish_7, R.drawable.game_fish_8, R.drawable.game_fish_9};
    private ImageView[] iv_fishes = new ImageView[fishes.length];
    private RelativeLayout rl;
    private static final Random rand = new Random();
    private ArrayList<Fish> fishes_list = new ArrayList<>();
    private int start_Y;
    private SoundPlayer sound;
	private ProgressBar progressBar;
	private ImageView iv_timesup, iv_victory;
	private Database db = new Database(this);
	
	private MediaPlayer backgroundMusic;
	private int bgm_length = 0;

	//@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        sound = new SoundPlayer(this);
        game_lv = findViewById(R.id.gamv_lv);
        game_score = findViewById(R.id.game_score);
        tv_clock = findViewById(R.id.tv_clock);

        iv_timesup = findViewById(R.id.iv_timesup);
        iv_timesup.setVisibility(View.INVISIBLE);
        iv_victory = findViewById(R.id.iv_victory);
        iv_victory.setVisibility(View.INVISIBLE);
        ib_quit = findViewById(R.id.ib_quit);
        ib_quit.setVisibility(View.INVISIBLE);
        ib_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
                finish();
            }
        });
        ib_retry = findViewById(R.id.ib_retry);
        ib_retry.setVisibility(View.INVISIBLE);
        ib_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWin && level < 100) {
                    sound.stop();
                    finish();
                    Level_select.startGameActivity(GameActivity.this,level + 1);
                } else {
                    sound.stop();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;
        screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
        fish_height = (int)(screen_height * 0.14);
        fish_width = (int)(screen_width * 0.324);
        Intent i = getIntent();
        if(i.getExtras() != null)
        {
            level = i.getExtras().getInt("Level");
            time = i.getExtras().getLong("Time");
            game_lv.setText(String.valueOf(level));
            int min = (int)time / 1000 / 60;
            int sec = (int)(time / 1000) % 60;
            tv_clock.setText(String.format("%02d:%02d", min, sec));
            availableFishesType = i.getExtras().getInt("FishesType");
            maxFishes = i.getExtras().getInt("MaxFishes");
            maxScore = i.getExtras().getInt("MaxScore");
            double fishSize = i.getExtras().getDouble("FishSize");
            fish_height *= fishSize;
            fish_width *= fishSize;
        }
        progressBar = findViewById(R.id.progressBar);
        ib_pause = findViewById(R.id.ib_pause);
        ib_pause.setOnClickListener(ib_pause_listener);
        game_score.setText(String.format("%d / %d", score, maxScore));
        for (int k = 0; k < fishes.length; k++){
            iv_fishes[k] = new ImageView(this);
            iv_fishes[k].setImageResource(fishes[k]);
        }
        rl = findViewById(R.id.rl);
        rl.setOnTouchListener(onTouchListener);
        StartCountDownTimer();
        progressBar.setMax(maxScore); //set target score
        backgroundMusic = MediaPlayer.create(this, R.raw.underwater);
        backgroundMusic.start();
        backgroundMusic.setLooping(true);
        gameThread = new GameThread();
        gameThread.start();
    }
	
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int[] coordinate = new int[2];
        ib_pause.getLocationInWindow(coordinate);
        start_Y = coordinate[1];
    }

    private class GameThread extends Thread{
        @Override
        public void run()
        {
            while(!ended) {
                if(!pause) {
                    if (fishes_list.size() < maxFishes)
                        createFish();
                }
                try {
                    Thread.sleep(fish_spawn_time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private View.OnClickListener ib_pause_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (pause){
                backgroundMusic = MediaPlayer.create(GameActivity.this, R.raw.underwater);
                backgroundMusic.setLooping(true);
                backgroundMusic.seekTo(bgm_length);
                backgroundMusic.start();
                StartCountDownTimer();
                pause = false;
                ib_pause.setImageResource(R.drawable.button_pause);
                for (Fish fish : fishes_list){
                    fish.setVisibility(fish.VISIBLE);
                }
                rl.invalidate();
                AnimateSlideInOut(ib_quit, false, 500, screen_width);
                AnimateSlideInOut(ib_retry, false, 500, screen_width);
            }
            else {
                sound.playPause();
                bgm_length = backgroundMusic.getCurrentPosition();
                backgroundMusic.stop();
                CountDownTimer.cancel();
                pause = true;
                ib_pause.setImageResource(R.drawable.button_continue);
                for (Fish fish : fishes_list){
                    fish.setVisibility(fish.INVISIBLE);
                }
                rl.invalidate();
                AnimateSlideInOut(ib_quit, true, 900, screen_width);
                AnimateSlideInOut(ib_retry, true, 900, screen_width);
            }
        }
    };

    public void StartCountDownTimer() {
        CountDownTimer = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
                tv_clock.setText(String.format("%02d:%02d", time / 1000 / 60, (time / 1000) % 60));
            }

            public void onFinish() {
                tv_clock.setText("00:00");
                endGame(false);
            }
        }.start();
    }

    public void AnimateSlideInOut(final ImageView ivDH, final Boolean SlideIn, final int AnimDuration, final int dx) {
        rl.post(new Runnable() {
            @Override
            public void run() {
                if (SlideIn) {
                    ivDH.setVisibility(View.VISIBLE);
                    Animation transAnimation = new TranslateAnimation(Animation.ABSOLUTE + dx, Animation.ABSOLUTE, Animation.ABSOLUTE, Animation.ABSOLUTE);
                    transAnimation.setDuration(AnimDuration);
                    AnimationSet animationSet1 = new AnimationSet(true);
                    animationSet1.addAnimation(transAnimation);
                    animationSet1.setDuration(500);
                    animationSet1.setInterpolator(new DecelerateInterpolator());
                    ivDH.startAnimation(animationSet1);
                }
                else {
                    Animation transAnimation = new TranslateAnimation(Animation.ABSOLUTE, Animation.ABSOLUTE + dx, Animation.ABSOLUTE, Animation.ABSOLUTE);
                    transAnimation.setDuration(AnimDuration);
                    AnimationSet animationSet1 = new AnimationSet(true);
                    animationSet1.addAnimation(transAnimation);
                    animationSet1.setDuration(500);
                    animationSet1.setInterpolator(new DecelerateInterpolator());
                    ivDH.startAnimation(animationSet1);
                    ivDH.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private class FishMoveThread extends Thread{
        private Fish fish;
        public FishMoveThread(Fish fish){
            this.fish = fish;
        }
        @Override
        public void run() {
            while (fish.isAlive() && !ended) {
                while (pause){
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fish.getLayoutParams();
/*                if (params.leftMargin >= width - fish_width && fish.getX_speed() > 0)
                    fish.setX_speed(fish.getX_speed() * (-1));*/
                if (params.topMargin >= screen_height - fish_height - 100 && fish.getY_speed() > 0)
                    fish.setY_speed(fish.getY_speed() * (-1));
/*                if (params.leftMargin <= 0 && fish.getX_speed() < 0)
                    fish.setX_speed(fish.getX_speed() * (-1));*/
                if (params.topMargin <= start_Y && fish.getY_speed() < 0)
                    fish.setY_speed(fish.getY_speed() * (-1));

                if (params.leftMargin > screen_width || params.leftMargin <= -fish_width){
                    fish.setVisibility(fish.INVISIBLE);
                    fish.setAlive(false);
                    rl.post(new Runnable() { public void run() { rl.removeView(fish); }});
                    fishes_list.remove(fish);
                    break;
                }
                params.leftMargin += fish.getX_speed();
                params.topMargin += fish.getY_speed();
                params.rightMargin = screen_width - (params.leftMargin - fish_width);
                params.bottomMargin = screen_height - (params.topMargin - fish_height);
                fish.post(new Runnable() {
                    @Override
                    public void run() {
                        fish.setLayoutParams(params);
                    }
                });
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createFish(){
        Fish fish = new Fish(this);
        int fish_num = rand.nextInt(availableFishesType);
        fish.setData(rand.nextInt(screen_width), rand.nextInt(screen_height - start_Y) + start_Y, fish_num + 1);
        fish.setImageResource(fishes[fish_num]);
        if(fish.getX_speed() > 0) fish.setScaleX(-1);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(fish_width, fish_height);
        if(fish.getX_pos() >= screen_width - fish_width) fish.setX_pos(fish.getX_pos() - fish_width);
        if(fish.getY_pos() >= screen_height - fish_height) fish.setY_pos(fish.getY_pos() - fish_height);
        params.leftMargin = fish.getX_pos();
        params.topMargin = fish.getY_pos();;
        params.rightMargin = screen_width - (params.leftMargin - fish_width);
        params.bottomMargin = screen_height - (params.topMargin - fish_height);
        rl.post(new Runnable() {
            @Override
            public void run() { try
            {
                rl.addView(fish, params);
                fishes_list.add(fish);
                FishMoveThread FMT = new FishMoveThread(fish);
                FMT.start();
            } catch (IllegalStateException e) { e.printStackTrace(); }}
        });
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int eventAction = event.getAction();
            switch (eventAction) {
                case MotionEvent.ACTION_DOWN:
                    try {
                        if (time > 0 && !pause && !ended) {
                            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[fishes_list.size()];
                            for (int i = 0; i < params.length; i++) {
                                params[i] = (RelativeLayout.LayoutParams) fishes_list.get(i).getLayoutParams();
                            }
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            Boolean touched = false;
                            for (int i = 0; i < params.length; i++) {
                                if (x >= params[i].leftMargin && x <= params[i].leftMargin + fish_width &&
                                        y >= params[i].topMargin && y <= params[i].topMargin + fish_height) {
                                    Fish temp = fishes_list.get(i);
                                    score += temp.getScore();
                                    if (score > maxScore) score = maxScore;
                                    if (temp.getFishType() != 4 && temp.getFishType() != 9) {
                                        sound.playHitSound();
                                    } else {
                                        sound.playHighScoreFish();
                                    }
                                    touched = true;
                                    game_score.setText(String.format("%d / %d",score,maxScore));
                                    temp.setAlive(false);
                                    temp.setVisibility(temp.INVISIBLE);
                                    rl.post(new Runnable() { public void run() { rl.removeView(temp); }});
                                    fishes_list.remove(temp);
                                    rl.invalidate();
                                    break;
                                }
                            }
                            if (y >= start_Y && !(touched)){
                                sound.playWrong();
                                score -= 30;
                                if (score < 0) score = 0;
                                game_score.setText(String.format("%d / %d",score,maxScore));
                            }
                            progressBar.setProgress(score);
                            if (score == maxScore){
                                isWin = true;
                                endGame(true);
                            }
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){ e.printStackTrace(); }
                    catch(IndexOutOfBoundsException e){ e.printStackTrace(); }
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onPause() {
        bgm_length = backgroundMusic.getCurrentPosition();
        backgroundMusic.stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        if(!pause) {
            if (backgroundMusic.isPlaying()) backgroundMusic.stop();
            backgroundMusic = MediaPlayer.create(this, R.raw.underwater);
            backgroundMusic.setLooping(true);
            backgroundMusic.seekTo(bgm_length);
            backgroundMusic.start();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        backgroundMusic.stop();
        super.onStop();
    }

    private void endGame(boolean isWin){
        ended = true;
        if (isWin && level < 100) {
            ib_retry.setImageResource(R.drawable.button_nextlevel);
            if(db.getMaxLevel() == level) db.setMaxLevel(level + 1);
        }
        backgroundMusic.stop();
        CountDownTimer.cancel();
        ib_pause.setVisibility(ib_pause.INVISIBLE);
        if (isWin) {
            sound.playWin();
            AnimateSlideInOut(iv_victory, true, 900, screen_width);
        }
        else{
            sound.playLose();
            AnimateSlideInOut(iv_timesup, true, 900, screen_width);
        }
        AnimateSlideInOut(ib_quit, true, 900, screen_width);
        AnimateSlideInOut(ib_retry, true, 900, screen_width);
        rl.post(new Runnable() {
            @Override
            public void run() {
                for (Fish fish : fishes_list){
                    fish.setAlive(false);
                    fish.setVisibility(fish.INVISIBLE);
                    rl.removeView(fish);
                }
                fishes_list.clear();
                rl.invalidate();
            }
        });
    }
}