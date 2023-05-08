package com.example.ceres;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class espGetData {

    public static String getData(String userUrl){

        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(userUrl)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException erro){
                return null;
            }

    }
}
