package com.example.kos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlite_tambah extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "datakos.db";
    private static final int DATABASE_VERSION = 1;
    public sqlite_tambah(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table datakos(no integer primary key," +
                "nama text null," +
                "alamat text null, " +
                "jumlahkamar text null, " +
                "jk text null," +
                "fasilitas text null, " +
                "hp text null, " +
                "jarak text null, " +
                "harga text null);";
        Log.d("data","onCreate: " + sql );
        db.execSQL(sql);
        sql = "INSERT INTO datakos(nama,alamat,jumlahkamar,jk,fasilitas,hp,jarak,harga)" +
                "VALUES('Kos BAMBANG','jl. panarukan','5','pria','meja,kursi,lemari','082567651122','200','1000000');";
        db.execSQL(sql);
        sql = "INSERT INTO datakos(nama,alamat,jumlahkamar,jk,fasilitas,hp,jarak,harga)" +
                "VALUES('Kos Merdeka','jl. panarukan','5','pria','meja,kursi,lemari','082567651122','200','500000');";
        db.execSQL(sql);
        sql = "INSERT INTO datakos(nama,alamat,jumlahkamar,jk,fasilitas,hp,jarak,harga)" +
                "VALUES('Kos Salim','jl. panarukan','5','pria','meja,kursi,lemari','082567651122','200','500000');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}