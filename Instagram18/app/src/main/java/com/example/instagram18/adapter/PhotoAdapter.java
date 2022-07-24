package com.example.instagram18.adapter;

import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram18.R;
import com.example.instagram18.models.Photo;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> mList = new ArrayList<>();
    public PhotoAdapter(List<Photo> mList){
        this.mList = mList;
    }
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_in_list, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView imageView;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
