package ru.samsung.userlistapp.domain;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.function.Consumer;

import ru.samsung.userlistapp.domain.entites.FullUserEntity;
import ru.samsung.userlistapp.domain.entites.ItemUserEntity;
import ru.samsung.userlistapp.domain.entites.Status;

public interface UserRepository {
    void getAllUsers(@NonNull Consumer<Status<List<ItemUserEntity>>> callback);

    void getUser(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback);
}
