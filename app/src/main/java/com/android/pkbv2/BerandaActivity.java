package com.android.pkbv2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.android.pkbv2.peralatan.PeralatanActivity;
import com.android.pkbv2.saat.SaatBkActivity;
import com.android.pkbv2.sebelum.SebelumActivity;

/*
* Update per tanggal 04/May/2019
* oleh twinedo.dev@gmail.com
*/

public class BerandaActivity extends AppCompatActivity {

    ImageView option;
    CardView cardView, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        //Inisialisasi id
        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        option = findViewById(R.id.option);

        //setelah inisialisasi, masing-masingnya ditambahkan fungsi klik
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SebelumActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), PeralatanActivity.class);
                startActivity(intent1);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), SaatBkActivity.class);
                startActivity(intent2);
            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popupMenu = new PopupMenu(BerandaActivity.this,option);
                popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Tentang":
                                //Toast.makeText(getApplicationContext(),"ini Tentang",Toast.LENGTH_SHORT).show();
                                Dialog dialog = new Dialog(BerandaActivity.this);
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.tentang);
                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                dialog.show();

                                /*LayoutInflater tentang = LayoutInflater.from(BerandaActivity.this);
                                final View view = tentang.inflate(R.layout.tentang,null);
                                builder.setView(view);
                                builder.show();*/
                                break;
                            case "Exit":
                                //Toast.makeText(getApplicationContext(),"ini Exit",Toast.LENGTH_SHORT).show();
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(BerandaActivity.this, R.style.MyAlertDialogStyle);
                                builder2.setTitle("Exit"); //
                                builder2.setMessage("Yakin ingin keluar?");
                                //
                                builder2.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // TODO
                                        finish();
                                        dialog.dismiss();
                                    }
                                });//
                                builder2.setNegativeButton("tidak",null);
                                builder2.show();
                                break;
                        }
                        return true;
                    }
                });
            }
        });
    }
}
