package com.example.arthur.cardviewtenderfromjson;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arthur on 14.07.17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.DataViewHolder>{

    //here
    private OnRecyclerViewItemClickListener mClickListener;

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        TextView textViewRegion;

        public DataViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewRegion = (TextView) itemView.findViewById(R.id.textViewRegion);
        }
    }

    private List<DataJSON> dataList;

//    RVAdapter(List<DataJSON> dataList){
//        this.dataList = dataList;
//    }

    RVAdapter(OnRecyclerViewItemClickListener listener,List<DataJSON> dataList){
        mClickListener = listener;
        this.dataList = dataList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        DataViewHolder dvh = new DataViewHolder(v);
        return dvh;
    }

    private DataJSON getItem(int position){
        return dataList.get(position);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        holder.textViewName.setText(dataList.get(position).getPierName());
        holder.textViewRegion.setText(dataList.get(position).getRegion());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("myLog", "Click-clack position " + position);
                if (mClickListener != null){
                    Log.d("myLog", "mClickListener != null");
                    mClickListener.onClick(position);
                } else {Log.d("myLog", "mClickListener = null");}
            }
        });
    }

    //here
    public interface OnRecyclerViewItemClickListener {
        void onClick(int parameter);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
