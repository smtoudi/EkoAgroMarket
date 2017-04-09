package com.example.slawomirmakurat.ekoagromarket.apiClient;

import android.util.Log;

import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Login;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.LoginResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Register;
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

    private static ApiClient newsApiClient = new ApiClientFactory().create();

    public static void login(final Login login, final OnLoginListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(login);
        System.out.println(json);
        newsApiClient.login(login).enqueue(new Callback<LoginResponse>() {

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

    public static void register(final Register register, final OnLoginListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(register);
        newsApiClient.register(register).enqueue(new Callback<LoginResponse>() {
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


//    public static void checkAuth(String token, final OnAuthCheckListener listener) {
//
//        ApiClient.checkAuth(token).enqueue(new Callback<AuthResponse>() {
//            @Override
//            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
//                listener.onAuthCheck(response.body().isStatus());
//            }
//
//            @Override
//            public void onFailure(Call<AuthResponse> call, Throwable t) {
//                Log.d("API MANAGER", "onFailure: " + t.getMessage());
//                Log.d("API MANAGER", "onFailure: " + t.getCause());
//                Log.d("API MANAGER", "onFailure: " + t.getStackTrace());
//
//            }
//        });
//    }



    public interface OnLoginListener {
        void onLogin(LoginResponse response);
    }

    public interface OnAuthCheckListener {
        void onAuthCheck(Boolean response);
    }


}
