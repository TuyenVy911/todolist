package com.example.instagram18.adapter;

import android.content.Context;
import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram18.R;
import com.example.instagram18.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    List<User> userList;
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_in_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.username.setText(userList.get(position).getUsername());
        holder.fullname.setText(userList.get(position).getFullname());
        holder.email.setText(userList.get(position).getEmail());
        //holder.password.setText(userList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username, fullname, email, password;
        private CardView cardView;
        private Button btn_follow1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_follow1 = itemView.findViewById(R.id.btn_follow);
            cardView = itemView.findViewById(R.id.cardView2);
            username = itemView.findViewById(R.id.tvUsername);
            fullname = itemView.findViewById(R.id.tvFullname);
            email = itemView.findViewById(R.id.tvEmail);
            //password = itemView.findViewById(R.id.tvPassword);
        }
    }
}
