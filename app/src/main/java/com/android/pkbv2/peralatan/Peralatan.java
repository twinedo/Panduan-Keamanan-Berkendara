package com.android.pkbv2.peralatan;

//class Peralatan digunakan sebagai method getter dan setter untuk mendapatkan dan men set gambar/string yang ada di PeralatanActivity
//PeralatanAdapter
public class Peralatan {

    public Peralatan(int gambar, String namaAlat, String detailALat){
        this.setGambar(gambar);
        this.setNamaAlat(namaAlat);
        this.setDetailALat(detailALat);
    }
    private int gambar;
    private String namaAlat, detailALat;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public String getDetailALat() {
        return detailALat;
    }

    public void setDetailALat(String detailALat) {
        this.detailALat = detailALat;
    }
}
