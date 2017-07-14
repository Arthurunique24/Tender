package com.example.arthur.tender.SupportClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arthur.tender.R;

import java.util.List;

/**
 * Created by Arthur on 13.07.17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
    private List<JSONData> jsonDataList;

    public RVAdapter(List<JSONData> jsonDataList) {
        this.jsonDataList = jsonDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewNameOfPierce.setText(jsonDataList.get(position).getPierName());
        holder.textViewRegion.setText(jsonDataList.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return jsonDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNameOfPierce;
        public TextView textViewRegion;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNameOfPierce = (TextView) itemView.findViewById(R.id.textViewNameOfPierce1);
            textViewRegion = (TextView) itemView.findViewById(R.id.textViewRegion1);
        }
    }
}
