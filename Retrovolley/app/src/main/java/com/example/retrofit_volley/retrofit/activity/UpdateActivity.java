package com.example.retrofit_volley.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit_volley.R;
import com.example.retrofit_volley.retrofit.API.APIRequestData;
import com.example.retrofit_volley.retrofit.API.RetroServer;
import com.example.retrofit_volley.retrofit.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private EditText formNama, formNoTelp, formEmail, formAlamat, formPassword;
    private int id;
    private String nama, noTelp, email, alamat, password, gformNama, gformNoTelp, gformEmail, gformAlamat, gformPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent terimaData = getIntent(); // Menerima data dari adapter data
        id = terimaData.getIntExtra("id", -1);
        nama = terimaData.getStringExtra("nama");
        noTelp = terimaData.getStringExtra("noTelp");
        email = terimaData.getStringExtra("email");
        alamat = terimaData.getStringExtra("alamat");
        password = terimaData.getStringExtra("password");

        formNama = findViewById(R.id.formNama);
        formNoTelp = findViewById(R.id.formNoTelp);
        formEmail = findViewById(R.id.formEmail);
        formAlamat = findViewById(R.id.formAlamat);
        formPassword = findViewById(R.id.formPassword);

        formNama.setText(nama);
        formNoTelp.setText(noTelp);
        formEmail.setText(email);
        formAlamat.setText(alamat);
        formPassword.setText(password);
    }

    private void updateData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> updateData = ardData.ardUpdateData(id, gformNama, gformNoTelp, gformEmail, gformAlamat, gformPassword);

        updateData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UpdateActivity.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Tidak Berhasil Untuk Daftar: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void actionPerbarui(View view) {
        // Mengirim data dari inputan
        gformNama = formNama.getText().toString();
        gformNoTelp = formNoTelp.getText().toString();
        gformEmail = formEmail.getText().toString();
        gformAlamat = formAlamat.getText().toString();
        gformPassword = formPassword.getText().toString();

        updateData();
    }
}