package com.alimuntung.cataha.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CatatanQuery extends SQLiteOpenHelper implements ICatatanQuery {

    public CatatanQuery(Context context){
        super(context,"db_catatan",null,1);
    }
    // Ikbar Laudza Alviansyah
// IF-7
// 10119260
    @Override
    public void onCreate(SQLiteDatabase sql) {
    sql.execSQL("Create Table t_catatan(id TEXT, tanggal TEXT, catatan TEXT, judul TEXT, kategori TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int i, int i1) {
    sql.execSQL("DROP TABLE t_catatan");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getWritableDatabase();
        return sql.rawQuery("SELECT * FROM t_catatan",null);
    }

    @Override
    public boolean create(Catatan catatan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO t_catatan VALUES('"+catatan.getId()+"','"+catatan.getTanggal()+"','"+catatan.getCatatan()+"','"+catatan.getJudul()+"','"+catatan.getKategori()+"')");
        return true;
    }

    @Override
    public boolean update(Catatan catatan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE t_catatan SET catatan='"+catatan.getCatatan()+"',judul='"+catatan.getJudul()+"',kategori='"+catatan.getKategori()+"'WHERE id='"+catatan.getId()+"'");
        return true;
    }

    @Override
    public boolean delete(String id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM t_catatan WHERE id='"+id+"'");
        return true;
    }

}
