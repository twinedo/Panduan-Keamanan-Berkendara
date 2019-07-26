package com.pkbv2.perlengkapan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.pkbv2.R

//class ini digunakan untuk membangun tampilan pada activity_perlengkapan_detail.xmlxml sebagai sebuah activity
class PerlengkapanDetail : AppCompatActivity() {

    //inisialisasi variabel
    private lateinit var NamaAlat: TextView
    private lateinit var DetailAlat: TextView
    private lateinit var Gambar: ImageView
    private lateinit var share: ImageView
    private lateinit var back: ImageView
    private var nama: String? = null
    private var detail: String? = null
    private var image_link: Int = 0

    //membuat sebuah tampilan dengan konten layout activity_perlengkapan_detail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perlengkapan_detail)

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada PerlengkapanAdapter
        val bundle = intent.extras
        //variabel ini akan berubah menjadi data yang dibentuk dari PerlengkapanAdapter, mendapatkan string
        // dari key value "nama_alat", "detail", dan "gambar" pada PerlengkapanAdapter.java
        nama = bundle!!.getString("nama_alat")
        detail = bundle.getString("detail")
        image_link = intent.getIntExtra("gambar", R.mipmap.ic_launcher)

        //inisialisasi id pada activity_perlengkapan_detailail.xml
        Gambar = findViewById(R.id.gambar)
        NamaAlat = findViewById(R.id.namaAlat)
        DetailAlat = findViewById(R.id.detail)
        share = findViewById(R.id.share)
        back = findViewById(R.id.back)
        //men set Gambar sebagai image_link
        Gambar.setImageResource(image_link)
        //men set NamaAlat sebagai nama
        NamaAlat.text = nama
        //men set DetailAlat sebagai detail
        DetailAlat.text = detail

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

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    override fun onBackPressed() {
        finish()
    }
}

