package com.mgadevelop.moveey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMoveeyAdapter extends RecyclerView.Adapter<ListMoveeyAdapter.ViewHolder> {

    private Context movContext;
    private ArrayList<MoveeyModel> modelList;
    private ListMoveeyAdapter.OnItemClickListener mItemClickListener;

    public ListMoveeyAdapter(Context context, ArrayList<MoveeyModel> modelList) {
        this.movContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<MoveeyModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moveey_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof RecyclerView.ViewHolder) {
            final MoveeyModel model = getItem(position);

            holder.judul.setText(model.getJudul());

            if(model.getSinopsis().length()>50){
                holder.sinopsis.setText(model.getSinopsis().substring(0,49)+" ...");
            }else{
                holder.sinopsis.setText(model.getSinopsis());
            }

            holder.poster.setImageResource(model.getPoster());

        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private MoveeyModel getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, MoveeyModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        private TextView judul, sinopsis;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.poster = itemView.findViewById(R.id.poster);
            this.judul = itemView.findViewById(R.id.judul);
            this.sinopsis = itemView.findViewById(R.id.sinopsis);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });

        }
    }

}


