package com.example.retrofit_volley.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit_volley.R;
import com.example.retrofit_volley.retrofit.API.APIRequestData;
import com.example.retrofit_volley.retrofit.API.RetroServer;
import com.example.retrofit_volley.retrofit.model.DataModel;
import com.example.retrofit_volley.retrofit.model.LoginRequest;
import com.example.retrofit_volley.retrofit.model.LoginResponse;
import com.example.retrofit_volley.retrofit.model.ResponseModel;
import com.example.retrofit_volley.volley.LoginVolleyActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_retrofit);
    }
}