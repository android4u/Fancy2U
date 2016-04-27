package com.meunicorn.fancy2u.API;

import com.meunicorn.fancy2u.Bean.Shots.Shot;

import java.util.List;
import java.util.Properties;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Fancy on 2016/3/8.
 */
public interface DribbbleApi {
    String ACCESS_TOKEN="77b84e4c555d51ff97364319d2ac31fd3c49cbb5c79319b2f1cf28f3122ef9ee";
    @GET("v1/shots?"+ACCESS_TOKEN)
    Call<List<Shot>> getShotList(@Query("access_token") String token);

    @GET("v1/shots")
    Call<List<Shot>> getShotListOrderby(@Query("sort") String sort,@Query("page") int page,@Query("access_token") String token);

    @GET("v1/shots/{id}")
    Call<Shot> findShotById(@Query("id") int id,@Query("access_token") String token);


    
}
