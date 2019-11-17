package com.drivetests.androidtask2.api_interface;

import com.drivetests.androidtask2.model.ListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_by_date?tags=story&")
    Call<ListModel> getListData(@Query("page") String page);
}
