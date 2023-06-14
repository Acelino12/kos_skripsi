package com.example.kos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tambah_class extends AppCompatActivity {

    EditText namakos, jumlahkamar, hargakos, nohp,alamat,jarak,fasilitas,jeniskamar;
    Button simpan ;
    sqlite_tambah sqlite_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_main);

        sqlite_tambah = new sqlite_tambah(this);
        namakos = (EditText) findViewById(R.id.namakos);
        alamat = (EditText) findViewById(R.id.alamatkos);
        jeniskamar = (EditText) findViewById(R.id.jeniskamar);
        nohp = (EditText) findViewById(R.id.nohp);
        jumlahkamar = (EditText) findViewById(R.id.jumlahkamar);
        fasilitas = (EditText) findViewById(R.id.fasilitaskamar);
        jarak = (EditText) findViewById(R.id.jarakkos);
        hargakos = (EditText) findViewById(R.id.hargakos);

        simpan = findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = sqlite_tambah.getWritableDatabase();
                db.execSQL("insert into datakos(namakos, alamat, jumlahkamar, jeniskamar,fasilitas, nohp, jarak, hargakos) values('" +
                        namakos.getText().toString() + "','" +
                        alamat.getText().toString() + "','" +
                        jumlahkamar.getText().toString() + "','" +
                        jeniskamar.getText().toString() + "','" +
                        fasilitas.getText().toString() + "','" +
                        nohp.getText().toString() + "','" +
                        jarak.getText().toString() + "','" +
                        hargakos.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
