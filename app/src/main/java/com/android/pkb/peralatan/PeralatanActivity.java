package com.android.pkb.peralatan;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import com.android.pkb.R;

//clas PeralatanActivity digunakan untuk membangun tampilan activity_peralatan.xml sebagai sebuah activity
public class PeralatanActivity extends Activity {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    RecyclerView.LayoutManager layoutManager;

    //inisialisasi ArrayList dari Peralatan.java
    ArrayList<Peralatan> list = new ArrayList<Peralatan>();

    //inisialisasi list gambar dari resource mipmap
    int[] gambar = {R.mipmap.dokumen, R.mipmap.gps, R.mipmap.helm, R.mipmap.jaket,
    R.mipmap.jashujan,R.mipmap.kuncipas,R.mipmap.masker,R.mipmap.obat,R.mipmap.protektor,
    R.mipmap.sarungtangan};

    //inisialisasi ArrayString namaAlat dan detailAlat
    String[] namaAlat, detailAlat;

    //OnCreate membuat interface dan setContentView men set layout activity_peralatan.xml
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peralatan);

        //getActionBar untuk mengatur action pada toolbar activity_peralatan_list.xml
        // setDisplayHome berfungsi untuk menampilkan tampilan sebelumnya (activity_peralatan.xml)
        // setHomeButton berfungsi men set action bar sebagai tombol kembali ke tampilan sebelumnya
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

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
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = new GridLayoutManager(this,2);
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //adapter list membuat list berdasarkan item2 pada PeralatanAdapter
        adapter = new PeralatanAdapter(list,this);
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


