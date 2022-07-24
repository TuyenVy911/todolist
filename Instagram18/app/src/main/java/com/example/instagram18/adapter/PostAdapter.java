package com.example.instagram18.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram18.R;
import com.example.instagram18.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    List<Post> listPost;

    public PostAdapter(List<Post> listPost) {
        this.listPost = listPost;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_in_list, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //fix
        holder.username.setText(listPost.get(position).getUsername());
        holder.createdate.setText(listPost.get(position).getCreateDate());
        holder.content.setText(listPost.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username, createdate, content;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView1);
            username = itemView.findViewById(R.id.tvUsername);
            createdate = itemView.findViewById(R.id.tvCreatedate);
            content = itemView.findViewById(R.id.tvContent);

        }
    }
}
