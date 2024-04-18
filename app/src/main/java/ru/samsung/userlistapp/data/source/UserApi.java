package ru.samsung.userlistapp.data.source;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.samsung.userlistapp.data.dto.AccountDto;
import ru.samsung.userlistapp.data.dto.UserDto;

public interface UserApi {
    @GET("edu/v1/user")
    Call<List<UserDto>> getAll();
    @GET("edu/v1/user/{id}")
    Call<UserDto> getById(@Path("id") String id);
    @GET("/edu/v1/user/username/{username}")
    Call<Void> isExist(@Path("username") String login);
    @POST("edu/v1/user/register")
    Call<Void> register(@Body AccountDto dto);
    @GET("edu/v1/user/login")
    Call<Void> login();
}
