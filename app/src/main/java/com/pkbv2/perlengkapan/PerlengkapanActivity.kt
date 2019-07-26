package com.pkbv2.perlengkapan

import android.app.Activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import java.util.ArrayList
import com.pkbv2.R

//clas PerlengkapanActivity digunakan untuk membangun tampilan activity_perlengkapanpan.xml sebagai sebuah activity
class PerlengkapanActivity : Activity() {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_beranda.cml
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var adapter: RecyclerView.Adapter<*>
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    internal lateinit var layoutManager: RecyclerView.LayoutManager

    //inisialisasi ArrayList dari Perlengkapan.java
    internal var list = ArrayList<Perlengkapan>()

    //inisialisasi list gambar dari resource mipmap
    internal var gambar = intArrayOf(R.drawable.dokumen, R.drawable.gps, R.drawable.helm, R.drawable.jaket, R.drawable.jashujan, R.drawable.kuncipas, R.drawable.masker, R.drawable.obat, R.drawable.protector, R.drawable.sarungtangan)

    //inisialisasi ArrayString namaAlat dan detailAlat
    internal lateinit var namaAlat: Array<String>
    internal lateinit var detailAlat: Array<String>
    internal lateinit var btn_back: ImageView

    //OnCreate membuat interface dan setContentView men set layout activity_perlengkapanpan.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perlengkapan)

        //menampilkan array berdasarkan strings.xml yang bernama namaAlat
        namaAlat = resources.getStringArray(R.array.namaAlat)
        //menampilkan array berdasarkan strings.xml yang bernama detailAlat
        detailAlat = resources.getStringArray(R.array.detailAlat)

        //kondisi perulangan untuk namaAlat pada Daftar Perlengkapan dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        var count = 0
        for (Nama in namaAlat) {
            val perlengkapan = Perlengkapan(gambar[count], Nama, detailAlat[count])
            count++
            list.add(perlengkapan)
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view)
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = GridLayoutManager(this, 2)
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        //recyclerView.setNestedScrollingEnabled(false);
        //adapter list membuat list berdasarkan item2 pada PerlengkapanAdapter
        adapter = PerlengkapanAdapter(list, this)
        //membangun interface recyclerView berdasarkan adapter
        recyclerView.adapter = adapter

        btn_back = findViewById(R.id.btn_back)
        btn_back.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}


