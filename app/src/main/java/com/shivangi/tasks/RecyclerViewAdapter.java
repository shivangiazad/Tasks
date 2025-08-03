package com.shivangi.tasks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private List<MyListData> listdata;
    private Context context;

    public RecyclerViewAdapter(List<MyListData> listData, Context context) {
        this.listdata = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.rv_list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyListData currentItem = listdata.get(position);
        holder.tvname.setText(currentItem.getName());
        holder.desc.setText(currentItem.getDesc());
        holder.imageView.setImageResource(currentItem.getIng());

        // Open DetailActivity on clicking the item
        holder.btndesc.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", currentItem.getName());
            intent.putExtra("desc", currentItem.getDesc());
            intent.putExtra("imgId", currentItem.getIng());
            intent.putExtra("fullDesc", currentItem.getFullDesc());
            context.startActivity(intent);
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvname, desc;
        public Button btndesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iving);
            tvname = itemView.findViewById(R.id.tvname);
            desc = itemView.findViewById(R.id.desc);
            btndesc = itemView.findViewById(R.id.btndesc); // <-- Add this
        }
    }
}
