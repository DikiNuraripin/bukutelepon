package com.example.bukutelepon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterpace {

    @GET("7debbe8a")
    Call<List<Teman>> getTeman();
}
