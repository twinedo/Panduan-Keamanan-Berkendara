package com.android.pkbv2.sebelum;

//class Sebelum digunakan untuk method getter dan setter untuk mendapatkan dan men set variable2 yang ada di SebelumActivity
//SebelumAdapter
public class Sebelum {

    public Sebelum(int gambar, String namaSbl, String detailSbl){
        this.setGambar(gambar);
        this.setNamaSbl(namaSbl);
        this.setDetailSbl(detailSbl);
    }
    private int gambar;
    private String namaSbl, detailSbl;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNamaSbl() {
        return namaSbl;
    }

    public void setNamaSbl(String namaSbl) {
        this.namaSbl = namaSbl;
    }

    public String getDetailSbl() {
        return detailSbl;
    }

    public void setDetailSbl(String detailSbl) {
        this.detailSbl = detailSbl;
    }
}
