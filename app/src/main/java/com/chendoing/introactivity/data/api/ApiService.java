package com.chendoing.introactivity.data.api;

import com.chendoing.introactivity.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/shebao/next")
    Call<User> getUsers();
}
