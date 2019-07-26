package com.pkbv2.saat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView

import java.util.ArrayList

import com.pkbv2.R

//clas SaatBkActivity digunakan untuk membangun tampilan activity_saatbk.xml sebagai sebuah activity
class SaatBkActivity : AppCompatActivity() {

    //inisialisasi variabel recycleView, adapter recycleView untuk mengatur tampilan recycleview pada activity_main.cml
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var adapter: RecyclerView.Adapter<*>
    //inisialisasi variabel layoutManager untuk mengatur seperti apa bentuk tampilan recyclerview
    internal lateinit var layoutManager: RecyclerView.LayoutManager

    //inisialisasi ArrayList dari SaatBk.java
    internal var list = ArrayList<SaatBk>()

    //inisialisasi list gambar dari resource mipmap
    internal var gambar = intArrayOf(R.drawable.pengguna, R.drawable.istirahat, R.drawable.rambu, R.drawable.seatbelt, R.drawable.speedometer)

    //inisialisasi ArrayString namaSaatBk dan detailSaatBk
    internal lateinit var namaSaatBk: Array<String>
    internal lateinit var detailSaatBk: Array<String>

    internal lateinit var btn_back: ImageView

    //OnCreate membuat interface dan setContentView men set layout activity_saatbk.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saatbk)

        //menampilkan array berdasarkan strings.xml yang bernama namaSaatBk
        namaSaatBk = resources.getStringArray(R.array.namaSaatBk)
        //menampilkan array berdasarkan strings.xml yang bernama detailSaatBk
        detailSaatBk = resources.getStringArray(R.array.detailSaatBk)


        //kondisi perulangan untuk namaSaatBk pada Persiapan dimana list akan terbentuk secara berulang
        //dari array yang telah diinisialisasikan diatas
        var count = 0
        for (Nama in namaSaatBk) {
            val saatbk = SaatBk(gambar[count], Nama, detailSaatBk[count])
            count++
            list.add(saatbk)
        }
        //inisialisasi id recycler_view pada activity_main.xml
        recyclerView = findViewById(R.id.recycler_view)
        //layoutManager mengatur bentuk tampilan seperti grid pada activity ini dengan kolom sebanyak 2
        layoutManager = GridLayoutManager(this, 2)
        //recyclerView men set Layout berdasarkan variabel layoutManager yaitu GridLayoutManager
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        //adapter list membuat list berdasarkan item2 pada SaatBkAdapter
        adapter = SaatBkAdapter(list, this)
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


