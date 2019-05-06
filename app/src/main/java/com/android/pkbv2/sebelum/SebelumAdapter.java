package com.android.pkbv2.sebelum;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.android.pkbv2.R;

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array Sebelum.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_sebelum_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada Sebelum.java dan SebelumActivity.java
public class SebelumAdapter extends RecyclerView.Adapter<SebelumAdapter.SebelumViewHolder>{

    //inisialisasi ArrayList pada Sebelum.java
    ArrayList<Sebelum> sebelumArrayList = new ArrayList<Sebelum>();
    //inisialisasi context untuk konteks apa yang akan digunakan
    Context context;

    //method inisialisasi class untuk ArrayList Sebelum.java dan context
    public SebelumAdapter(ArrayList<Sebelum> sebelumArrayList, Context context){
        this.sebelumArrayList = sebelumArrayList;
        this.context = context;
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_sebelum_list.xml
    @Override
    public SebelumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sebelum_list,parent,false);
        SebelumViewHolder sebelumViewHolder = new SebelumViewHolder(view,context,sebelumArrayList);

        return sebelumViewHolder;
    }

    //method dibawah ini digunakan untuk mengatur penempatan item pada list
    @Override
    public void onBindViewHolder(SebelumViewHolder holder, int position) {
        //inisialisasi array Sebelum dengan variabel sbl, lalu variable Sebelum ditempatkan sesuai posisi
        Sebelum sbl = sebelumArrayList.get(position);
        //holder akan menampilkan gambar dan namaSbl berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada Sebelum.java
        holder.gambar.setImageResource(sbl.getGambar());
        //getNamaSbl memanggil fungsi NamaSbl pada Sebelum.java
        holder.namaSbl.setText(sbl.getNamaSbl());
    }

    //mendapatkan item berdasar variabel sebelum
    @Override
    public int getItemCount() {
        return sebelumArrayList.size();
    }

    //deklarasi SebelumViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    public static class SebelumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //inisialisasi variabel gambar, namaSbl, context, dan ArrayList
        ImageView gambar;
        TextView namaSbl;
        Context context;
        ArrayList<Sebelum> sebelum = new ArrayList<Sebelum>();
        //membangun view untuk arraylist
        public SebelumViewHolder(View view, Context context, ArrayList<Sebelum> sebelum){
            super(view);
            this.sebelum = sebelum;
            this.context = context;
            //view adalah tampilan 1 item pada activity_sebelum_list.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan nama_sbl yang sudah diinisialisasikan id nya
            view.setOnClickListener(this);
            gambar = view.findViewById(R.id.image);
            namaSbl= view.findViewById(R.id.nama_sbl);

        }

        // mendeklarasikan fungsi klik pada view
        @Override
        public void onClick(View v) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            int position = getAdapterPosition();
            Sebelum sbl = this.sebelum.get(position);
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu SebelumDetail.clas
            Intent intent = new Intent(context,SebelumDetail.class);
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_sbl", dan "detail"
            intent.putExtra("gambar",sbl.getGambar());
            intent.putExtra("nama_sbl",sbl.getNamaSbl());
            intent.putExtra("detail",sbl.getDetailSbl());
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent);
        }
    }
}
