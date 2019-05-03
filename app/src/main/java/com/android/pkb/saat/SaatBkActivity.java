package com.android.pkb.saat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import com.android.pkb.R;

//clas SaatBkActivity digunakan untuk membangun tampilan activity_saatbk.xml sebagai sebuah activity
public class SaatBkActivity extends Activity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari SaatBk.java
    ArrayList<SaatBk> list = new ArrayList<SaatBk>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.mipmap.rambu, R.mipmap.pengguna, R.mipmap.istirahat};

    //inisialisasi ArrayString namaSaatBk dan detailSaatBk
    String[] namaSaatBk, detailSaatBk;

    //OnCreate membuat interface dan setContentView men set layout activity_saatbk.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saatbk);

        //getActionBar untuk mengatur action pada toolbar activity_saatbk_list.xml
        // setDisplayHome berfungsi untuk menampilkan tampilan sebelumnya (activity_saatbk.xml)
        // setHomeButton berfungsi men set action bar sebagai tombol kembali ke tampilan sebelumnya
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

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
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 1
        layoutManager = new LinearLayoutManager(this);
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //adapter list membuat list berdasarkan item2 pada SaatBkAdapter
        adapter = new SaatBkAdapter(list,this);
        //membangun interface recyclerView berdasarkan adapter
        recyclerView.setAdapter(adapter);
    }

    //deklarasi fungsi dari getActionBar berdasarkan item yang dipilih
    //karena pada tampilan ini itemnya cuma satu, jadi kondisi di set jika menekan item maka akan memanggil
    //id home yang berarti kembali ke tampilan sebelumnya
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // This is the up button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    @Override
    public void onBackPressed() {
        finish();
    }


}


