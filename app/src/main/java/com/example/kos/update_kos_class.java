package com.example.kos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update_kos_class extends AppCompatActivity {

    protected Cursor cursor;
    sqlite_tambah dbhelper;
    Button update;
    EditText nama,alamat,jumlahkamar,fasilitas,jarak,harga,hp,jk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_kos_main);

        dbhelper = new sqlite_tambah(this);
        nama = (EditText) findViewById(R.id.updatenamakos);
        alamat = (EditText) findViewById(R.id.updatealamatkos);
        hp = (EditText) findViewById(R.id.updatenohp);
        jk = (EditText) findViewById(R.id.updatejeniskamar);
        jumlahkamar=(EditText) findViewById(R.id.updatejumlahkamar);
        fasilitas=(EditText) findViewById(R.id.updatefasilitaskamar);
        jarak=(EditText) findViewById(R.id.updatejarakkos);
        harga=(EditText) findViewById(R.id.updatehargakos);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datakos WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
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

        update = (Button) findViewById(R.id.btn_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                db.execSQL("update datakos set nama='"+
                        alamat.getText().toString() +"', alamat='" +
                        hp.getText().toString()+"', nohp='"+
                        jumlahkamar.getText().toString()+"', jumlahkamar='"+
                        fasilitas.getText().toString()+"', fasilitas='"+
                        jarak.getText().toString() +"', jarak='" +
                        harga.getText().toString() +"', harga='" +
                        jk.getText().toString() +"', jk='" +
                        nama.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                disewakan_class.ma.RefreshList();
                finish();
            }
        });
    }
}