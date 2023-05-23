package com.example.kos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class awal_class extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awal);

        new Handler().postDelayed(() -> {
            Intent home=new Intent(awal_class.this, login_class.class);
            startActivity(home);
            finish();
        },2000); //2 detik
    }

}