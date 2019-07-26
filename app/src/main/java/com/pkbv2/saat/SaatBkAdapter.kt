package com.pkbv2.saat

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import java.util.ArrayList

import com.pkbv2.R
import com.pkbv2.saat.SaatBkAdapter.SaatBkViewHolder

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array SaatBk.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_saatbk_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada SaatBK.java dan SaatBkActivity.java
class SaatBkAdapter//method inisialisasi class untuk ArrayList SaatBk.java dan context
(saatBk: ArrayList<SaatBk>, //inisialisasi context untuk konteks apa yang akan digunakan
 internal var context: Context) : RecyclerView.Adapter<SaatBkAdapter.SaatBkViewHolder>() {

    //inisialisasi ArrayList pada SaatBk.java
    internal var saatBk = ArrayList<SaatBk>()

    init {
        this.saatBk = saatBk
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_saatbk_list.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaatBkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_saatbk_list, parent, false)

        return SaatBkViewHolder(view, context, saatBk)
    }

    //method dibawah ini digunakan untuk mengatur penempatan item pada list
    override fun onBindViewHolder(holder: SaatBkViewHolder, position: Int) {
        //inisialisasi array SaatBk dengan variabel saat, lalu variable saatBk ditempatkan sesuai posisi
        val saat = saatBk[position]
        //holder akan menampilkan gambar dan namaSaatBk berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada SaatBk.java
        holder.gambar.setImageResource(saat.gambar)
        //getNamaSaatBk memanggil fungsi NamaSaatBk pada SaatBk.java
        holder.nama_saatBk.text = saat.namaSaatBk

    }

    //mendapatkan item berdasar variabel saatBk
    override fun getItemCount(): Int {
        return saatBk.size
    }

    //deklarasi SaatBkViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    class SaatBkViewHolder//membangun view untuk arraylist
    (view: View, internal var context: Context, saatBk: ArrayList<SaatBk>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        //inisialisasi variabel gambar, nama_saatBk, context, dan ArrayList
        internal var gambar: ImageView
        internal var nama_saatBk: TextView
        internal var saatBk = ArrayList<SaatBk>()

        init {
            this.saatBk = saatBk
            //view adalah tampilan 1 item pada activity_saatbk_list.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan nama_saatBk yang sudah diinisialisasikan id nya
            view.setOnClickListener(this)
            gambar = view.findViewById<View>(R.id.image) as ImageView
            nama_saatBk = view.findViewById<View>(R.id.nama_saatBk) as TextView
        }

        // mendeklarasikan fungsi klik pada view
        override fun onClick(v: View) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            val position = adapterPosition
            val saatBk = this.saatBk[position]
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu SaatBkDetail.class
            val intent = Intent(context, SaatBkDetail::class.java)
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_saatbk", dan "detail"
            intent.putExtra("gambar", saatBk.gambar)
            intent.putExtra("nama_saatbk", saatBk.namaSaatBk)
            intent.putExtra("detail", saatBk.detailSaatBk)
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent)
        }
    }
}
