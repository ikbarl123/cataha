package com.alimuntung.a10119260uts.Model;

import android.database.Cursor;

public interface ICatatanQuery {
    public Cursor read();
    public boolean create(Catatan catatan);
    public boolean update(Catatan catatan);
    public boolean delete(String id);
}
// Ikbar Laudza Alviansyah
// IF-7
// 10119260