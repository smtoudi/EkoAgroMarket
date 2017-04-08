package com.example.slawomirmakurat.ekoagromarket.apiClient;

import android.util.Log;

import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.LoginResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Register;
import com.example.slawomirmakurat.ekoagromarket.user.Login;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Status.ERROR;

/**
 * Created by slawomir.makurat on 2017-04-08.
 */

public class ApiManager {


    private static ApiClient apiClient = new ApiClientFactory().create();

    public static void login(final Login login, final OnLoginListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(login);
        System.out.println(json);
        apiClient.login(login).enqueue(new Callback<LoginResponse>() {

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

    public static void register(final Register register, final OnRegisterListener listener) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(register);
        System.out.println(json);
        apiClient.register(register).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body().getStatus());
                    listener.onRegister(response.body());
                } else {
                    listener.onRegister(new RegisterResponse(ERROR, null, ""));
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d("API MANAGER", "onFailure: " + t.getMessage());
                Log.d("API MANAGER", "onFailure: " + t.getCause());
                Log.d("API MANAGER", "onFailure: " + t.getStackTrace());

            }
        });
    }


    public interface OnLoginListener {
        void onLogin(LoginResponse response);
    }

    public interface OnRegisterListener {
       void onRegister(RegisterResponse response);
    }

}
