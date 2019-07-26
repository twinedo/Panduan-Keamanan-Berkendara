package com.pkbv2.sebelum

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.pkbv2.R

//class ini digunakan untuk membangun tampilan pada activity_sebelum_detail.xml sebagai sebuah activity
class SebelumDetail : AppCompatActivity() {

    //inisialisasi variabel
    private lateinit  var NamaSbl: TextView
    private lateinit  var DetailSbl: TextView
    private lateinit  var gambar: ImageView
    private lateinit  var share: ImageView
    private lateinit  var back: ImageView
    private var nama: String? = null
    private var detail: String? = null
    private var image_link: Int = 0
    private lateinit var layoutdetail: ConstraintLayout

    //membuat sebuah tampilan dengan konten layout activity_sebelum_detail.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sebelum_detail)

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada SebelumAdapter
        val bundle = intent.extras
        //variabel ini akan berubah menjadi data yang dibentuk dari SebelumAdapter, mendapatkan string
        // dari key value "nama_sbl", "detail", dan "gambar" pada Sebelumdapter.java
        nama = bundle!!.getString("nama_sbl")
        detail = bundle.getString("detail")
        image_link = intent.getIntExtra("gambar", R.mipmap.ic_launcher)

        //inisialisasi id pada activity_sebelum_detail.xml
        gambar = findViewById(R.id.gambar)
        NamaSbl = findViewById(R.id.namaSbl)
        DetailSbl = findViewById(R.id.detail)
        share = findViewById(R.id.share)
        back = findViewById(R.id.back)
        layoutdetail = findViewById(R.id.layoutdetail)

        //men set Gambar sebagai image_link
        gambar.setImageResource(image_link)
        //men set NamaSbl sebagai nama
        NamaSbl.text = nama
        //men set DetailSbl sebagai detail
        DetailSbl.text = detail

        back.setOnClickListener { onBackPressed() }

        share.setOnClickListener {
            val Bagikan = Intent(Intent.ACTION_SEND)
            //tipe file dari variabel Bagikan, * pertama adalah tipe file, dan  * kedua berupa format file tersebut
            Bagikan.type = "text/*"
            // menempatkan file ke Intent
            Bagikan.putExtra(Intent.EXTRA_TEXT,
                    "Salah satu hal yang harus diperhatikan dalam berkendara yaitu:" +
                            "\n" +
                            "\n" + "*" + nama + "*" +
                            "\n" +
                            "\nDeskripsi : " + detail!!.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0].trim { it <= ' ' } + "....." +
                            "\n" +
                            "Selengkapnya ada di:" +
                            "\n" +
                            "\nhttps://play.google.com/store/apps/details?id=" + packageName)

            //menampilkan pilihan aplikasi untuk dishare
            startActivity(Intent.createChooser(Bagikan, "Bagikan via:"))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}

