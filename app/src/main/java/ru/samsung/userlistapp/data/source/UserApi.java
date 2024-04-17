package ru.samsung.userlistapp.data.source;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.samsung.userlistapp.data.dto.UserDto;

public interface UserApi {
    @GET("user")
    Call<List<UserDto>> getAll();
    @GET("user/{id}")
    Call<UserDto> getById(@Path("id") String id);
}
