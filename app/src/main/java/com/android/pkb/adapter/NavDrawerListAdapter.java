package com.android.pkb.adapter;

import com.android.pkb.R;
import com.android.pkb.model.NavDrawerItem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//class NavDrawerListAdapter
public class NavDrawerListAdapter extends BaseAdapter {
	//inisialisasi variable context
	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItems;//inisialisasi variabel array list dari NavDrawerItem untuk item pada navigasi

	public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}
	//mendapatakan jumlah item menyesuaikan berapa item yang dibentuk
	@Override
	public int getCount() {
		return navDrawerItems.size();
	}
	//mengatur posisi berdasarkan array
	@Override
	public Object getItem(int position) {		
		return navDrawerItems.get(position);
	}
	//mendapatkan ID item berdasarkan ID pada drawer_lis_item.xml
	@Override
	public long getItemId(int position) {
		return position;
	}

	//dibawah ini perintah View getView adalah untuk membuat sebuah view/tampilan berdasarkan posisi,
	// convertViewmengubah tampilan dasar menjadi sesuai yang akan dibuat yaitu Navigation Drawer, dan grup parent membentuk sebuah
	// list grup array
	//dengan kondisi awal menampilkan item pertama dari list pada drawer_list_item.xml
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

		//inisialisasi imgIcon, txtTitle, txtCount
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.namaAlat);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

		//men set imgIcon dan set txtTitle untuk judul fragment pada toolbar berdasarkan list
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        

        // mengatur penampilan teks judul toolbar saat menu pada navigation drawer di pilih
        if(navDrawerItems.get(position).getCounterVisibility()){
        	txtCount.setText(navDrawerItems.get(position).getCount());
        }else{
        	// hide the counter view
        	txtCount.setVisibility(View.GONE);
        }
        
        return convertView;
	}

}
