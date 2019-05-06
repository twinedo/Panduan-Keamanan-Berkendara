package com.android.pkbv2.saat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pkbv2.R;

//class ini digunakan untuk membangun tampilan pada activity_saatbk_detail.xml sebagai sebuah activity
public class SaatBkDetail extends AppCompatActivity {

    //inisialisasi variabel
    TextView NamaSaatBk, DetailSaatBk;
    ImageView Gambar, share, back;;
    String nama, detail;
    int image_link;

    //membuat sebuah tampilan dengan konten layout activity_saatbk_detail.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saatbk_detail);

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada SaatBkAdapter
        Bundle bundle = getIntent().getExtras();
        //variabel ini akan berubah menjadi data yang dibentuk dari SaatBkAdapter, mendapatkan string
        // dari key value "nama_saatbk", "detail", dan "gambar" pada SaatBkAdapter.java
        nama = bundle.getString("nama_saatbk");
        detail= bundle.getString("detail");
        image_link = getIntent().getIntExtra("gambar",R.mipmap.ic_launcher);

        //inisialisasi id pada activity_saatbk_detail.xml
        Gambar = findViewById(R.id.gambar);
        NamaSaatBk = findViewById(R.id.namaSaatbk);
        DetailSaatBk = findViewById(R.id.detail);
        share = findViewById(R.id.share);
        back = findViewById(R.id.back);
        //men set Gambar sebagai image_link
        Gambar.setImageResource(image_link);
        //men set NamaSaatBk sebagai nama
        NamaSaatBk.setText(nama);
        //men set DetailSaatBk sebagai detail
        DetailSaatBk.setText(detail);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bagikan = new Intent(Intent.ACTION_SEND);
                //tipe file dari variabel Bagikan, * pertama adalah tipe file, dan  * kedua berupa format file tersebut
                Bagikan.setType("text/*");
                // menempatkan file ke Intent
                Bagikan.putExtra(Intent.EXTRA_TEXT,
                        "Salah satu hal yang harus diperhatikan dalam berkendara yaitu:"+
                                "\n"+
                                "\n"+"*"+nama+"*"+
                                "\n"+
                                "\nDeskripsi : "+detail.split("\\.")[0].trim()+"....."+
                                "\n"+
                                "Selengkapnya ada di:"+
                                "\n"+
                                "\nhttps://play.google.com/store/apps/details?id=" +getPackageName());

                //menampilkan pilihan aplikasi untuk dishare
                startActivity(Intent.createChooser(Bagikan, "Bagikan via:"));
            }
        });
    }

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    @Override
    public void onBackPressed() {
        finish();
    }

}

