package com.alimuntung.a10119260uts.Presenter.catatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alimuntung.a10119260uts.Model.Catatan;
import com.alimuntung.a10119260uts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class CatatanView extends AppCompatActivity implements Serializable {
    private Catatan catatan;
    private TextView tv_tanggal,textCatatan,textJudul,textKategori;
    private FloatingActionButton btnBack;
   // private String tanggalskrg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_view);
        getSupportActionBar().hide();

        catatan = (Catatan) getIntent().getSerializableExtra("catatan");
        tv_tanggal=  findViewById(R.id.tv_viewtanggal);
        textCatatan=  findViewById(R.id.et_viewcatatan);
        textJudul=  findViewById(R.id.et_viewjudul);
        textKategori=  findViewById(R.id.et_viewkategori);
        Log.i("testsukses",catatan.getTanggal());

        tv_tanggal.setText(catatan.getTanggal().toString());
        textCatatan.setText(catatan.getCatatan().toString());
        textJudul.setText(catatan.getJudul().toString());
        textKategori.setText(catatan.getKategori().toString());
        btnBack = findViewById(R.id.backviewButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}