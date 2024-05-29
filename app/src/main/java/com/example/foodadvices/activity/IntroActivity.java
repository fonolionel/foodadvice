package com.example.foodadvices.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodadvices.MainActivity;
import com.example.foodadvices.R;
import com.example.foodadvices.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {


    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnStart.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}