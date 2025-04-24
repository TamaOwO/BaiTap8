package com.example.baitap8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap8.R;
import com.example.baitap8.adapter.IconAdapter;
import com.example.baitap8.indicator.LinePagerIndicatorDecoration;
import com.example.baitap8.model.IconModel;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewSearch extends AppCompatActivity {
    RecyclerView rcIcon;
    IconAdapter iconAdapter;
    SearchView searchView;
    ArrayList<IconModel> arrayList1;
    Button btnNextFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // 🛠 THÊM setContentView() ĐỂ ĐẢM BẢO ĐÃ LOAD LAYOUT
        setContentView(R.layout.activity_recycle_view_search);


        rcIcon = findViewById(R.id.rcIcon);
        searchView = findViewById(R.id.searchView);
        btnNextFlipper = findViewById(R.id.btnNextFlipper);
        btnNextFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewSearch.this, ViewFlipperActivity.class);
                startActivity(intent);
            }
        });

        arrayList1= new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon3, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon4, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon5, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon6, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon7, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon8, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon9, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "Jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon3, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon4, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon5, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon6, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon7, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon8, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon9, "dfgfhyh sxdff"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

    }

    private void filterList(String newText) {
        List<IconModel> filteredList = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(iconModel);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        } else {
            if (iconAdapter != null) {  // 🛠 Kiểm tra nếu iconAdapter đã được khởi tạo
                iconAdapter.setlistenerList(filteredList);
            } else {
                Log.e("RecycleViewSearch", "iconAdapter is null!");
            }
        }
    }

}