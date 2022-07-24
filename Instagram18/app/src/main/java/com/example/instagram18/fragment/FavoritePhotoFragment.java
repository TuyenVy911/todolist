package com.example.instagram18.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.instagram18.R;
import com.example.instagram18.adapter.PhotoAdapter;
import com.example.instagram18.models.Photo;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FavoritePhotoFragment extends Fragment {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_favoritephoto, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.favorphotoRecylerview);
        recyclerView.setHasFixedSize(true);

        List<Photo> mList = new ArrayList<>();
        mList.add(new Photo(R.drawable.pic01));
        mList.add(new Photo(R.drawable.pic02));
        mList.add(new Photo(R.drawable.pic11));
        mList.add(new Photo(R.drawable.pic03));
        mList.add(new Photo(R.drawable.pic04));
        mList.add(new Photo(R.drawable.pic05));
        mList.add(new Photo(R.drawable.pic06));
        mList.add(new Photo(R.drawable.pic07));
        mList.add(new Photo(R.drawable.pic08));
        mList.add(new Photo(R.drawable.pic09));
        mList.add(new Photo(R.drawable.pic10));
        mList.add(new Photo(R.drawable.pic12));
        mList.add(new Photo(R.drawable.pic13));
        mList.add(new Photo(R.drawable.pic14));
        mList.add(new Photo(R.drawable.pic15));
        mList.add(new Photo(R.drawable.pic16));
        mList.add(new Photo(R.drawable.pic17));
        mList.add(new Photo(R.drawable.pic18));
        mList.add(new Photo(R.drawable.pic19));
        mList.add(new Photo(R.drawable.pic20));
        mList.add(new Photo(R.drawable.pic21));
        mList.add(new Photo(R.drawable.pic22));
        mList.add(new Photo(R.drawable.pic23));
        mList.add(new Photo(R.drawable.pic24));
        mList.add(new Photo(R.drawable.pic25));
        mList.add(new Photo(R.drawable.pic26));
        mList.add(new Photo(R.drawable.pic27));
        mList.add(new Photo(R.drawable.pic28));
        mList.add(new Photo(R.drawable.pic29));
        mList.add(new Photo(R.drawable.pic30));


        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        PhotoAdapter adapter = new PhotoAdapter(mList);
        recyclerView.setAdapter(adapter);
    }

}