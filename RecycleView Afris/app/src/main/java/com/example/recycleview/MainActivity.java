package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Mendeklarasikan recyclerview
    RecyclerView recyclerView;

    //Memanggil objek dari foods recycler adapter
    FoodsRecyclerViewAdapter adapter;

    //Membuat array list dari tipe foods
    ArrayList<Foods> objFoods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memanggil recyclerview dari ID
        recyclerView = findViewById(R.id.recyclerView);

        //Mengisi data objek foods
        objFoods.add(new Foods("Ayam Geprek Sa'i Ambulu", 4.3, "Jam Buka\n09:30-21:30 WIB", "Jl. Manggar No.59, Tegalsari, Ambulu, Kabupaten Jember, Jawa Timur 68172", "Ayam Geprek Sa'i adalah sebuah warung makan yang menjual ayam geprek dan lalapan. Selain itu juga Ayam Geprek Sa'i menyediakan nasi secara gratis dengan syarat harus di makan di tempat."));
        objFoods.add(new Foods("DAPOER DIRA", 4.3, "Jam Buka\n09:00-21:00 WIB", "MJ45+FQM, Sumberan, Ambulu, Kabupaten Jember, Jawa Timur 68172", "Dapoer Dira adalah sebuah restaurant yang memiliki banyak menu-menu makanan dan minuman, selain itu Dapoer Dira menyediakan tempat yang nyaman, bersih, modern, dan aesthetic. Di Dapoer Dira anda bisa membeli banyak makanan dan minuman yang harganya sangat terjangkau."));
        objFoods.add(new Foods("Sate Naro Satkamda", 4.3, "Jam Buka\n17:00-23:00 WIB", "Jl. Kota Blater, Krajan, Ambulu, Kabupaten Jember, Jawa Timur 68172", "Pemilik dari warung makan Sate Naro Satkamda yaitu Ayah Ganesh. Beliau adalah penjual sate terkenal. Namanya Jadi, namun lebih akrab disapa Naro. Orangnya nyentrik. Kumisnya melintang lebat, jari-jarinya dihias cincin berbatu akik, dan suka mengendarai motor besar. Pak Jadi alias Naro adalah pengagum berat Soekarno. Pak Naro membuka warung sate kambing sejak tahun 1983. Dia menamai warungnya dengan Naro Satkamda. Satkamda sendiri adalah akronim dari sate kambing muda. Di masa mudanya, Pak Naro berpindah-pindah tempat untuk berjualan sate. Setelah sempat berjualan di sekitar pantai wisata Watu Ulo, ia akhirnya membuka warung sate di depan tempat pemotongan kayu milik Perhutani."));

        //Menerapkan adapter
        adapter = new FoodsRecyclerViewAdapter(objFoods);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}