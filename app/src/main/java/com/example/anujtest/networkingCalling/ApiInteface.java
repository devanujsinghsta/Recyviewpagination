package com.example.anujtest.networkingCalling;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiInteface {
    @GET
    Call<ModelData> getdata(@Url String pageNumber);

}
