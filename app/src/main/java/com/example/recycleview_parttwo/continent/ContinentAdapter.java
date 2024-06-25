package com.example.recycleview_parttwo.continent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleview_parttwo.OnItemClick;
import com.example.recycleview_parttwo.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Continent> continentList;
    private OnItemClick onItemClick;

    public ContinentAdapter(ArrayList<Continent> continentList,OnItemClick onItemClick) {
        this.continentList = continentList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(continentList.get(position));
        holder.itemView.setOnClickListener(v->{
            onItemClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    private ItemContinentBinding binding;

    public ViewHolder(@NonNull ItemContinentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Continent continent){
        binding.tvContinent.setText(continent.getName());
        Glide.with(binding.imgContinent).load(continent.getImg()).into(binding.imgContinent);
    }
}
