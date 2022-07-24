package com.example.instagram18.models;

import java.io.Serializable;

public class Post implements Serializable {
    private int postId;
    //private User user;
    private String username;
    private String createDate;
    private String content;

    public Post() {
    }

    public Post(int postId, String username, String createDate, String content) {
        this.postId = postId;
        this.username = username;
        this.createDate = createDate;
        this.content = content;
    }

    public Post(String username, String createDate, String content) {
        this.username = username;
        this.createDate = createDate;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//
//    public Post(int postId, User user, String createDate, String content) {
//        this.postId = postId;
//        this.user = user;
//        this.createDate = createDate;
//        this.content = content;
//    }
//
//    public Post(User user, String createDate, String content) {
//        this.user = user;
//        this.createDate = createDate;
//        this.content = content;
//    }
//
//    public int getPostId() {
//        return postId;
//    }
//
//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(String createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}
