package com.android.pkbv2.perlengkapan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pkbv2.R;

//class ini digunakan untuk membangun tampilan pada activity_perlengkapan_detail.xmlxml sebagai sebuah activity
public class PerlengkapanDetail extends AppCompatActivity {

    //inisialisasi variabel
    TextView NamaAlat, DetailAlat;
    ImageView Gambar, share, back;
    String nama;
    String detail;
    int image_link;

    //membuat sebuah tampilan dengan konten layout activity_perlengkapan_detail
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perlengkapan_detail);

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada PerlengkapanAdapter
        Bundle bundle = getIntent().getExtras();
        //variabel ini akan berubah menjadi data yang dibentuk dari PerlengkapanAdapter, mendapatkan string
        // dari key value "nama_alat", "detail", dan "gambar" pada PerlengkapanAdapter.java
        nama = bundle.getString("nama_alat");
        detail= bundle.getString("detail");
        image_link = getIntent().getIntExtra("gambar",R.mipmap.ic_launcher);

        //inisialisasi id pada activity_perlengkapan_detailail.xml
        Gambar = findViewById(R.id.gambar);
        NamaAlat = findViewById(R.id.namaAlat);
        DetailAlat = findViewById(R.id.detail);
        share = findViewById(R.id.share);
        back = findViewById(R.id.back);
        //men set Gambar sebagai image_link
        Gambar.setImageResource(image_link);
        //men set NamaAlat sebagai nama
        NamaAlat.setText(nama);
        //men set DetailAlat sebagai detail
        DetailAlat.setText(detail);

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

