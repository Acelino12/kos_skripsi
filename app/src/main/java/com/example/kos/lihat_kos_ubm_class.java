package com.example.kos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class lihat_kos_ubm_class extends AppCompatActivity {

    protected Cursor cursor;
    sqlite_tambah dbhelper;
    TextView nama,alamat,jumlahkamar,fasilitas,jarak,harga,hp,jk;

    Button telfon,sewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_kos_ubm_main);

        dbhelper = new sqlite_tambah(this);
        nama=(TextView) findViewById(R.id.tampilnamakosubm);
        alamat=(TextView) findViewById(R.id.tampilalamatkosubm);
        hp=(TextView) findViewById(R.id.tampilnohpubm);
        jk=(TextView) findViewById(R.id.tampiljeniskamarubm);
        jumlahkamar=(TextView) findViewById(R.id.tampiljumlahkamarubm);
        fasilitas=(TextView) findViewById(R.id.tampilfasilitaskamarubm);
        jarak=(TextView) findViewById(R.id.tampiljarakkosubm);
        harga=(TextView) findViewById(R.id.tampilhargakosubm);

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

        telfon = (Button) findViewById(R.id.telfon);
        telfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toDial="tel:"+hp.getText().toString();

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
            }
        });

        sewa = (Button) findViewById(R.id.sewakos);
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(lihat_kos_ubm_class.this, waktu_class.class);
                startActivity(secondActivity);
            }
        });
    }
}