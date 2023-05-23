package com.example.kos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class home_class extends AppCompatActivity {

    CardView tambah,sewa,disewakan;
    CardView ubm,ui,ipb,ugm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

        tambah = findViewById(R.id.tambah_home);
        tambah.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, tambah_class.class);
            startActivity(secondActivity);
        });

        sewa = findViewById(R.id.sewa_home);
        sewa.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, sewa_class.class);
            startActivity(secondActivity);
        });

        disewakan = findViewById(R.id.disewakan_home);
        disewakan.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, disewakan_class.class);
            startActivity(secondActivity);
        });

        ubm = findViewById(R.id.ubm_home);
        ubm.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, ubm_class.class);
            startActivity(secondActivity);
        });

        ui = findViewById(R.id.ui_home);
        ui.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, ui_class.class);
            startActivity(secondActivity);
        });

        ipb = findViewById(R.id.ipb_home);
        ipb.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, ipb_class.class);
            startActivity(secondActivity);
        });

        ugm = findViewById(R.id.ugm_home);
        ugm.setOnClickListener(view ->{
            Intent secondActivity = new Intent(home_class.this, ugm_class.class);
            startActivity(secondActivity);
        });

    }


}
