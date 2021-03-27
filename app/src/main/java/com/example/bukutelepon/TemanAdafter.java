package com.example.bukutelepon;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TemanAdafter extends RecyclerView.Adapter<TemanAdafter.TemanHolder>{
 List<Teman>dataTeman;
 Activity activity;

    public TemanAdafter(List<Teman> dataTeman, Activity activity) {
        this.dataTeman = dataTeman;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TemanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_item,parent,false);
        return new TemanHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull TemanHolder holder, int position) {
        holder.txtNama.setText(dataTeman.get(position).getNama());
        holder.txtNoTelp.setText(dataTeman.get(position).getNo_telp());

    }

    @Override
    public int getItemCount() {
        return dataTeman.size();
    }

    static class TemanHolder extends RecyclerView.ViewHolder {
        TextView txtNama,txtNoTelp;

        public TemanHolder(@NonNull View itemView) {
            super(itemView);
            txtNama=(TextView)itemView.findViewById(R.id.txt_Nama);
            txtNoTelp=(TextView)itemView.findViewById(R.id.txt_NoTelp);
        }
    }
}
