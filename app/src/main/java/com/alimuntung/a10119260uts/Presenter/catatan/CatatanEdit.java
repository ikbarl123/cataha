package com.alimuntung.a10119260uts.Presenter.catatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuntung.a10119260uts.Model.Catatan;
import com.alimuntung.a10119260uts.Model.CatatanQuery;
import com.alimuntung.a10119260uts.Model.ICatatanQuery;
import com.alimuntung.a10119260uts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260

public class CatatanEdit extends AppCompatActivity implements Serializable {
    private FloatingActionButton btnBack,btnSave;
    private EditText textCatatan,textJudul,textKategori;
    private TextView tv_tanggal;
    private String tanggalskrg;
    private ICatatanQuery catatanInterface;
    private Catatan catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_edit);
        getSupportActionBar().hide();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       // tanggalskrg = LocalDate.now().format(formatter);
        btnBack = findViewById(R.id.backeditButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CatatanEdit.this,"kembali Succes",Toast.LENGTH_SHORT ).show();
                finish();
            }
        });

        tv_tanggal=findViewById(R.id.tv_tanggal);
        btnSave = findViewById(R.id.saveeditButton);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCatatan();
            }
        });

        catatan = (Catatan) getIntent().getSerializableExtra("catatan");
        tv_tanggal=  findViewById(R.id.tv_edittanggal);
        textCatatan = findViewById(R.id.et_editcatatan);
        textJudul= findViewById(R.id.et_editjudul);
        textKategori= findViewById(R.id.et_editkategori);
        Log.i("testsukses",catatan.getTanggal());

        tv_tanggal.setText(catatan.getTanggal().toString());
        textCatatan.setText(catatan.getCatatan().toString());
        textJudul.setText(catatan.getJudul().toString());
        textKategori.setText(catatan.getKategori().toString());
    }

    private void saveCatatan(){
        catatanInterface = new CatatanQuery(this);

        Catatan updatedcatatan = new Catatan(
                catatan.getId(),
                tanggalskrg,
                textCatatan.getText().toString(),
                textJudul.getText().toString(),//judul
                textKategori.getText().toString()//kategori
        );

        if(catatanInterface.update(updatedcatatan)){
            Toast.makeText(CatatanEdit.this,"Catatan Berhasil Ditambahkan",Toast.LENGTH_SHORT ).show();
            finish();
        }
    }

    private static String generateRandomText(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}