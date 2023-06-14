package com.example.kos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class list_kos_ui extends RecyclerView.Adapter<list_kos_ui.ListViewHolder> {

    private ArrayList<kos_ui> listkos;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    public list_kos_ui(ArrayList<kos_ui> list){
        this.listkos = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kos_ui, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull list_kos_ui.ListViewHolder holder, int position) {
        kos_ui kos_ui = listkos.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kos_ui.getPhoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.imgphoto);
        holder.tvname.setText(kos_ui.getName());
        holder.jarak.setText(kos_ui.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listkos.get(holder.getAbsoluteAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listkos.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgphoto;
        TextView tvname;
        TextView jarak;

        public ListViewHolder(View itemview) {
            super(itemview);
            imgphoto = itemview.findViewById(R.id.gambar);
            jarak = itemview.findViewById(R.id.item_jarakkos);
            tvname = itemview.findViewById(R.id.item_name);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(kos_ui kos_ui);
    }
}
