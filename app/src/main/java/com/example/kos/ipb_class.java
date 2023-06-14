package com.example.kos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ipb_class extends AppCompatActivity {

    private RecyclerView rvkos;

    private ArrayList<kos_ui> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipb_main);

        rvkos = findViewById(R.id.rv_kosui);
        rvkos.setHasFixedSize(true);

        list.addAll(data_kos_ui.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvkos.setLayoutManager(new LinearLayoutManager(this));
        list_kos_ui list_kos_ui = new list_kos_ui(list);
        rvkos.setAdapter(list_kos_ui);

        list_kos_ui.setOnItemClickCallback(new list_kos_ui.OnItemClickCallback() {
            @Override
            public void onItemClicked(kos_ui kos_ui) {
                Intent move = new Intent(ipb_class.this, detailkosui.class);
                move.putExtra(detailkosui.ITEM_EXTRA, kos_ui);
                startActivity(move);
            }
        });
    }
}
