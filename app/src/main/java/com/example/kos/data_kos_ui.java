package com.example.kos;

import java.util.ArrayList;

public class data_kos_ui {

    private static String[] namekos={
            "Kos Lasada", "Mamikos", "Kos Bunga", "Kos Melati",
            "Kos Slamet", "Kos Bu Endang", "Kos Kita", "Kos Mama", "Kos citra",
            "Kos Pelangi"
    };

    private static String[] ditailkos={
            "Harga 500000\n Jarak 400 meter \n\n 4 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Guling,Kasur \n\n Fasilitas Umum \n WIFI,kulkas,CCTV",
            "Harga 450000\n Jarak 300 meter \n\n 2 Kamar \n\n Fasilitas Kamar\n Bantal,Guling,Kasur,Lemari Baju \n\n Fasilitas Umum \n WIFI,kulkas,CCTV,Penjaga Kos,Dapur",
            "Harga 600000\n Jarak 500 meter \n\n 5 Kamar \n\n Fasilitas Kamar\n Bantal,Kasur,Lemari Baju \n\n Fasilitas Umum \n kulkas,CCTVDapur",
            "Harga 500000\n Jarak 800 meter \n\n 8 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Kasur,Lemari Baju,Cermin,Vetilasi,Meja Belajar \n\n Fasilitas Umum \n WIFI,kulkas,CCTV,Dapur",
            "Harga 550000\n Jarak 1200 meter \n\n 10 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Kasur,Lemari Baju \n\n Fasilitas Umum \n WIFI,Dapur",
            "Harga 400000\n Jarak 650 meter \n\n 1 Kamar \n\n Fasilitas Kamar\n Bantal,Guling,Kasur,Lemari Baju,Vetilasi \n\n Fasilitas Umum \n WIFI,kulkas,Dapur",
            "Harga 500000\n Jarak 750 meter \n\n 3 Kamar \n\n Fasilitas Kamar\n Bantal,Kasur,Lemari Baju,Cermin,Vetilasi,Meja Belajar \n\n Fasilitas Umum \n WIFI,CCTV,Penjaga Kos,Dapur",
            "Harga 1200000\n Jarak 700 meter \n\n 5 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Guling,Kasur,Lemari Baju,Cermin,Vetilasi,Meja Belajar \n\n Fasilitas Umum \n WIFI,kulkas,CCTV,Penjaga Kos,Dapur",
            "Harga 1500000\n Jarak 800 meter \n\n 6 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Guling,Kasur,Lemari Baju,Cermin,Vetilasi,Meja Belajar \n\n Fasilitas Umum \n WIFI,kulkas,CCTV,Penjaga Kos,Dapur",
            "Harga 750000\n Jarak 450 meter \n\n 3 Kamar \n\n Fasilitas Kamar\n AC,Bantal,Guling,Kasur,Lemari Baju,Cermin,Vetilasi,Meja Belajar \n\n Fasilitas Umum \n WIFI,kulkas,CCTV,Penjaga Kos,Dapur",
    };

    private static int[] kosimage={
        R.drawable.kosui1,R.drawable.kosui2,R.drawable.kosui3,
            R.drawable.kosui4,R.drawable.kosui5,R.drawable.kosui6,
            R.drawable.kosui7,R.drawable.kosui8,R.drawable.kosui9,
            R.drawable.kosui10
    };

    static ArrayList<kos_ui> getListData(){
        ArrayList<kos_ui> list = new ArrayList<>();
        for (int i = 0; i < namekos.length; i++){
            kos_ui kos_ui = new kos_ui();
            kos_ui.setName(namekos[i]);
            kos_ui.setDetail(ditailkos[i]);
            kos_ui.setPhoto(kosimage[i]);
            list.add(kos_ui);
        }
        return list;
    }
}
