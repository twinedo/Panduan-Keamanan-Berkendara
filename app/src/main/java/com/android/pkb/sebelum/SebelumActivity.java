package com.android.pkb.sebelum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import com.android.pkb.R;

//clas SebelumActivity digunakan untuk membangun tampilan activity_sebelum.xml sebagai sebuah activity
public class SebelumActivity extends Activity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari Sebelum.java
    ArrayList<Sebelum> list = new ArrayList<Sebelum>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.mipmap.berdoa, R.mipmap.ban, R.mipmap.cekmesin, R.mipmap.fisik,
            R.mipmap.lampu,R.mipmap.map};

    //inisialisasi ArrayString namaSbl dan detailSbl
    String[] namaSbl, detailSbl;

    //OnCreate membuat interface dan setContentView men set layout activity_sebelum.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebelum);

        //getActionBar untuk mengatur action pada toolbar activity_sebelum_list.xml
        // setDisplayHome berfungsi untuk menampilkan tampilan sebelumnya (activity_sebelum.xml)
        // setHomeButton berfungsi men set action bar sebagai tombol kembali ke tampilan sebelumnya
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

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
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //adapter list membuat list berdasarkan item2 pada SebelumAdapter
        adapter = new SebelumAdapter(list,this);
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
                // overridePendingTransition(R.animator.anim_left, R.animator.anim_right);
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


