package com.example.groupproject;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;
    private static int highScoreFish;
    private static int hitWrong;
    private static int pause, lose, win;

    public SoundPlayer(Context context){

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,5);
        highScoreFish = soundPool.load(context, R.raw.coin,1);
        hitSound = soundPool.load(context,R.raw.smb_kick,1);
        hitWrong = soundPool.load(context,R.raw.smb_bump,1);
        pause = soundPool.load(context,R.raw.smb_pause,1);
        lose = soundPool.load(context,R.raw.game_over,1);
        win = soundPool.load(context,R.raw.course_clear,1);
    }

    public void playHighScoreFish(){
        soundPool.play(highScoreFish,1.0f,1.0f,1,0,1.0f);
    }

    public void playHitSound(){
        soundPool.play(hitSound,1.0f,1.0f,1,0,1.0f);
    }

    public void playWrong() { soundPool.play(hitWrong, 1.0f, 1.0f, 1, 0, 1.0f); }

    public void playPause() { soundPool.play(pause, 1.0f, 1.0f, 1, 0, 1.0f); }

    public void playLose() { soundPool.play(lose, 1.0f, 1.0f, 1, 0, 1.0f); }

    public void playWin() { soundPool.play(win, 1.0f, 1.0f, 1, 0, 1.0f); }

    public void stop() {soundPool.release();}
}
