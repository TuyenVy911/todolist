package com.example.instagram18.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.instagram18.R;
import com.example.instagram18.UpdateDeleteActivity;
import com.example.instagram18.adapter.PostAdapter;
import com.example.instagram18.adapter.UserAdapter;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.models.Post;
import com.example.instagram18.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    PostAdapter adapter;
    RecyclerView recyclerView;
    List<Post> postList;
    //TextView tvUsername;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//            Intent intent = Intent.getIntent(view);
//            String name = intent.getStringExtra("username");
//        tvUsername.setText(name);
        //tvUsername = view.findViewById(R.id.textviewUser);

        recyclerView = view.findViewById(R.id.home_recyclerview);
        postList = new ArrayList<>();

//        postList.add(new Post("user 1", "27/05/2022", "Hom nay toi buon"));
//        postList.add(new Post("user 2", "27/05/2022", "Bong muon khoc cho long nhe noi nhuc"));
//        postList.add(new Post("user 3", "27/05/2022", "Hahaa"));
//        postList.add(new Post("user 4", "27/05/2022", "hihi"));
//        postList.add(new Post("user 5", "27/05/2022", "hihe"));
//        postList.add(new Post("user 6", "27/05/2022", "hehe"));
//        postList.add(new Post("user 7", "27/05/2022", "hahe"));
//        postList.add(new Post("user 8", "27/05/2022", "hahi"));


        RetrofitClient.getRetrofitClient().getAllPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                for(Post post: posts){
                    postList.add(post);
                }
                adapter = new PostAdapter(postList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        //recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }


}