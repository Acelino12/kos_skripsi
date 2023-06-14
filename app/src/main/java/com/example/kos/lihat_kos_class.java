package com.example.kos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class lihat_kos_class extends AppCompatActivity {

    protected Cursor cursor;
    sqlite_tambah dbhelper;
    TextView nama,alamat,jumlahkamar,fasilitas,jarak,harga,hp,jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_kos_main);

        dbhelper = new sqlite_tambah(this);
        nama=(TextView) findViewById(R.id.tampilnamakos);
        alamat=(TextView) findViewById(R.id.tampilalamatkos);
        hp=(TextView) findViewById(R.id.tampilnohp);
        jk=(TextView) findViewById(R.id.tampiljeniskamar);
        jumlahkamar=(TextView) findViewById(R.id.tampiljumlahkamar);
        fasilitas=(TextView) findViewById(R.id.tampilfasilitaskamar);
        jarak=(TextView) findViewById(R.id.tampiljarakkos);
        harga=(TextView) findViewById(R.id.tampilhargakos);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datakos WHERE nama = '"+
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(1).toString());
            alamat.setText(cursor.getString(2).toString());
            jumlahkamar.setText(cursor.getString(3).toString());
            jk.setText(cursor.getString(4).toString());
            fasilitas.setText(cursor.getString(5).toString());
            hp.setText(cursor.getString(6).toString());
            jarak.setText(cursor.getString(7).toString());
            harga.setText(cursor.getString(8).toString());
        }
    }
}