package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailFoodsActivity extends AppCompatActivity {

    //Mendeklarasikan isi dari activity_detail_food
    TextView textViewTitle, textViewRating, textViewJamBuka, textViewAlamat, textViewDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        //mendeklarasikan semua textview
        textViewTitle = findViewById(R.id.Title);
        textViewRating = findViewById(R.id.Rating);
        textViewJamBuka = findViewById(R.id.JamBuka);
        textViewAlamat = findViewById(R.id.Alamat);
        textViewDeskripsi = findViewById(R.id.Deskripsi);

        //Memanggil data intent
        Foods foods = getIntent().getParcelableExtra("FOODS");
        textViewTitle.setText(foods.getTitle());
        textViewRating.setText(String.valueOf(foods.getRating()));
        textViewJamBuka.setText(foods.getJamBuka());
        textViewAlamat.setText(foods.getAlamat());
        textViewDeskripsi.setText(foods.getDeskripsi());
    }
}