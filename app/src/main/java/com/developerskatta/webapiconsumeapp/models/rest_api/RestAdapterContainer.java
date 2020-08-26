package com.developerskatta.webapiconsumeapp.models.rest_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.developerskatta.webapiconsumeapp.utils.Constants.SERVER_ENDPOINT;

public class RestAdapterContainer {
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder().baseUrl(SERVER_ENDPOINT).addConverterFactory(
                    GsonConverterFactory.create()).build();
        }
        return instance;
    }
}