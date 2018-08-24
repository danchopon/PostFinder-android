package com.bk.postfinder.services;

import com.bk.postfinder.models.PostOfficeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface PostOfficeService {

    @GET("/post-offices")
    Call<List<PostOfficeModel>> getPostOffices();

    @GET("/calculate")
    Call<PostOfficeModel> calculate(@Body PostOfficeModel postOfficeModel);

}
