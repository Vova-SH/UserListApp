package ru.samsung.userlistapp.domain.sign;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.userlistapp.domain.entites.Status;

public interface SignUserRepository {
    void isExistUser(@NonNull String login, Consumer<Status<Void>> callback);
    void createAccount(
            @NonNull String login,
            @NonNull String password,
            Consumer<Status<Void>> callback
    );
    void login(
            @NonNull String login,
            @NonNull String password,
            Consumer<Status<Void>> callback
    );

    void logout();
}
