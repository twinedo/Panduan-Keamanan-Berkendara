package com.pkbv2.sebelum

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
import com.pkbv2.sebelum.SebelumAdapter.SebelumViewHolder

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array Sebelum.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_sebelum_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada Sebelum.java dan SebelumActivity.java
class SebelumAdapter//method inisialisasi class untuk ArrayList Sebelum.java dan context
(sebelumArrayList: ArrayList<Sebelum>, //inisialisasi context untuk konteks apa yang akan digunakan
 internal var context: Context) : RecyclerView.Adapter<SebelumAdapter.SebelumViewHolder>() {

    //inisialisasi ArrayList pada Sebelum.java
    internal var sebelumArrayList = ArrayList<Sebelum>()

    init {
        this.sebelumArrayList = sebelumArrayList
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_sebelum_list.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SebelumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_sebelum_list, parent, false)

        return SebelumViewHolder(view, context, sebelumArrayList)
    }

    //method dibawah ini digunakan untuk mengatur penempatan item pada list
    override fun onBindViewHolder(holder: SebelumViewHolder, position: Int) {
        //inisialisasi array Sebelum dengan variabel sbl, lalu variable Sebelum ditempatkan sesuai posisi
        val sbl = sebelumArrayList[position]
        //holder akan menampilkan gambar dan namaSbl berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada Sebelum.java
        holder.gambar.setImageResource(sbl.gambar)
        //getNamaSbl memanggil fungsi NamaSbl pada Sebelum.java
        holder.namaSbl.text = sbl.namaSbl
    }

    //mendapatkan item berdasar variabel sebelum
    override fun getItemCount(): Int {
        return sebelumArrayList.size
    }

    //deklarasi SebelumViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    class SebelumViewHolder//membangun view untuk arraylist
    (view: View, internal var context: Context, sebelum: ArrayList<Sebelum>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        //inisialisasi variabel gambar, namaSbl, context, dan ArrayList
        internal var gambar: ImageView
        internal var namaSbl: TextView
        internal var sebelum = ArrayList<Sebelum>()

        init {
            this.sebelum = sebelum
            //view adalah tampilan 1 item pada activity_sebelum_list.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan nama_sbl yang sudah diinisialisasikan id nya
            view.setOnClickListener(this)
            gambar = view.findViewById(R.id.image)
            namaSbl = view.findViewById(R.id.nama_sbl)

        }

        // mendeklarasikan fungsi klik pada view
        override fun onClick(v: View) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            val position = adapterPosition
            val sbl = this.sebelum[position]
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu SebelumDetail.clas
            val intent = Intent(context, SebelumDetail::class.java)
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_sbl", dan "detail"
            intent.putExtra("gambar", sbl.gambar)
            intent.putExtra("nama_sbl", sbl.namaSbl)
            intent.putExtra("detail", sbl.detailSbl)
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent)
        }
    }
}
