package com.example.photospostsusingapi.Ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photospostsusingapi.data.Model.PhotoResponseItem;
import com.example.photospostsusingapi.databinding.ItemPostLayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.viewHolder> {
    List<PhotoResponseItem> photos;

    public void addPhotos(List<PhotoResponseItem> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostLayoutBinding binding =
                ItemPostLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        PhotoResponseItem photo = photos.get(position);
        holder.binding.postId.setText(String.valueOf(photo.getId()));
        holder.binding.postTitle.setText(photo.getTitle());
        Picasso.get().load(photo.getUrl()).into(holder.binding.imgInPost);


    }

    @Override
    public int getItemCount() {
        return photos == null ? 0 : photos.size();
    }


    static class viewHolder extends RecyclerView.ViewHolder {
        ItemPostLayoutBinding binding;

        public viewHolder(ItemPostLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
