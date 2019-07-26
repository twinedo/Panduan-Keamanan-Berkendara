package com.pkbv2.saat

//class SaatBk digunakan untuk method getter dan setter untuk mendapatkan dan men set variable2 yang ada di SaatBkActivity
//SaatBkAdapter
class SaatBk(gambar: Int, namaSaatBk: String, detailSaatBk: String) {
    var gambar: Int = 0
    var namaSaatBk: String? = null
    var detailSaatBk: String? = null

    init {
        this.gambar = gambar
        this.namaSaatBk = namaSaatBk
        this.detailSaatBk = detailSaatBk
    }
}
