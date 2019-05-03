package com.android.pkb.model;

public class NavDrawerItem {
	
	private String title;
	private int icon;
	private String count = "0";
	// boolean untuk men set navigasi drawer dengan kondisi awal false yang berarti tampilan drawer
	// pada saat membuka aplikasi tidak tampak/hide
	private boolean isCounterVisible = false;
	
	public NavDrawerItem(){}

	//method inisialisasi untuk title sebagai String dan icon sebagai int berdasarkan deklarasi variabel diatas
	public NavDrawerItem(String title, int icon){
		this.title = title;
		this.icon = icon;
	}

	//method inisialisasi NavDrawerItem berdasarkan deklarasi variabel private diatas
	public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count){
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}
	//method getter/ mendapatkan Title untuk item berdasarkan variable title
	public String getTitle(){
		return this.title;
	}
	//method getter/ mendapatkan Icon untuk item berdasarkan variable icon
	public int getIcon(){
		return this.icon;
	}
	//method getter/ mendapatkan Count untuk jumlah item berdasarkan variable count
	public String getCount(){
		return this.count;
	}
	//method getter/ mengatur visibilty untuk item berdasarkan variable isCounterVisible
	public boolean getCounterVisibility(){
		return this.isCounterVisible;
	}
	//method setter/ men set Title untuk item berdasarkan variable title
	public void setTitle(String title){
		this.title = title;
	}
	//method setter/ mendapatkan Icon untuk item berdasarkan variable icon
	public void setIcon(int icon){
		this.icon = icon;
	}
	//method setter/ mendapatkan Count untuk jumlah item berdasarkan variable count
	public void setCount(String count){
		this.count = count;
	}
	//method getter/ mengatur visibilty untuk item berdasarkan variable isCounterVisible
	public void setCounterVisibility(boolean isCounterVisible){
		this.isCounterVisible = isCounterVisible;
	}
}
