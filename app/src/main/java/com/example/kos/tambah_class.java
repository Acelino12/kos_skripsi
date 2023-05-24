package com.example.kos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tambah_class extends AppCompatActivity {

    private EditText namakos, jumlahkamar, hargakos, nohp;

    private RadioGroup rgjeniskelamin;

    private CheckBox cbpenjaga,cbcctv,cbdapur,cbjemur,cbcuci,cbkulkas,
            cbwifi, cbvetilasi, cbjendela, cbcermin, cbkursi, cbmeja,
            cblemari, cbkasur, cbguling, cbbantal, cbac;

private sqlite_tambah sqlite_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_main);

        namakos = findViewById(R.id.namakos);
        jumlahkamar = findViewById(R.id.jumlahkamar);
        hargakos = findViewById(R.id.hargakos);
        nohp = findViewById(R.id.nohp);

        rgjeniskelamin = findViewById(R.id.rgjeniskelamin);

        cbac = findViewById(R.id.cbac);
        cbbantal = findViewById(R.id.cbbantal);
        cbguling = findViewById(R.id.cbguling);
        cbkasur = findViewById(R.id.cbkasur);
        cblemari = findViewById(R.id.cblemari);
        cbmeja = findViewById(R.id.cbmeja);
        cbkursi = findViewById(R.id.cbkursi);
        cbcermin = findViewById(R.id.cbcermin);
        cbjendela = findViewById(R.id.cbjendela);
        cbvetilasi = findViewById(R.id.cbvetilasi);

        cbwifi = findViewById(R.id.cbwifi);
        cbkulkas = findViewById(R.id.cbkulkas);
        cbjemur = findViewById(R.id.cbjemur);
        cbcuci = findViewById(R.id.cbcuci);
        cbdapur = findViewById(R.id.cbdapur);
        cbcctv = findViewById(R.id.cbcctv);
        cbpenjaga = findViewById(R.id.cbpenjaga);

        Button btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });

        sqlite_tambah = new sqlite_tambah(this);

    }

    private void simpanData() {
        String nama = namakos.getText().toString().trim();
        String jumlahkos = jumlahkamar.getText().toString().trim();
        String hargaKost = hargakos.getText().toString().trim();
        String nomerhp = nohp.getText().toString().trim();

        int selectedRadioButtonId = rgjeniskelamin.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String jenisKelamin = selectedRadioButton.getText().toString();

        StringBuilder fasilitasKamar = new StringBuilder();
        if (cbac.isChecked()) {
            fasilitasKamar.append("AC, ");
        }
        if (cbbantal.isChecked()) {
            fasilitasKamar.append("Bantal, ");
        }
        if (cbguling.isChecked()) {
            fasilitasKamar.append("Guling, ");
        }
        if (cbkasur.isChecked()) {
            fasilitasKamar.append("Kasur, ");
        }
        if (cblemari.isChecked()) {
            fasilitasKamar.append("Lemari, ");
        }
        if (cbmeja.isChecked()) {
            fasilitasKamar.append("Meja, ");
        }
        if (cbkursi.isChecked()) {
            fasilitasKamar.append("Kursi, ");
        }
        if (cbcermin.isChecked()) {
            fasilitasKamar.append("Cermin, ");
        }
        if (cbjendela.isChecked()) {
            fasilitasKamar.append("Jendela, ");
        }
        if (cbvetilasi.isChecked()) {
            fasilitasKamar.append("Ventilasi, ");
        }


        StringBuilder fasilitasumum = new StringBuilder();
        if (cbwifi.isChecked()) {
            fasilitasumum.append("WIFI, ");
        }
        if (cbkulkas.isChecked()) {
            fasilitasumum.append("Kulkas, ");
        }
        if (cbjemur.isChecked()) {
            fasilitasumum.append("R. Jemur, ");
        }
        if (cbcuci.isChecked()) {
            fasilitasumum.append("R. Cuci, ");
        }
        if (cbdapur.isChecked()) {
            fasilitasumum.append("Dapur, ");
        }
        if (cbcctv.isChecked()) {
            fasilitasumum.append("CCTV, ");
        }
        if (cbpenjaga.isChecked()) {
            fasilitasumum.append("Penjaga Kos, ");
        }


        if (nama.isEmpty() || jumlahkos.isEmpty() || hargaKost.isEmpty()) {
            Toast.makeText(this, "Lengkapi data", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = sqlite_tambah.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(sqlite_kos.DataEntry.COLUMN_NAMA, nama);
        values.put(sqlite_kos.DataEntry.COLUMN_NO_TEL, nomerhp);
        values.put(sqlite_kos.DataEntry.COLUMN_JUMLAH, jumlahkos);
        values.put(sqlite_kos.DataEntry.COLUMN_HARGA_KOST, hargaKost);
        values.put(sqlite_kos.DataEntry.COLUMN_JENIS_KELAMIN, jenisKelamin);
        values.put(sqlite_kos.DataEntry.COLUMN_FASILITAS, fasilitasKamar.toString());
        values.put(sqlite_kos.DataEntry.COLUMN_FASILITAS_UMUM, fasilitasumum.toString());

        long newRowId = db.insert(sqlite_kos.DataEntry.TABLE_NAME, null, values);

        if (newRowId != -1) {
            clearInputFields();
        }
    }

    private void clearInputFields() {
        namakos.setText("");
        jumlahkamar.setText("");
        hargakos.setText("");
        nohp.setText("");

        rgjeniskelamin.clearCheck();

        cbac.setChecked(false);
        cbbantal.setChecked(false);
        cbguling.setChecked(false);
        cbkasur.setChecked(false);
        cblemari.setChecked(false);
        cbmeja.setChecked(false);
        cbkursi.setChecked(false);
        cbcermin.setChecked(false);
        cbjendela.setChecked(false);
        cbvetilasi.setChecked(false);

        cbwifi.setChecked(false);
        cbkulkas.setChecked(false);
        cbjemur.setChecked(false);
        cbcuci.setChecked(false);
        cbdapur.setChecked(false);
        cbcctv.setChecked(false);
        cbpenjaga.setChecked(false);
    }

}
