package com.example.kos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ubm_class extends AppCompatActivity {

    String[] daftar;
    ListView ListViewubm;
    Menu menu;
    protected Cursor cursor;
    sqlite_tambah dbcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubm_main);

        dbcenter = new sqlite_tambah(this);
        RefreshList();
    }

    private void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datakos",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListViewubm = (ListView)findViewById(R.id.listViewubm);
        ListViewubm.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListViewubm.setSelected(true);
        ListViewubm.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                Intent i = new Intent(getApplicationContext(), lihat_kos_ubm_class.class);
                i.putExtra("nama", selection);
                startActivity(i);
            }});
        ((ArrayAdapter)ListViewubm.getAdapter()).notifyDataSetInvalidated();
    }
}