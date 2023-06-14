package com.example.kos;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class sewa_class extends AppCompatActivity {

    String[] daftar;
    ListView listwaktu;
    Menu menu;
    protected Cursor cursor;
    sqlite_time dbwaktu;

    public static sewa_class wa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sewa_main);

        wa = this;
        dbwaktu = new sqlite_time(this);
        RefreshList();
    }

    private void RefreshList() {
        SQLiteDatabase db = dbwaktu.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datawaktu",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        listwaktu = (ListView) findViewById(R.id.listwaktu);
        listwaktu.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listwaktu.setSelected(true);
        listwaktu.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Hapus penyewaan kos"};
                AlertDialog.Builder builder = new AlertDialog.Builder(sewa_class.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                SQLiteDatabase db = dbwaktu.getWritableDatabase();
                                db.execSQL("delete from datawaktu where waktu = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)listwaktu.getAdapter()).notifyDataSetInvalidated();
    }
}
