package com.example.slawomirmakurat.ekoagromarket.apiClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by slawomir.makurat on 2017-04-08.
 */

public class ApiClientFactory {



    OkHttpClient.Builder builder =  new OkHttpClient.Builder();
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    public ApiClient create() {

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://smtoudi.usermd.net/")
                .addConverterFactory(GsonConverterFactory.create())
//                .client(builder.build())
                .build();

        return retrofit.create(ApiClient.class);
    }
}


