package com.example.anujtest.networkingCalling;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.anujtest.utils.Constant.BASE_URL;

public class ApiData {
    public static Retrofit retrofit = null;
    public static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
