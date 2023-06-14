package com.example.kos;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class detailkosui extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailkosui);

        ImageView imgkos = findViewById(R.id.imgkos);
        TextView kosname = findViewById(R.id.kosname);
        TextView kosdetail = findViewById(R.id.kosdetail);

        kos_ui kos_ui = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(kos_ui != null){
            Glide.with(this)
                    .load(kos_ui.getPhoto())
                    .into(imgkos);
            kosname.setText(kos_ui.getName());
            kosdetail.setText(kos_ui.getDetail());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("detail kos");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
