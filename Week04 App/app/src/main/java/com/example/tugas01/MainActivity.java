package com.example.tugas01;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormatSymbols;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Mendeklarasikan variabel spinner, AutoCompleteTextView, dan listview
    Spinner golongan;
    AutoCompleteTextView autoCompleteTextView;
    ListView listviewukm;

    //Mendeklarasikan isi dari array yang digunakan untuk autoCompleteTextView
    private static final String[] prodi = new String[] {
            "Teknik Informatika", "Manajemen Informatika", "Teknik Komputer",
            "Teknik Informatika - Kampus Bondowoso", "Teknik Informatika - PSDKU Nganjuk",
            "Teknik Informatika - PSDKU Sidoarjo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Spinner
        golongan = findViewById(R.id.Gol);

        //Membuat fungsi untuk menampilkan list data dalam spinner menggunakan adapter dan memanggil value atau isi dari spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Gol, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        golongan.setAdapter(adapter);

        //Membuat action jika di klik akan memunculkan sebuah notif atau pesan
        golongan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String gol = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Golongan: " + gol, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Inisialisasi AutoCompleteTextView
        AutoCompleteTextView autocompletetext = findViewById(R.id.Prodi);

        //Membuat fungsi untuk menampilkan list data yang sudah di deklarasikan menggunakan array dengan adapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, prodi);
        autocompletetext.setAdapter(adapter1);

        //Membuat action jika di klik akan memunculkan sebuah notif atau pesan
        autocompletetext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getProdi = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Prodi: " + getProdi, Toast.LENGTH_SHORT).show();
            }
        });

        //Inisialisasi listview
        listviewukm = findViewById(R.id.listviewukm);

        //Mendeklarasikan isi dari listview dengan menggunakan array
        String[] ukm = {"Unit Kegiatan Mahasiswa English Club (E-CLUB)", "Unit Kegiatan Mahasiswa Olahraga (UKM-O)",
        "Unit Kegiatan Mahasiswa Pramuka Racana Arjuna-Srikandi Gugusdepan Jember 02.155-02.156 Pangkalan Politeknik Negeri Jember (RASPOL)",
        "Unit Kegiatan Mahasiswa Korps Suka Rela Palang Merah Indonesia Unit Politeknik Negeri Jember (KSR PMI UNIT POLIJE)",
        "Unit Kegiatan Mahasiswa Resimen Mahasiswa 877 (MENWA)", "Unit Kegiatan Mahasiswa Koperasi Mahasiswa BERDIKARI (KOPMA BERDIKARI)",
        "Unit Kegiatan Mahasiswa Paduan Suara Mahasiswa Gema Aluna Widjaja (PSM)", "Unit Kegiatan Mahasiswa Himpunan Mahasiswa Pecinta Alam BEKISAR (HIMAPALA BEKISAR)",
        "Unit Kegiatan Mahasiswa Lembaga Aktivis Islam Kampus (LABAIK)", "Unit Kegiatan Mahasiswa Persekutuan Mahasiswa Kristen (PMK)", "Unit Kegiatan Mahasiswa Lukis Musik Tari (LUMUT)",
        "Unit Kegiatan Mahasiswa Teater KOTAK", "Unit Kegiatan Mahasiswa Pers Mahasiswa EXPLANT (UKPM EXPLANT)", "Unit Kegiatan Mahasiswa Studi Karya Ilmiah Mahasiswa (SKIM)",
        "Unit Kegiatan Mahasiswa BARABAS Drum Corps (BARABAS DC)", "Unit Kegiatan Mahasiswa Robotika"};

        //Membuat fungsi untuk menampilkan list data yang sudah di deklarasikan dengan menggunakan adapter
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ukm);
        listviewukm.setAdapter(adapter2);

        //Membuat action jika di klik akan memunculkan sebuah notif atau pesan
        listviewukm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getukm = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Memilih UKM: " + getukm, Toast.LENGTH_SHORT).show();
            }
        });
    }
}