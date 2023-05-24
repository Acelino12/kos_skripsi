package com.example.kos;

import android.provider.BaseColumns;

public final class sqlite_kos {
    private sqlite_kos(){}

    public static class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "kos";
        public static final String COLUMN_NAMA = "nama";
        public static final String COLUMN_JUMLAH = "jumlah_kamar";
        public static final String COLUMN_NO_TEL = "nomor_telefon";
        public static final String COLUMN_HARGA_KOST = "harga_kost";
        public static final String COLUMN_JENIS_KELAMIN = "jenis_kelamin";
        public static final String COLUMN_FASILITAS = "fasilitas";
        public static final String COLUMN_FASILITAS_UMUM = "fasilitas_kamar_mandi";
    }
}
