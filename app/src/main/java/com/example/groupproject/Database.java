package com.example.groupproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Level.db";
    private static final String LEVEL_COLUMN_ID = "id";
    public static final String LEVEL_COLUMN_MAX_LEVEL = "max_lv";

    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table levels " +
                "(id INTEGER PRIMARY KEY, max_lv INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS levels");
        onCreate(db);
    }

    public boolean setMaxLevel(int maxLevel) {
        SQLiteDatabase db = this.getWritableDatabase();
        try { db.delete("levels", "id = ? ", new String[]{Integer.toString(1)}); }
        catch(Exception e){ return false;}
        ContentValues contentValues = new ContentValues();
        contentValues.put("max_lv", maxLevel);
        db.insert("levels", null, contentValues);
        return true;
    }

    public boolean initializeLevel(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("max_lv", 1);
        db.insert("levels", null, contentValues);
        return true;
    }

    public int getMaxLevel(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from levels", null );
        c.moveToFirst();
        int data = -1;
        while (!c.isAfterLast()) {
            data = c.getInt(c.getColumnIndex(LEVEL_COLUMN_MAX_LEVEL));
            c.moveToNext();
        }
        if(!c.isClosed()) c.close();
        return data;
    }
}
