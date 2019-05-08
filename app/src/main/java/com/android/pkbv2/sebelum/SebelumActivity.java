package com.android.pkbv2.sebelum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import com.android.pkbv2.R;

//clas SebelumActivity digunakan untuk membangun tampilan activity_sebelum.xml sebagai sebuah activity
public class SebelumActivity extends AppCompatActivity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari Sebelum.java
    ArrayList<Sebelum> list = new ArrayList<Sebelum>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.drawable.berdoa, R.drawable.ban, R.drawable.bensin,R.drawable.fisik, R.drawable.map,R.drawable.cekmesin,
            R.drawable.lampu};

    //inisialisasi ArrayString namaSbl dan detailSbl
    String[] namaSbl, detailSbl;

    ImageView btn_back;

    //OnCreate membuat interface dan setContentView men set layout activity_sebelum.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebelum);

        //menampilkan array berdasarkan strings.xml yang bernama namaSbl
        namaSbl = getResources().getStringArray(R.array.namaSbl);
        //menampilkan array berdasarkan strings.xml yang bernama detailSbl
        detailSbl= getResources().getStringArray(R.array.detailSbl);

        //kondisi perulangan untuk namaSbl pada Sebelum dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        int count = 0;
        for(String Nama : namaSbl)
        {
            Sebelum sebelum = new Sebelum(gambar[count],Nama,detailSbl[count]);
            count++;
            list.add(sebelum);
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = new GridLayoutManager(SebelumActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //adapter list membuat list berdasarkan item2 pada SebelumAdapter
        adapter = new SebelumAdapter(list,SebelumActivity.this);
        //membangun interface recyclerView berdasarkan adapter
        recyclerView.setAdapter(adapter);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    @Override
    public void onBackPressed() {
        finish();
    }
}


