package com.alimuntung.a10119260uts.Model;

import java.util.Date;

public class Catatan {
    private String id;
    private String tanggal;
    private String catatan;
    private String judul;
    private String kategori;

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
