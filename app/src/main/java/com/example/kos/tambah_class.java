package com.example.kos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tambah_class extends AppCompatActivity {

    EditText nama,alamat,jumlahkamar,fasilitas,jarak,harga,hp,jk;
    Button simpan , chackjarak;
    sqlite_tambah dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_main);

        dbhelper = new sqlite_tambah(this);
        nama = (EditText) findViewById(R.id.namakos);
        alamat = (EditText) findViewById(R.id.alamatkos);
        jk = (EditText) findViewById(R.id.jeniskamar);
        hp = (EditText) findViewById(R.id.nohp);
        jumlahkamar = (EditText) findViewById(R.id.jumlahkamar);
        fasilitas = (EditText) findViewById(R.id.fasilitaskamar);
        jarak = (EditText) findViewById(R.id.jarakkos);
        harga = (EditText) findViewById(R.id.hargakos);

        simpan = findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                db.execSQL("insert into datakos(nama, alamat, jumlahkamar, jk,fasilitas, hp, jarak, harga) values('" +
                        nama.getText().toString() + "','" +
                        alamat.getText().toString() + "','" +
                        jumlahkamar.getText().toString() + "','" +
                        jk.getText().toString() + "','" +
                        fasilitas.getText().toString() + "','" +
                        hp.getText().toString() + "','" +
                        jarak.getText().toString() + "','" +
                        harga.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            }
        });

        chackjarak = findViewById(R.id.chackjarak);
        chackjarak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
