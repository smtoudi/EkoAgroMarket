package com.example.slawomirmakurat.ekoagromarket.apiClient;

import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Login;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.LoginResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Register;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.StatusResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by slawomir.makurat on 2017-04-08.
 */

public interface ApiClient {


    @POST("/users/user/login")
    @Headers({"Content-Type: application/json"})
    Call<LoginResponse> login(@Body Login login);

    @POST("/users/user/new")
    @Headers({"Content-Type: application/json"})
    Call<LoginResponse> register(@Body Register register);

    @GET("/users/user/logout")
    Call<StatusResponse> logout(@Header("Token") String token);

    @GET("/users/user/")
    Call<User> getUser(@Query("id") Integer id);





}
