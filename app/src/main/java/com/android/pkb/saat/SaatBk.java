package com.android.pkb.saat;

//class SaatBk digunakan untuk method getter dan setter untuk mendapatkan dan men set variable2 yang ada di SaatBkActivity
//SaatBkAdapter
public class SaatBk {

    public SaatBk(int gambar, String namaSaatBk, String detailSaatBk){
        this.setGambar(gambar);
        this.setNamaSaatBk(namaSaatBk);
        this.setDetailSaatBk(detailSaatBk);
    }
    private int gambar;
    private String namaSaatBk, detailSaatBk;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNamaSaatBk() {
        return namaSaatBk;
    }

    public void setNamaSaatBk(String namaSaatBk) {
        this.namaSaatBk = namaSaatBk;
    }

    public String getDetailSaatBk() {
        return detailSaatBk;
    }

    public void setDetailSaatBk(String detailSaatBk) {
        this.detailSaatBk = detailSaatBk;
    }
}
