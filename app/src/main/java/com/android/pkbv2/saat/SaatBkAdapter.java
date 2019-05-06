package com.android.pkbv2.saat;

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

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array SaatBk.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_saatbk_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada SaatBK.java dan SaatBkActivity.java
public class SaatBkAdapter extends RecyclerView.Adapter<SaatBkAdapter.SaatBkViewHolder>{

    //inisialisasi ArrayList pada SaatBk.java
    ArrayList<SaatBk> saatBk = new ArrayList<SaatBk>();
    //inisialisasi context untuk konteks apa yang akan digunakan
    Context context;
    //method inisialisasi class untuk ArrayList SaatBk.java dan context
    public SaatBkAdapter(ArrayList<SaatBk> saatBk, Context context){
        this.saatBk = saatBk;
        this.context = context;
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_saatbk_list.xml
    @Override
    public SaatBkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_saatbk_list,parent,false);
        SaatBkViewHolder saatBkViewHolder= new SaatBkViewHolder(view,context,saatBk);

        return saatBkViewHolder;
    }

    //method dibawah ini digunakan untuk mengatur penempatan item pada list
    @Override
    public void onBindViewHolder(SaatBkViewHolder holder, int position) {
        //inisialisasi array SaatBk dengan variabel saat, lalu variable saatBk ditempatkan sesuai posisi
        SaatBk saat = saatBk.get(position);
        //holder akan menampilkan gambar dan namaSaatBk berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada SaatBk.java
        holder.gambar.setImageResource(saat.getGambar());
        //getNamaSaatBk memanggil fungsi NamaSaatBk pada SaatBk.java
        holder.nama_saatBk.setText(saat.getNamaSaatBk());

    }

    //mendapatkan item berdasar variabel saatBk
    @Override
    public int getItemCount() {
        return saatBk.size();
    }

    //deklarasi SaatBkViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    public static class SaatBkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //inisialisasi variabel gambar, nama_saatBk, context, dan ArrayList
        ImageView gambar;
        TextView nama_saatBk;
        Context context;
        ArrayList<SaatBk> saatBk = new ArrayList<SaatBk>();
        //membangun view untuk arraylist
        public SaatBkViewHolder(View view, Context context, ArrayList<SaatBk> saatBk){
            super(view);
            this.saatBk = saatBk;
            this.context = context;
            //view adalah tampilan 1 item pada activity_saatbk_list.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan nama_saatBk yang sudah diinisialisasikan id nya
            view.setOnClickListener(this);
            gambar = (ImageView)view.findViewById(R.id.image);
            nama_saatBk= (TextView)view.findViewById(R.id.nama_saatBk);
        }

        // mendeklarasikan fungsi klik pada view
        @Override
        public void onClick(View v) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            int position = getAdapterPosition();
            SaatBk saatBk = this.saatBk.get(position);
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu SaatBkDetail.class
            Intent intent = new Intent(context,SaatBkDetail.class);
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_saatbk", dan "detail"
            intent.putExtra("gambar",saatBk.getGambar());
            intent.putExtra("nama_saatbk",saatBk.getNamaSaatBk());
            intent.putExtra("detail",saatBk.getDetailSaatBk());
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent);
        }
    }
}
