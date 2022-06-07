package com.alimuntung.a10119260uts.Presenter.catatan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class CatatanView extends AppCompatActivity implements Serializable {
    private Catatan catatan;
    private TextView tv_tanggal,textCatatan,textJudul,textKategori;
    private FloatingActionButton btnBack,btnDelete,btnEdit;
    private ICatatanQuery catatanInterface;


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

        btnDelete = findViewById(R.id.deleteButton);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(CatatanView.this)
                        .setTitle("Hapus Catatan")
                        .setMessage("Are you sure you want to delete this entry?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                deleteCatatan();
                                finish();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        btnEdit = findViewById(R.id.editviewButton);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatatanView.this, CatatanEdit.class);
                intent.putExtra("catatan", catatan);
                startActivity(intent);
                finish();
            }
        });

    }
    private void deleteCatatan(){
        catatanInterface = new CatatanQuery(this);

        if(catatanInterface.delete(catatan.getId())){
            Toast.makeText(CatatanView.this,"Catatan Berhasil Dihapus",Toast.LENGTH_SHORT ).show();
            finish();
        }
    }
}