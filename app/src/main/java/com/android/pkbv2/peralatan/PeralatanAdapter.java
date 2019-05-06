package com.android.pkbv2.peralatan;

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

//class ini merupakan pengembangan tampilan recyclerView sebagai adapter, recycleView ini dibentuk berdasar Array Peralatan.java
// recyclerView adapter berfungsi mengulang 1 item yang sama pada activity_peralatan_list sebanyak jumlah item pada list
// yang sudah diinisialisasikan pada Peralatan.java dan PeralatanActivity.java
public class PeralatanAdapter extends RecyclerView.Adapter<PeralatanAdapter.PeralatanViewHolder>{

    //inisialisasi ArrayList pada Peralatan.java
    ArrayList<Peralatan> peralatan = new ArrayList<Peralatan>();
    //inisialisasi context untuk konteks apa yang akan digunakan
    Context context;

    //method inisialisasi class untuk ArrayList Peralatan.java dan context
    public PeralatanAdapter(ArrayList<Peralatan> peralatan, Context context){
        this.peralatan = peralatan;
        this.context = context;
    }

    //ViewHolder akan membangun recyclerView yang akan ditampilkan pada layout activity_peralatan_list.xml
    @Override
    public PeralatanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_peralatan_list,parent,false);
        PeralatanViewHolder peralatanViewHolder = new PeralatanViewHolder(view,context,peralatan);

        return peralatanViewHolder;
    }

    //method dibawah ini digunakan untuk mengatur penempatan item pada list
    @Override
    public void onBindViewHolder(PeralatanViewHolder holder, int position) {
        //inisialisasi array Peralatan dengan variabel alat, lalu variabele peralatan ditempatkan sesuai posisi
        Peralatan alat = peralatan.get(position);
        //holder akan menampilkan gambar dan namaAlat berdasarkan posisi yang terbentuk (grid)
        //getGambar memanggil fungsi gambar pada Peralatan.java
        holder.gambar.setImageResource(alat.getGambar());
        //getNamaAlat memanggil fungsi NamaAlat pada Peralatan.java
        holder.namaAlat.setText(alat.getNamaAlat());
    }

    //mendapatkan item berdasar variabel peralatan
    @Override
    public int getItemCount() {
        return peralatan.size();
    }

    //deklarasi PeralatanViewHolder untuk tampilan yang terbentuk dan mengimplementasikan fungsi klik pada setiap item
    public static class PeralatanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //inisialisasi variabel gambar, namaAlat, context, dan ArrayList
        ImageView gambar;
        TextView namaAlat;
        Context context;
        ArrayList<Peralatan> peralatan = new ArrayList<Peralatan>();
        //membangun view untuk arraylist
        public PeralatanViewHolder(View view, Context context, ArrayList<Peralatan> peralatan){
            super(view);
            this.peralatan = peralatan;
            this.context = context;
            //view adalah tampilan 1 item pada activity_peralatan_list.xml dan akan ditambahkan fungsi OnClick
            // sehingga view dapat di klik berdasarkan gambar dan namaAlat yang sudah diinisialisasikan id nya
            view.setOnClickListener(this);
            gambar = (ImageView)view.findViewById(R.id.image);
            namaAlat= (TextView)view.findViewById(R.id.nama_alat);
        }

        // mendeklarasikan fungsi klik pada view
        @Override
        public void onClick(View v) {
            //inisialisasi posisi agar perintah klik sesuai dengan posisi yang di klik
            int position = getAdapterPosition();
            Peralatan peralatan = this.peralatan.get(position);
            //saat di klik, perintah intent digunakan untuk memanggil class lain yaitu PeralatanDetail.class
            Intent intent = new Intent(context,PeralatanDetail.class);
            //putExtra digunakan untuk mendapatkan item berdasarkan key value yaitu "gambar", "nama_alat", dan "detail"
            intent.putExtra("gambar",peralatan.getGambar());
            intent.putExtra("nama_alat",peralatan.getNamaAlat());
            intent.putExtra("detail",peralatan.getDetailALat());
            //startActivity untuk mengaktifkan fungsi intent
            this.context.startActivity(intent);
        }
    }
}
