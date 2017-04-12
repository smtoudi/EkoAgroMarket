package com.example.slawomirmakurat.ekoagromarket.apiClient;

import android.util.Log;

import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Login;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.LoginResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Register;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.User;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.UserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Status.ERROR;

/**
 * Created by slawomir.makurat on 2017-04-09.
 */

public class ApiManager {

    private static ApiClient ApiClient = new ApiClientFactory().create();

    public static void login(final Login login, final OnLoginListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(login);
        System.out.println(json);
       ApiClient.login(login).enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body().getStatus());
                    listener.onLogin(response.body());
                    listener.onLogin(response.body());
                } else {
                    listener.onLogin(new LoginResponse(ERROR, null, ""));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("API MANAGER", "onFailure: " + t.getMessage());
                Log.d("API MANAGER", "onFailure: " + t.getCause());
                Log.d("API MANAGER", "onFailure: " + t.getStackTrace());
            }
        });
    }

    public static void register(final Register register, final OnLoginListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(register);
        ApiClient.register(register).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body().getStatus());
                    listener.onLogin(response.body());
                } else {
                    listener.onLogin(new LoginResponse(ERROR, null, ""));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("API MANAGER", "onFailure: " + t.getMessage());
                Log.d("API MANAGER", "onFailure: " + t.getCause());
                Log.d("API MANAGER", "onFailure: " + t.getStackTrace());
            }
        });
    }

    public static void getUserInfo(Integer id, final OnAuthorFetchedListener listener) throws ApiConnectException {
        ApiClient.useerinfo(id).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    Log.d("!!! API DATA", response.body().toString());
                    listener.onAuthorFetched(response.body());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("API MANAGER", "onFailure: " + t.getMessage());
            }
        });

    }


    public interface OnLoginListener {
        void onLogin(LoginResponse response);
    }

    public interface OnAuthCheckListener {
        void onAuthCheck(Boolean response);
    }

    public interface OnAuthorFetchedListener {
        void onAuthorFetched(UserResponse userResponse);
    }

}
