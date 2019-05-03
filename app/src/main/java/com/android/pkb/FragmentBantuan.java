package com.android.pkb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//class FragmentBantuan digunakan untuk membangun tampilan fragment_bantuan.xml sebagai sebuah fragment
public class FragmentBantuan extends Fragment {
	
	public FragmentBantuan(){}

    //Fungsi dibawah ini untuk membuat tampilan fragment diatas sebuah activity_main.xml
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bantuan, container, false);
        return rootView;
    }
}
