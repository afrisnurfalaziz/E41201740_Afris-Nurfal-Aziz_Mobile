package com.example.retrofit_volley.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class Create_Activity extends AppCompatActivity {

    private EditText formNama, formNoTelp, formEmail, formAlamat, formPassword;
    private String nama, noTelp, email, alamat, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        formNama = findViewById(R.id.formNama);
        formNoTelp = findViewById(R.id.formNoTelp);
        formEmail = findViewById(R.id.formEmail);
        formAlamat = findViewById(R.id.formAlamat);
        formPassword = findViewById(R.id.formPassword);
    }

    public void actionDaftar(View view) {
        nama = formNama.getText().toString();
        noTelp = formNoTelp.getText().toString();
        email = formEmail.getText().toString();
        alamat = formAlamat.getText().toString();
        password = formPassword.getText().toString();

        if (nama.trim().equals("")) {
            formNama.setError("Data Harus Diisi!");
        } else if (noTelp.trim().equals("")) {
            formNoTelp.setError("Data Harus Diisi!");
        } else if (email.trim().equals("")) {
            formEmail.setError("Data Harus Diisi!");
        } else if (alamat.trim().equals("")) {
            formAlamat.setError("Data Harus Diisi!");
        } else if (password.trim().equals("")) {
            formPassword.setError("data Harus Diisi!");
        } else {
            simpanData();
        }
    }

    private void simpanData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class); // menghubungkan class interface ke retrofit
        Call<ResponseModel> simpanData = ardData.ardCreateData(nama, noTelp, email, alamat, password);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Create_Activity.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(Create_Activity.this, "Tidak Berhasil Untuk Daftar: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}