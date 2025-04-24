package com.example.baitap8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.baitap8.R;
import com.example.baitap8.adapter.ImagesSliderAdapter;
import com.example.baitap8.model.MessageModel;
import com.example.baitap8.retrofit.ApiService;
import com.example.baitap8.retrofit.RetrofitClient;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;

public class SlideImagesWithRetrofitActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private CircleIndicator3 circleIndicator;
    private ImagesSliderAdapter adapter;
    private ApiService apiService;
    private Button btnNextC3P2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slide_images_with_retrofit);

        // Initialize views
        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.circleIndicator);

        btnNextC3P2 = findViewById(R.id.btnNextC3P2);

        btnNextC3P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SlideImagesWithRetrofitActivity.this, SlideImagesWithCircle3AndPager2.class);
                startActivity(intent);
            }
        });

        // Initialize adapter with empty list
        adapter = new ImagesSliderAdapter(new ArrayList<>(), this);
        viewPager.setAdapter(adapter);

        // Connect indicator with ViewPager2
        circleIndicator.setViewPager(viewPager);

        // Initialize Retrofit
        apiService = RetrofitClient.getClient().create(ApiService.class);

        // Load images from API
        loadImagesFromApi();
    }

    private void loadImagesFromApi(){
        // Assuming position 1 for your example, modify as needed
        Call<MessageModel> call = apiService.getImageSlider(1);

        call.enqueue(new retrofit2.Callback<MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, retrofit2.Response<MessageModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    MessageModel messageModel = response.body();
                    if (messageModel.getSuccess() && messageModel.getResult() != null) {
                        // Update adapter with new data
                        adapter.updateData(messageModel.getResult());

                        // Refresh Indicator
                        circleIndicator.setViewPager(viewPager);
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                // Handle failure
                Toast.makeText(SlideImagesWithRetrofitActivity.this, "Failed to load images" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}