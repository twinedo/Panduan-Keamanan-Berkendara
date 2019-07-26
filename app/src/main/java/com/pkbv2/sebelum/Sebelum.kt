package com.pkbv2.sebelum

//class Sebelum digunakan untuk method getter dan setter untuk mendapatkan dan men set variable2 yang ada di SebelumActivity
//SebelumAdapter
class Sebelum(gambar: Int, namaSbl: String, detailSbl: String) {
    var gambar: Int = 0
    var namaSbl: String? = null
    var detailSbl: String? = null

    init {
        this.gambar = gambar
        this.namaSbl = namaSbl
        this.detailSbl = detailSbl
    }
}
