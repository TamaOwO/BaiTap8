package com.example.baitap8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.baitap8.R;
import com.example.baitap8.adapter.ImagesViewPageAdapter;
import com.example.baitap8.model.Images;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class SlideImagesWithCircleIndicatorAndViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private List<Images> imagesList;
    private ImagesViewPageAdapter imagesViewPageAdapter;
    private Button btnNextSlideRetrofit;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager.getCurrentItem() == imagesList.size() - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slide_images_with_circle_indicator_and_view_pager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewpage);
        circleIndicator = findViewById(R.id.circleIndicator);
        imagesList = getImagesList();
        imagesViewPageAdapter = new ImagesViewPageAdapter(imagesList);
        viewPager.setAdapter(imagesViewPageAdapter);
        btnNextSlideRetrofit = findViewById(R.id.btnNextSlideRetrofit);
        btnNextSlideRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SlideImagesWithCircleIndicatorAndViewPagerActivity.this, SlideImagesWithRetrofitActivity.class);
                startActivity(intent);
            }
        });

        // Lien ket viewpager voi Indicator
        circleIndicator.setViewPager(viewPager);

        // Gọi runable
        handler.postDelayed(runnable, 3000);
        // Lắng nghe viewpager chuyển trang
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<Images> getImagesList() {
        List<Images> imagesList = new ArrayList<>();
        imagesList.add(new Images(R.drawable.quangcao));
        imagesList.add(new Images(R.drawable.coffee));
        imagesList.add(new Images(R.drawable.companypizza));
        imagesList.add(new Images(R.drawable.themoingon));
        return imagesList;
    }
}