package com.android.pkb.saat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.android.pkb.R;

//class ini digunakan untuk membangun tampilan pada activity_saatbk_detail.xml sebagai sebuah activity
public class SaatBkDetail extends Activity {

    //inisialisasi variabel
    private TextView NamaSaatBk, DetailSaatBk;
    private ImageView Gambar;
    private String nama, detail;
    private int image_link;

    //membuat sebuah tampilan dengan konten layout activity_saatbk_detail.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saatbk_detail);

        //getActionBar untuk mengatur action pada toolbar activity_saatbk_list.xml
        // setDisplayHome berfungsi untuk menampilkan tampilan sebelumnya (activity_saatbk.xml)
        // setHomeButton berfungsi men set action bar sebagai tombol kembali ke tampilan sebelumnya
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        //fungsi dibawah ini untuk mendapatkan tampilan yang sudah di klik pada SaatBkAdapter
        Bundle bundle = getIntent().getExtras();
        //variabel ini akan berubah menjadi data yang dibentuk dari SaatBkAdapter, mendapatkan string
        // dari key value "nama_saatbk", "detail", dan "gambar" pada SaatBkAdapter.java
        nama = bundle.getString("nama_saatbk");
        detail= bundle.getString("detail");
        image_link = getIntent().getIntExtra("gambar",R.mipmap.ic_launcher);

        //inisialisasi id pada activity_saatbk_detail.xml
        Gambar = (ImageView) findViewById(R.id.gambar);
        NamaSaatBk = (TextView) findViewById(R.id.namaSaatbk);
        DetailSaatBk = (TextView) findViewById(R.id.detail);
        //men set Gambar sebagai image_link
        Gambar.setImageResource(image_link);
        //men set NamaSaatBk sebagai nama
        NamaSaatBk.setText(nama);
        //men set DetailSaatBk sebagai detail
        DetailSaatBk.setText(detail);
    }

    //ketika tombol back ditekan maka tampilan yang sedang dibuka akan tertutup (finish();)
    @Override
    public void onBackPressed() {
        finish();
    }

    //membentuk menu bagikan.xml
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bagikan, menu);
        return true;
    }

    //mengaktifkan fungsi menu saat ditekan
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //inisialisasi untuk mendapatkan id
        int id = item.getItemId();
        //jika id = action share maka akan dideklarasikan fungsi seperti dibawah ini
        if (id == R.id.action_share) {
            //inisialisasi variabel bitmap dan outputStream
            Bitmap bitmap;
            OutputStream outputStream;
            //mengambil gambar dari image_link
            bitmap = BitmapFactory.decodeResource(getResources(),
                    image_link);
            //mencari sd card path
            File filepath = Environment.getExternalStorageDirectory();
            //membuat folder baru di sdcard dengan nama direktori /Saftey Riding/
            File dir = new File(filepath.getAbsolutePath()+"/Safety Riding/");
            dir.mkdirs();

            //membuat nama untuk gambar yang disimpan
            File file = new File(dir,"*.png");
            try {
                // Menampilkan ACTION_SEND dengan variabel Bagikan
                Intent Bagikan = new Intent(Intent.ACTION_SEND);
                //tipe file dari variabel Bagikan, * pertama adalah tipe file, dan  * kedua berupa format file tersebut
                Bagikan.setType("*/*");
                outputStream = new FileOutputStream(file);
                //kompress file ke PNG dari 0% ke 100%
                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                outputStream.flush();
                outputStream.close();
                //mengalokasikan file untuk dibagikan
                Uri uri = Uri.fromFile(file);
                // menempatkan file ke Intent
                Bagikan.putExtra(Intent.EXTRA_STREAM,uri);
                Bagikan.putExtra(Intent.EXTRA_TEXT,
                        "Salah satu hal yang harus diperhatikan dalam berkendara yaitu:"+

                                "\n"+nama+
                                "\nDeskripsi : "+detail+"");
                //menampilkan pilihan aplikasi untuk dishare
                startActivity(Intent.createChooser(Bagikan, "Bagikan via:"));
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }else if(id==android.R.id.home){//fungsi ini ketika menekan tombol back akan kembali ke tampilan sebelumnya
            finish();
            return true;
        }

        return true;
    }
}

