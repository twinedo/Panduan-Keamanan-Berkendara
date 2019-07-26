package com.pkbv2.sebelum

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView

import java.util.ArrayList

import com.pkbv2.R

//clas SebelumActivity digunakan untuk membangun tampilan activity_sebelum.xml sebagai sebuah activity
class SebelumActivity : AppCompatActivity() {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<*>
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    private lateinit  var layoutManager: RecyclerView.LayoutManager

    //inisialisasi ArrayList dari Sebelum.java
    private var list = ArrayList<Sebelum>()

    //inisialisasi list gambar dari resource mipmap
    internal var gambar = intArrayOf(R.drawable.berdoa, R.drawable.ban, R.drawable.bensin, R.drawable.fisik, R.drawable.map, R.drawable.cekmesin, R.drawable.lampu)

    //inisialisasi ArrayString namaSbl dan detailSbl
    private lateinit  var namaSbl: Array<String>
    private lateinit  var detailSbl: Array<String>

    private lateinit  var btn_back: ImageView

    //OnCreate membuat interface dan setContentView men set layout activity_sebelum.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sebelum)

        //menampilkan array berdasarkan strings.xml yang bernama namaSbl
        namaSbl = resources.getStringArray(R.array.namaSbl)
        //menampilkan array berdasarkan strings.xml yang bernama detailSbl
        detailSbl = resources.getStringArray(R.array.detailSbl)

        //kondisi perulangan untuk namaSbl pada Sebelum dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        var count = 0
        for (Nama in namaSbl) {
            val sebelum = Sebelum(gambar[count], Nama, detailSbl[count])
            count++
            list.add(sebelum)
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view)
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = GridLayoutManager(this@SebelumActivity, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        //adapter list membuat list berdasarkan item2 pada SebelumAdapter
        adapter = SebelumAdapter(list, this@SebelumActivity)
        //membangun interface recyclerView berdasarkan adapter
        recyclerView.adapter = adapter

        btn_back = findViewById(R.id.btn_back)
        btn_back.setOnClickListener { onBackPressed() }
    }

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    override fun onBackPressed() {
        finish()
    }
}


