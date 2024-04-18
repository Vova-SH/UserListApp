package ru.samsung.userlistapp.ui.sign;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.samsung.userlistapp.R;
import ru.samsung.userlistapp.databinding.FragmentSignBinding;
import ru.samsung.userlistapp.ui.utils.OnChangeText;
import ru.samsung.userlistapp.ui.utils.Utils;

public class SignFragment extends Fragment {

    private FragmentSignBinding binding;
    private SignViewModel viewModel;
    public SignFragment() {
        super(R.layout.fragment_sign);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSignBinding.bind(view);
        viewModel = new ViewModelProvider(this).get(SignViewModel.class);
        binding.login.addTextChangedListener(new OnChangeText() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                viewModel.changeLogin(s.toString());
            }
        });
        binding.password.addTextChangedListener(new OnChangeText() {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                viewModel.changePassword(s.toString());
            }
        });
        binding.confirm.setOnClickListener(v -> viewModel.confirm());
        subscribe(viewModel);
    }

    private void subscribe(SignViewModel viewModel) {
        viewModel.errorLiveData.observe(getViewLifecycleOwner(), error -> {
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        });
        viewModel.stateLiveData.observe(getViewLifecycleOwner(), state -> {
            binding.confirm.setText(state.getButton());
            binding.title.setText(state.getTitle());
            binding.password.setVisibility(Utils.visibleOrGone(state.isPasswordEnabled()));
        });
        viewModel.openListLiveData.observe(getViewLifecycleOwner(), (unused) -> {
            final View view = getView();
            if (view == null) return;
            Navigation.findNavController(view).navigate(R.id.action_signFragment_to_listFragment);
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
