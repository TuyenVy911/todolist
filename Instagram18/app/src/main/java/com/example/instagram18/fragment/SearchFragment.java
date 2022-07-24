package com.example.instagram18.fragment;

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
import android.widget.EditText;
import android.widget.Toast;

import com.example.instagram18.R;
import com.example.instagram18.adapter.UserAdapter;
import com.example.instagram18.api.RetrofitClient;
import com.example.instagram18.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    RecyclerView recyclerView;
    UserAdapter adapter;
    List<User> userList;
    Button btn_follow, btn_searchForUsername;
    EditText edittextSearchUsername;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_follow = view.findViewById(R.id.btn_follow);
        btn_searchForUsername = view.findViewById(R.id.btn_searchforusername);
        edittextSearchUsername = view.findViewById(R.id.editTextSearchFor);

        recyclerView = view.findViewById(R.id.search_recyclerview);
        userList = new ArrayList<>();

        RetrofitClient.getRetrofitClient().getAllUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                for(User user: users){
                    userList.add(user);
                }
                adapter = new UserAdapter(userList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

//        btn_follow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "change follow to following!", Toast.LENGTH_SHORT).show();
//                btn_follow.setText("FOLLOWING");
//            }
//        });

        btn_searchForUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "call api user has same username!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}