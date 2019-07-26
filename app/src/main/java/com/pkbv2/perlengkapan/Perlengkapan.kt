package com.pkbv2.perlengkapan

//class Perlengkapan digunakan sebagai method getter dan setter untuk mendapatkan dan men set gambar/string yang ada di PerlengkapanActivity
//PerlengkapanAdapter
class Perlengkapan(gambar: Int, namaAlat: String, detailALat: String) {
    var gambar: Int = 0
    var namaAlat: String? = null
    var detailALat: String? = null

    init {
        this.gambar = gambar
        this.namaAlat = namaAlat
        this.detailALat = detailALat
    }
}
