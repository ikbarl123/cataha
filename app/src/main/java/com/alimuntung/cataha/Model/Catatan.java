package com.alimuntung.cataha.Model;

import java.io.Serializable;
import java.util.Date;

public class Catatan implements Serializable {
    private String id;
    private String tanggal;// 101.192.60
    private String catatan;// 101.192.60
    private String judul;
    private String kategori;// 101.192.60

    public Catatan(String id, String tanggal,  String catatan, String judul, String kategori){
        this.id=id;
        this.tanggal=tanggal;
        this.catatan=catatan;
        this.judul=judul;
        this.kategori=kategori;
    }

    public String getId() {
        return id;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getCatatan() {
        return catatan;
    }
    public String getJudul() {
        return judul;
    }
    public String getKategori() {
        return kategori;
    }
}

// Ikbar Laudza Alviansyah
// IF-7
// 10119260