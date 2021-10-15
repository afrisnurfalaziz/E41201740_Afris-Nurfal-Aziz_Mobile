package com.afris.myapplicationafris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {

    //Mendeklarasikan Variabel
    TextView txtHello;
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Inisialisasi variabel txtHello
        txtHello = (TextView) findViewById(R.id.txtHello);

        //Membuat fungsi untuk mengirim data antar Activity
        Bundle extras = getIntent().getExtras();

        //Mengkonekkan antara MainActicity dengan ActivitySecond
        nama = extras.getString(KEY_NAME);
        //Membuat susunan kalimat pada tampilan output
        txtHello.setText("Hello, " + nama + " !");
    }
}