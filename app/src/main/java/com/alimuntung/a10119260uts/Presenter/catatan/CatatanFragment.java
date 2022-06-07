package com.alimuntung.a10119260uts.Presenter.catatan;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.a10119260uts.Model.Catatan;
import com.alimuntung.a10119260uts.Model.CatatanListener;
import com.alimuntung.a10119260uts.Model.CatatanQuery;
import com.alimuntung.a10119260uts.Model.ICatatanQuery;
import com.alimuntung.a10119260uts.R;
import com.alimuntung.a10119260uts.View.CatatanAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class CatatanFragment extends Fragment implements CatatanListener  {

    private RecyclerView rv_catatan;
    private List<Catatan> catatanList;
    private ICatatanQuery catatanInterface;
    private CatatanAdapter catatanAdapter;
    private FloatingActionButton btnAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void read() {
        catatanList = new ArrayList<>();
        catatanInterface = new CatatanQuery(getActivity());
        Cursor cursor=catatanInterface.read();
        if(cursor.moveToFirst()){
            do{
                Catatan catatan = new Catatan(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                Log.i("tulisan",catatan.getKategori().toString());
                catatanList.add(catatan);
            }while(cursor.moveToNext());
        }
        RecyclerView rv_catatan = getView().findViewById(R.id.rvcatatan);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_catatan.setLayoutManager(layoutManager);
        catatanAdapter = new CatatanAdapter(catatanList, this);
        rv_catatan.setAdapter(catatanAdapter);
        Log.i("testsukses","catatan success");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_catatan, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAdd = getView().findViewById(R.id.addButton);
        read();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CatatanInput.class);
                startActivity(intent);
                catatanAdapter.notifyDataSetChanged();
            }
        });

    Log.i("testsukses","oncreate success");

    }

    @Override
    public void onItemClicked(Catatan catatan) {
        Intent intent = new Intent(getActivity(),CatatanView.class);
        intent.putExtra("catatan", catatan);
        startActivity(intent);
       // Toast.makeText(getActivity(),catatan.getTanggal(),Toast.LENGTH_SHORT).show();
        Log.i("testsukses","text Succes");
    }


}