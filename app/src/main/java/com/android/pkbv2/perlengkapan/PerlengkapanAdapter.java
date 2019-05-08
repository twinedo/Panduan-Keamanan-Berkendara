package com.android.pkbv2.perlengkapan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.android.pkbv2.R;

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array Perlengkapan.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_perlengkapan_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada Perlengkapan.java dan PerlengkapanActivity.java
public class PerlengkapanAdapter extends RecyclerView.Adapter<PerlengkapanAdapter.PerlengkapanViewHolder> {

    //inisialisasi ArrayList pada Perlengkapan.java
    ArrayList<Perlengkapan> perlengkapan = new ArrayList<Perlengkapan>();
    //inisialisasi context untuk konteks apa yang akan digunakan
    Context context;

    //method inisialisasi class untuk ArrayList Perlengkapan.java dan context
    public PerlengkapanAdapter(ArrayList<Perlengkapan> perlengkapan, Context context){
        this.perlengkapan = perlengkapan;
        this.context = context;
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_perlengkapan_list.xml
    @Override
    public PerlengkapanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_perlengkapan_list,parent,false);
        PerlengkapanViewHolder perlengkapanViewHolder = new PerlengkapanViewHolder(view,context, perlengkapan);

        return perlengkapanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PerlengkapanViewHolder holder, int position) {
        //inisialisasi array Perlengkapan dengan variabel alat, lalu variabele perlengkapan ditempatkan sesuai posisi
        Perlengkapan alat = perlengkapan.get(position);
        //holder akan menampilkan gambar dan namaAlat berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada Perlengkapan.java
        holder.gambar.setImageResource(alat.getGambar());
        //getNamaAlat memanggil fungsi NamaAlat pada Perlengkapan.java
        holder.namaAlat.setText(alat.getNamaAlat());
    }

    //mendapatkan item berdasar variabel perlengkapan
    @Override
    public int getItemCount() {
        return perlengkapan.size();
    }

    //deklarasi PeralatanViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    public static class PerlengkapanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //inisialisasi variabel gambar, namaAlat, context, dan ArrayList
        ImageView gambar;
        TextView namaAlat;
        Context context;
        ArrayList<Perlengkapan> perlengkapan = new ArrayList<Perlengkapan>();
        //membangun view untuk arraylist
        public PerlengkapanViewHolder(View view, Context context, ArrayList<Perlengkapan> perlengkapan){
            super(view);
            this.perlengkapan = perlengkapan;
            this.context = context;
            //view adalah tampilan 1 item pada activity_perlengkapan_listist.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan namaAlat yang sudah diinisialisasikan id nya
            view.setOnClickListener(this);
            gambar = view.findViewById(R.id.image);
            namaAlat= view.findViewById(R.id.nama_alat);
        }

        public PerlengkapanViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        // mendeklarasikan fungsi klik pada view
        @Override
        public void onClick(View v) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            int position = getAdapterPosition();
            Perlengkapan perlengkapan = this.perlengkapan.get(position);
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu PerlengkapanDetail.class
            Intent intent = new Intent(context, PerlengkapanDetail.class);
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_alat", dan "detail"
            intent.putExtra("gambar", perlengkapan.getGambar());
            intent.putExtra("nama_alat", perlengkapan.getNamaAlat());
            intent.putExtra("detail", perlengkapan.getDetailALat());
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent);
        }
    }

}
