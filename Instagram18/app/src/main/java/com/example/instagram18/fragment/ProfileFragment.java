package com.example.instagram18.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagram18.R;
import com.example.instagram18.SettingActivity;
import com.example.instagram18.StartActivity;
import com.example.instagram18.adapter.PostAdapter;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.models.Post;
import com.example.instagram18.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment  {
    Button btn_setting, btn_logout;
    PostAdapter adapter;
    RecyclerView recyclerView;
    List<Post> postList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_setting = view.findViewById(R.id.btn_setting);
        btn_logout = view.findViewById(R.id.btn_logout);
        recyclerView = view.findViewById(R.id.profile_recyclerview);
        postList = new ArrayList<>();
        RetrofitClient.getRetrofitClient().getAllPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                for(Post post: posts){
                    //if(post.getUsername().equals())
                    postList.add(post);
                }
                adapter = new PostAdapter(postList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You just click setting button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You just click logout button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
            }
        });
    }


}