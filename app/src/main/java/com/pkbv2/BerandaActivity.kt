package com.pkbv2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.PopupMenu

import com.pkbv2.perlengkapan.PerlengkapanActivity
import com.pkbv2.saat.SaatBkActivity
import com.pkbv2.sebelum.SebelumActivity

/*
* Update per tanggal 04/May/2019
* oleh twinedo.dev@gmail.com
*/

class BerandaActivity : AppCompatActivity() {

    internal var option: ImageView? = null
    private var cardView: CardView? = null
    private var cardView2: CardView? = null
    private var cardView3: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        //Inisialisasi id
        cardView = findViewById(R.id.cardView)
        cardView2 = findViewById(R.id.cardView2)
        cardView3 = findViewById(R.id.cardView3)
        option = findViewById(R.id.option)

        //setelah inisialisasi, masing-masingnya ditambahkan fungsi klik
        cardView!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(v.getContext(), SebelumActivity::class.java)
                startActivity(intent)
            }
        })
        cardView2!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent1 = Intent(v.getContext(), PerlengkapanActivity::class.java)
                startActivity(intent1)
            }
        })
        cardView3!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent2 = Intent(v.getContext(), SaatBkActivity::class.java)
                startActivity(intent2)
            }
        })

        option!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val popupMenu = PopupMenu(this@BerandaActivity, option)
                popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu())
                popupMenu.show()

                popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(item: MenuItem): Boolean {
                        when (item.getTitle().toString()) {
                            "Tentang" -> {
                                //Toast.makeText(getApplicationContext(),"ini Tentang",Toast.LENGTH_SHORT).show();
                                val dialog = Dialog(this@BerandaActivity)
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                                dialog.setContentView(R.layout.tentang)
                                dialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                dialog.show()
                            }
                            "Exit" -> {
                                //Toast.makeText(getApplicationContext(),"ini Exit",Toast.LENGTH_SHORT).show();
                                val builder2 = AlertDialog.Builder(this@BerandaActivity, R.style.MyAlertDialogStyle)
                                builder2.setTitle("Exit") //
                                builder2.setMessage("Yakin ingin keluar?")
                                //
                                builder2.setPositiveButton("ya", object : DialogInterface.OnClickListener {
                                    override fun onClick(dialog: DialogInterface, id: Int) {
                                        // TODO
                                        finish()
                                        dialog.dismiss()
                                    }
                                })//
                                builder2.setNegativeButton("tidak", null)
                                builder2.show()
                            }
                        }
                        return true
                    }
                })
            }
        })
    }
}
