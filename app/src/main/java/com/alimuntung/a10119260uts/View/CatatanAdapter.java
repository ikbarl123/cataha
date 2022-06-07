package com.alimuntung.a10119260uts.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.a10119260uts.Model.Catatan;
import com.alimuntung.a10119260uts.Model.CatatanQuery;
import com.alimuntung.a10119260uts.Model.CatatanListener;
import com.alimuntung.a10119260uts.R;

import java.util.List;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder> {
    private List<Catatan> catatanList;
    private CatatanListener listener;



    public CatatanAdapter(List<Catatan> catatanList, CatatanListener listener){
        this.catatanList= catatanList;
        this.listener=listener;


    }

    @NonNull
    @Override
    public CatatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.catatanitems,parent,false);
        return new CatatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanViewHolder viewHolder, int position) {
        viewHolder.getTv_kategori().setText(catatanList.get(position).getKategori());
        viewHolder.getTv_judul().setText(catatanList.get(position).getJudul());
        viewHolder.getTv_tanggal().setText(catatanList.get(position).getTanggal());
        viewHolder.getcardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(catatanList.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return catatanList.size();
    }

    public class CatatanViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_tanggal, tv_kategori,tv_judul;
        private CardView cardView;

        public  CatatanViewHolder(@NonNull View itemView){
        super(itemView);
        tv_tanggal=  itemView.findViewById(R.id.tv_tanggalv);
        tv_kategori=  itemView.findViewById(R.id.tv_kategoriv);
        tv_judul=  itemView.findViewById(R.id.tv_judulv);
        cardView= itemView.findViewById(R.id.cvCatatan);
        }
        public TextView getTv_tanggal(){
            return tv_tanggal;
        }
        public TextView getTv_kategori(){
            return tv_kategori;
        }
        public TextView getTv_judul(){
            return tv_judul;
        }
        public CardView getcardView(){
            return cardView;
        }
    }


}



