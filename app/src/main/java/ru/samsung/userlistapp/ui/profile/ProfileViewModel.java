package ru.samsung.userlistapp.ui.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.samsung.userlistapp.data.UserRepositoryImpl;
import ru.samsung.userlistapp.domain.GetUserByIdUseCase;
import ru.samsung.userlistapp.domain.entites.FullUserEntity;

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<State> mutableStateLiveData = new MutableLiveData<>();

    public final LiveData<State> stateLiveData = mutableStateLiveData;

    public final GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(
            UserRepositoryImpl.getInstance()
    );

    public void load(@NonNull String id) {
        mutableStateLiveData.setValue(new State(null, null, true));
        getUserByIdUseCase.execute(id, (status) -> {
            mutableStateLiveData.postValue(new State(
                    status.getErrors() != null ? status.getErrors().getLocalizedMessage() : null,
                    status.getValue(),
                    false
            ));
        });
    }


    public class State {
        @Nullable
        private final String errorMessage;

        @Nullable
        private final FullUserEntity user;

        private final boolean isLoading;

        public State(@Nullable String errorMessage, @Nullable FullUserEntity user, boolean isLoading) {
            this.errorMessage = errorMessage;
            this.user = user;
            this.isLoading = isLoading;
        }

        @Nullable
        public String getErrorMessage() {
            return errorMessage;
        }

        @Nullable
        public FullUserEntity getUser() {
            return user;
        }

        public boolean isLoading() {
            return isLoading;
        }
    }
}
