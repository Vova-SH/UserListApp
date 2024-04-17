package ru.samsung.userlistapp.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.samsung.userlistapp.data.source.UserApi;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;

    private RetrofitFactory() {}

    public static synchronized RetrofitFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public UserApi getUserApi() {
        return retrofit.create(UserApi.class);
    }
}
