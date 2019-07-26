package com.pkbv2.saat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.pkbv2.R

//class ini digunakan untuk membangun tampilan pada activity_saatbk_detail.xml sebagai sebuah activity
class SaatBkDetail : AppCompatActivity() {

    //inisialisasi variabel
    private lateinit var NamaSaatBk: TextView
    private lateinit  var DetailSaatBk: TextView
    private lateinit  var Gambar: ImageView
    private lateinit  var share: ImageView
    private lateinit  var back: ImageView
    private var nama: String? = null
    private var detail: String? = null
    private var image_link: Int = 0

    //membuat sebuah tampilan dengan konten layout activity_saatbk_detail.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saatbk_detail)

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada SaatBkAdapter
        val bundle = intent.extras
        //variabel ini akan berubah menjadi data yang dibentuk dari SaatBkAdapter, mendapatkan string
        // dari key value "nama_saatbk", "detail", dan "gambar" pada SaatBkAdapter.java
        nama = bundle!!.getString("nama_saatbk")
        detail = bundle.getString("detail")
        image_link = intent.getIntExtra("gambar", R.mipmap.ic_launcher)

        //inisialisasi id pada activity_saatbk_detail.xml
        Gambar = findViewById(R.id.gambar)
        NamaSaatBk = findViewById(R.id.namaSaatbk)
        DetailSaatBk = findViewById(R.id.detail)
        share = findViewById(R.id.share)
        back = findViewById(R.id.back)
        //men set Gambar sebagai image_link
        Gambar.setImageResource(image_link)
        //men set NamaSaatBk sebagai nama
        NamaSaatBk.text = nama
        //men set DetailSaatBk sebagai detail
        DetailSaatBk.text = detail

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
                            "\nDeskripsi : \n" + detail!!.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0].trim { it <= ' ' } + "....." +
                            "\n" +
                            "Selengkapnya ada di:" +
                            "\n" +
                            "\nhttps://play.google.com/store/apps/details?id=" + packageName)

            //menampilkan pilihan aplikasi untuk dishare
            startActivity(Intent.createChooser(Bagikan, "Bagikan via:"))
        }
    }

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    override fun onBackPressed() {
        finish()
    }

}

