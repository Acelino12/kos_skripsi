package com.example.kos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite_tambah extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "kos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + sqlite_kos.DataEntry.TABLE_NAME + " (" +
                    sqlite_kos.DataEntry._ID + " INTEGER PRIMARY KEY," +
                    sqlite_kos.DataEntry.COLUMN_NAMA + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_JUMLAH + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_NO_TEL + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_HARGA_KOST + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_JENIS_KELAMIN + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_FASILITAS + " TEXT," +
                    sqlite_kos.DataEntry.COLUMN_FASILITAS_UMUM + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + sqlite_kos.DataEntry.TABLE_NAME;

    public sqlite_tambah(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public long insertData(String nama,String jumlah, String nomorTelepon, String hargaKost, String jenisKelamin, String fasilitas, String fasilitasKamarMandi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(sqlite_kos.DataEntry.COLUMN_NAMA, nama);
        values.put(sqlite_kos.DataEntry.COLUMN_JUMLAH, jumlah);
        values.put(sqlite_kos.DataEntry.COLUMN_NO_TEL, nomorTelepon);
        values.put(sqlite_kos.DataEntry.COLUMN_HARGA_KOST, hargaKost);
        values.put(sqlite_kos.DataEntry.COLUMN_JENIS_KELAMIN, jenisKelamin);
        values.put(sqlite_kos.DataEntry.COLUMN_FASILITAS, fasilitas);
        values.put(sqlite_kos.DataEntry.COLUMN_FASILITAS_UMUM, fasilitasKamarMandi);

        long newRowId = db.insert(sqlite_kos.DataEntry.TABLE_NAME, null, values);
        db.close();

        return newRowId;
    }

}
