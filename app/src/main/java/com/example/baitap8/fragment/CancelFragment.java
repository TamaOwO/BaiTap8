package com.example.baitap8.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baitap8.databinding.FragmentCancelBinding;

public class CancelFragment extends Fragment {
    // Sử dụng binding trong Fragment
    FragmentCancelBinding binding;

    public CancelFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCancelBinding.inflate(inflater, container, false);

        // Recyclerview

        return binding.getRoot();
    }
}
