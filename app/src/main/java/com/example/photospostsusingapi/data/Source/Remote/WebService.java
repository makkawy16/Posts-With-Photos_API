package com.example.photospostsusingapi.data.Source.Remote;

import com.example.photospostsusingapi.data.Model.PhotoResponseItem;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

     // leh call 3shan ana msh 3arf w2tha amta m3rfsh htakhod ad eh  call btshtghl fl main thread

    @GET("photos")
    Call<List<PhotoResponseItem>> getPhotos();
}
