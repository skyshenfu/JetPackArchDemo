package com.zty.archdemo.ui.navdemo.list.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zty.archdemo.R;
import com.zty.archdemo.databinding.ItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class DemoItemAdapter extends RecyclerView.Adapter<DemoItemViewHolder> {
    private List<Integer> dataList=new ArrayList<>();
    @NonNull
    @Override
    public DemoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding itemListBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_list,parent,false);
        return new DemoItemViewHolder(itemListBinding);
    }

    public void setDataList(List<Integer> dataList) {
        this.dataList = dataList;
    }

    @Override
    public void onBindViewHolder(@NonNull DemoItemViewHolder holder, int position) {
        holder.getItemListBinding().setTextBean(dataList.get(position));
        holder.getItemListBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class DemoItemViewHolder extends RecyclerView.ViewHolder {
    private  ItemListBinding itemListBinding;

    public DemoItemViewHolder(ItemListBinding itemListBinding) {
        super(itemListBinding.getRoot());
        this.itemListBinding=itemListBinding;
    }

    public ItemListBinding getItemListBinding() {
        return itemListBinding;
    }

}