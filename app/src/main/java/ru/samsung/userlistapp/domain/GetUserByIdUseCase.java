package ru.samsung.userlistapp.domain;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.userlistapp.domain.entites.FullUserEntity;
import ru.samsung.userlistapp.domain.entites.Status;

public class GetUserByIdUseCase {
    private final UserRepository repo;

    public GetUserByIdUseCase(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback) {
        repo.getUser(id, callback);
    }
}
