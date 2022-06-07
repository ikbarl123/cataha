package com.alimuntung.a10119260uts.Presenter.catatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuntung.a10119260uts.Model.Catatan;
import com.alimuntung.a10119260uts.Model.CatatanQuery;
import com.alimuntung.a10119260uts.Model.ICatatanQuery;
import com.alimuntung.a10119260uts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CatatanInput extends AppCompatActivity {
    private FloatingActionButton btnBack,btnSave;
    private EditText textCatatan,textJudul,textKategori;
    private TextView tv_tanggal;
    private String tanggalskrg;
    private ICatatanQuery catatanInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_catatan_input);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        tanggalskrg = LocalDate.now().format(formatter);
        btnBack = findViewById(R.id.backButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CatatanInput.this,"kembali Succes",Toast.LENGTH_SHORT ).show();
                finish();
            }
        });

        tv_tanggal=findViewById(R.id.tv_tanggal);
        tv_tanggal.setText(tanggalskrg);
        btnBack = findViewById(R.id.saveButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCatatan();
            }
        });

    }

    private void saveCatatan(){
        catatanInterface = new CatatanQuery(this);
        textCatatan = findViewById(R.id.et_catatan);
        textJudul= findViewById(R.id.et_judul);
        textKategori= findViewById(R.id.et_kategori);
        Catatan catatan = new Catatan(
                generateRandomText(),
                tanggalskrg,
                textCatatan.getText().toString(),
                textJudul.getText().toString(),//judul
                textKategori.getText().toString()//kategori
        );

        if(catatanInterface.create(catatan)){
            Toast.makeText(CatatanInput.this,"Catatan Berhasil Ditambahkan",Toast.LENGTH_SHORT ).show();
            finish();
        }
    }

    private static String generateRandomText(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}