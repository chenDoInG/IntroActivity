package com.chendoing.introactivity.model.rest;

import com.chendoing.introactivity.model.entities.Transform;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TranformService {

    @GET("/shebao/next")
    Call<Transform> getTranforms();
}
