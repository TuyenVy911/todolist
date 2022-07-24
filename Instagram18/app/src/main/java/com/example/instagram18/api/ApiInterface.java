package com.example.instagram18.api;

import com.example.instagram18.models.Post;
import com.example.instagram18.models.User;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    //register
    //instagram/user/register
    @POST("instagram/user/register")
    Call<User> register(@Body User user);

    //add post data to spring
    //instagram/user/addpost
    @POST("instagram/post/add")
    Call<Post> add(@Body Post post);

    //login
    //instagram/user/login
    @GET("instagram/user/login")
    Call<User> login(@Query("username") String username, @Query("password") String password);

//    //instagram/post/user
//    @GET("instagram/post/user")
//    Call<List<Post>> getPostByUser(@Body User user);


    @GET("instagram/user")
    Call<List<User>> getAllUser();

    @GET("instagram/post")
    Call<List<Post>> getAllPost();

    //find by id
    @GET("instagram/user/{id}")
    Call<User> showUserInfor(@Query("email") String email, @Query("fullname") String fullname,
                             @Query("username") String username, @Query("password") String password);

//    public Optional<User> findById(@PathVariable int id){
//        return userRepository.findById(id);
//    }
}
