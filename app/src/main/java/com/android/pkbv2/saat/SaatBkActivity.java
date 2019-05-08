package com.android.pkbv2.saat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import com.android.pkbv2.R;

//clas SaatBkActivity digunakan untuk membangun tampilan activity_saatbk.xml sebagai sebuah activity
public class SaatBkActivity extends AppCompatActivity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari SaatBk.java
    ArrayList<SaatBk> list = new ArrayList<>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.drawable.pengguna, R.drawable.istirahat, R.drawable.rambu,  R.drawable.seatbelt, R.drawable.speedometer};

    //inisialisasi ArrayString namaSaatBk dan detailSaatBk
    String[] namaSaatBk;
    String[] detailSaatBk;

    ImageView btn_back;

    //OnCreate membuat interface dan setContentView men set layout activity_saatbk.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saatbk);

        //menampilkan array berdasarkan strings.xml yang bernama namaSaatBk
        namaSaatBk = getResources().getStringArray(R.array.namaSaatBk);
        //menampilkan array berdasarkan strings.xml yang bernama detailSaatBk
        detailSaatBk= getResources().getStringArray(R.array.detailSaatBk);


        //kondisi perulangan untuk namaSaatBk pada Persiapan dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        int count = 0;
        for(String Nama : namaSaatBk)
        {
            SaatBk saatbk = new SaatBk(gambar[count],Nama,detailSaatBk[count]);
            count++;
            list.add(saatbk);
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = new GridLayoutManager(this,2);
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //adapter list membuat list berdasarkan item2 pada SaatBkAdapter
        adapter = new SaatBkAdapter(list,this);
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


