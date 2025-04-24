package com.example.baitap8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.baitap8.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderHolder> {
    private Context context;
    private List<Integer> imagesList;

    public SliderAdapter(Context context, List<Integer> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, parent, false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {
        Glide.with(context).load(imagesList.get(position)).into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }


    public class SliderHolder extends SliderViewAdapter.ViewHolder {
        private ImageView imageView;
        public SliderHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}
