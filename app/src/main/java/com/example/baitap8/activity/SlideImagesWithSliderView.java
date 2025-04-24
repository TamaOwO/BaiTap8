package com.example.baitap8.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitap8.R;
import com.example.baitap8.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SlideImagesWithSliderView extends AppCompatActivity {
    private SliderView imageSlider;
    private ArrayList<Integer> imagesList;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slide_images_with_slider_view);

        imageSlider = findViewById(R.id.imageSlider);
        imagesList = new ArrayList<>();
        imagesList.add(R.drawable.icon1);
        imagesList.add(R.drawable.icon2);
        imagesList.add(R.drawable.icon8);
        imagesList.add(R.drawable.icon9);

        sliderAdapter = new SliderAdapter(getApplicationContext(), imagesList);
        imageSlider.setSliderAdapter (sliderAdapter);
        imageSlider.setIndicatorAnimation (IndicatorAnimationType.WORM);
        imageSlider.setAutoCycleDirection (SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        imageSlider.setIndicatorSelectedColor(getResources().getColor(R.color.red));
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.startAutoCycle();
        imageSlider.setScrollTimeInSec (5);
    }
}