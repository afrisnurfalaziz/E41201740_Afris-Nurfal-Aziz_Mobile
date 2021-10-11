package com.example.fragmentbuttonnavigation_afris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //Mendeklarasikan Buttom Navigation
    com.google.android.material.bottomnavigation.BottomNavigationView buttomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi buttomNavigation
        buttomNavigation = findViewById(R.id.buttomNavigation);

        //Membuat fragment default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new HomeFragment()).commit();

        //Memberikan aksi ketika buttom di klik
        buttomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Membuat objek dari fragment
                Fragment selectedFragment = null;

                //Membuat switch case
                switch(item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;

                    case R.id.search:
                        selectedFragment = new SearchFragment();
                        break;

                    case R.id.reels:
                        selectedFragment = new ReelsFragment();
                        break;

                    case R.id.store:
                        selectedFragment = new StoreFragment();
                        break;

                    case R.id.profile:
                        selectedFragment = new ProfilFragment();
                        break;
                }

                //Membuat fungi untuk merubah setiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, selectedFragment).commit();

                return true;
            }
        });
    }

}