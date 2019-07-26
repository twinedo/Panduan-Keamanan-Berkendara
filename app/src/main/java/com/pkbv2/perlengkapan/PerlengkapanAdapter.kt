package com.pkbv2.perlengkapan

import android.content.Context
import android.content.Intent
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import com.pkbv2.R
import com.pkbv2.perlengkapan.PerlengkapanAdapter.PerlengkapanViewHolder
import com.pkbv2.saat.SaatBk
import com.pkbv2.saat.SaatBkAdapter

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array Perlengkapan.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_perlengkapan_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada Perlengkapan.java dan PerlengkapanActivity.java
class PerlengkapanAdapter//method inisialisasi class untuk ArrayList Perlengkapan.java dan context
//inisialisasi ArrayList pada Perlengkapan.java
        (perlengkapan: ArrayList<Perlengkapan>, //inisialisasi context untuk konteks apa yang akan digunakan
         internal var context: Context) : RecyclerView.Adapter<PerlengkapanAdapter.PerlengkapanViewHolder>() {

        internal var perlengkapan = ArrayList<Perlengkapan>()

    init {
        this.perlengkapan = perlengkapan
    }
    override fun getItemCount(): Int {
        return perlengkapan.size
    }  //To change body of created functions use File | Settings | File Templates.


    //mendapatkan item berdasar variabel perlengkapan

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_perlengkapan_list.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerlengkapanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_perlengkapan_list, parent, false)

        return PerlengkapanAdapter.PerlengkapanViewHolder(view, context, perlengkapan)
    }

    override fun onBindViewHolder(holder: PerlengkapanViewHolder, position: Int) {
        //inisialisasi array Perlengkapan dengan variabel alat, lalu variabele perlengkapan ditempatkan sesuai posisi
        val alat = perlengkapan.get(position)

        holder.gambar.setImageResource(alat.gambar)
        holder.namaAlat.text = alat.namaAlat

    }

    //deklarasi PeralatanViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    class PerlengkapanViewHolder
    (view: View, internal var context: Context, perlengkapan: ArrayList<Perlengkapan>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        //inisialisasi variabel gambar, namaAlat, context, dan ArrayList
        internal var gambar: ImageView
        internal var namaAlat: TextView
        internal var perlengkapan = ArrayList<Perlengkapan>()

        //membangun view untuk arraylist
        init{
            this.perlengkapan = perlengkapan
            this.context = context
            //view adalah tampilan 1 item pada activity_perlengkapan_listist.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan namaAlat yang sudah diinisialisasikan id nya
            view.setOnClickListener(this)
            gambar = view.findViewById(R.id.image)
            namaAlat = view.findViewById(R.id.nama_alat)
        }
        // mendeklarasikan fungsi klik pada view

        override fun onClick(v: View) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            val position = getAdapterPosition()
            val perlengkapan = this.perlengkapan.get(position)
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu PerlengkapanDetail.class
            val intent = Intent(context, PerlengkapanDetail::class.java)
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_alat", dan "detail"
            intent.putExtra("gambar", perlengkapan.gambar)
            intent.putExtra("nama_alat", perlengkapan.namaAlat)
            intent.putExtra("detail", perlengkapan.detailALat)
            //startActivity untuk mengaktifkan fungsi intent
            this.context!!.startActivity(intent)
        }
    }

}
