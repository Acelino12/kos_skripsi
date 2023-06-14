package com.example.kos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlite_time extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "waktu.db";
    private static final int DATABASE_VERSION = 1;
    public sqlite_time(Context context){ super(context, DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table datawaktu(no integer primary key, waktu text null);";
        Log.d("data","onCreate: " + sql );
        db.execSQL(sql);
        sql = "INSERT INTO datawaktu(waktu)VALUES('5');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
