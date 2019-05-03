package com.android.pkb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//class FragmentBantuan digunakan untuk membangun tampilan fragment_tentang.xml sebagai sebuah fragment
public class FragmentTentang extends Fragment {
	
	public FragmentTentang(){}

    //Fungsi dibawah ini untuk membuat tampilan fragment diatas sebuah activity_main.xml
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_tentang, container, false);
         
        return rootView;
    }
}
