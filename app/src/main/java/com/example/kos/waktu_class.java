package com.example.kos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class waktu_class extends AppCompatActivity {

    sqlite_time sqlite_time;
    Button sewa;
    EditText waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waktu_main);

        sqlite_time = new sqlite_time(this);
        waktu=(EditText) findViewById(R.id.bulansewa);
        sewa=(Button) findViewById(R.id.btn_sewatime);

        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = sqlite_time.getWritableDatabase();
                db.execSQL("insert into datawaktu(waktu) values('" +
                        waktu.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}