package com.example.baitap8.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap8.R;
import com.example.baitap8.model.Images;

import java.util.List;

public class ImageViewPager2Adapter extends RecyclerView.Adapter<ImageViewPager2Adapter.ImageViewHolder> {
    private List<Images> imagesList;
    private Images images;

    public ImageViewPager2Adapter(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        images = imagesList.get(position);
        if(images == null)
            return;
        holder.imageView.setImageResource(images.getImageId());
    }

    @Override
    public int getItemCount() {
        if (imagesList != null) {
            return imagesList.size();
        } else {
            return 0;
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
        }
    }
}
