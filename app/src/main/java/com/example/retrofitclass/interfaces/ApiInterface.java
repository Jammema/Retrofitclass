package com.example.retrofitclass.interfaces;

import com.example.retrofitclass.model.FacebookResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/fb-feed")
    Call<FacebookResponse> getFBResponse();
}
