package ru.samsung.userlistapp.ui.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import ru.samsung.userlistapp.databinding.ItemUserBinding;
import ru.samsung.userlistapp.domain.entites.ItemUserEntity;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    @NonNull
    private final Consumer<String> onItemClick;

    private final List<ItemUserEntity> data = new ArrayList<>();

    public UserListAdapter(@NonNull Consumer<String> onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemUserBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<ItemUserEntity> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemUserBinding binding;

        public ViewHolder(@NonNull ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ItemUserEntity item) {
            binding.name.setText(item.getName());
            binding.getRoot().setOnClickListener(v -> {
                onItemClick.accept(item.getId());
            });
        }
    }
}
