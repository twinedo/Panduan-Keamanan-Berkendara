package com.android.pkbv2.sebelum;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pkbv2.R;

//class ini digunakan untuk membangun tampilan pada activity_sebelum_detail.xml sebagai sebuah activity
public class SebelumDetail extends AppCompatActivity {

    //inisialisasi variabel
    TextView NamaSbl, DetailSbl;
    ImageView gambar, share, back;
    String nama, detail;
    int image_link;
    ConstraintLayout layoutdetail;

    //membuat sebuah tampilan dengan konten layout activity_sebelum_detail.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebelum_detail);

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada SebelumAdapter
        Bundle bundle = getIntent().getExtras();
        //variabel ini akan berubah menjadi data yang dibentuk dari SebelumAdapter, mendapatkan string
        // dari key value "nama_sbl", "detail", dan "gambar" pada Sebelumdapter.java
        nama = bundle.getString("nama_sbl");
        detail = bundle.getString("detail");
        image_link = getIntent().getIntExtra("gambar", R.mipmap.ic_launcher);

        //inisialisasi id pada activity_sebelum_detail.xml
        gambar = findViewById(R.id.gambar);
        NamaSbl = findViewById(R.id.namaSbl);
        DetailSbl = findViewById(R.id.detail);
        share = findViewById(R.id.share);
        back = findViewById(R.id.back);
        layoutdetail = findViewById(R.id.layoutdetail);

        //men set Gambar sebagai image_link
        gambar.setImageResource(image_link);
        //men set NamaSbl sebagai nama
        NamaSbl.setText(nama);
        //men set DetailSbl sebagai detail
        DetailSbl.setText(detail);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

