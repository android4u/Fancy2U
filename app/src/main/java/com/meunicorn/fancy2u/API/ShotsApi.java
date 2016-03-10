package com.meunicorn.fancy2u.API;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.model.ShotsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Fancy on 2016/3/8.
 */
public interface ShotsApi{
    @Headers(value = {"access_token:77b84e4c555d51ff97364319d2ac31fd3c49cbb5c79319b2f1cf28f3122ef9ee"})
    @GET("shots")
    Call<List<Shot>> getShotList();

    @GET("/shots/{sort}")
    Call<Shot> getShotListOrderby(@Path("order") String sort);
}
