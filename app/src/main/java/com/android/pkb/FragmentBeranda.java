package com.android.pkb;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.pkb.peralatan.PeralatanActivity;
import com.android.pkb.saat.SaatBkActivity;
import com.android.pkb.sebelum.SebelumActivity;

//class FragmentBeranda digunakan untuk membangun tampilan fragment_home.xml sebagai sebuah fragment
//lalu mengimplementasikan fungsi click pada view yang terbentuk
public class FragmentBeranda extends Fragment implements View.OnClickListener{
	
	public FragmentBeranda(){}

    //Fungsi dibawah ini untuk membuat tampilan fragment diatas sebuah activity_main.xml
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //Inisialisasi id ImageView peralatan, sbl_berkendara, saat_berkendara yang ada pada fragment_home.xml
        ImageView peralatan = (ImageView) rootView.findViewById(R.id.br_alat);
        ImageView sbl_berkendara = (ImageView) rootView.findViewById(R.id.br_sbl);
        ImageView saat_berkendara = (ImageView) rootView.findViewById(R.id.br_saat);

        //setelah inisialisasi, masing-masingnya ditambahkan fungsi klik
        peralatan.setOnClickListener(this);
        sbl_berkendara.setOnClickListener(this);
        saat_berkendara.setOnClickListener(this);
        return rootView;
    }

    //implementasi fungsi klik pada id yang telah diinisialisasikan dengan pilihan
    public void onClick(View v) {
        switch (v.getId()) {
            //jika id yang di klik adalah br_alat, maka fungsi intent menampilkan class PeralatanActivity
            case R.id.br_alat:
                Intent intent = new Intent(v.getContext(), PeralatanActivity.class);
                startActivity(intent);
                break;
            //jika id yang di klik adalah br_sbl, maka fungsi intent menampilkan class SebelumActivity
            case R.id.br_sbl:
                Intent intent1 = new Intent(v.getContext(), SebelumActivity.class);
                startActivity(intent1);
                break;
            //jika id yang di klik adalah br_saat, maka fungsi intent menampilkan class SaatBkActivity
            case R.id.br_saat:
                Intent intent2 = new Intent(v.getContext(), SaatBkActivity.class);
                startActivity(intent2);
                break;


        }

    }


}
