package com.android.pkbv2.peralatan;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import com.android.pkbv2.R;

//clas PeralatanActivity digunakan untuk membangun tampilan activity_peralatan.xml sebagai sebuah activity
public class PeralatanActivity extends Activity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_beranda.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari Peralatan.java
    ArrayList<Peralatan> list = new ArrayList<Peralatan>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.drawable.dokumen, R.drawable.gps, R.drawable.helm, R.drawable.jaket,
    R.drawable.jashujan,R.drawable.kuncipas,R.drawable.masker,R.drawable.obat,R.drawable.protector,
    R.drawable.sarungtangan};

    //inisialisasi ArrayString namaAlat dan detailAlat
    String[] namaAlat, detailAlat;
    ImageView btn_back;

    //OnCreate membuat interface dan setContentView men set layout activity_peralatan.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peralatan);

        //menampilkan array berdasarkan strings.xml yang bernama namaAlat
        namaAlat = getResources().getStringArray(R.array.namaAlat);
        //menampilkan array berdasarkan strings.xml yang bernama detailAlat
        detailAlat= getResources().getStringArray(R.array.detailAlat);

        //kondisi perulangan untuk namaAlat pada Daftar Peralatan dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        int count = 0;
        for(String Nama : namaAlat)
        {
            Peralatan peralatan = new Peralatan(gambar[count],Nama,detailAlat[count]);
            count++;
            list.add(peralatan);
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = new GridLayoutManager(this,2);
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        //adapter list membuat list berdasarkan item2 pada PeralatanAdapter
        adapter = new PeralatanAdapter(list,this);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}


