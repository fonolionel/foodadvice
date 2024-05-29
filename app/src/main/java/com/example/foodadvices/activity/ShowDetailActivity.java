package com.example.foodadvices.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodadvices.R;
import com.example.foodadvices.databinding.ActivityShowDetailBinding;
import com.example.foodadvices.domain.FoodDomain;
import com.example.foodadvices.helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {

    private ActivityShowDetailBinding binding;
    private FoodDomain object;
    private int numOrder=1;

    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managementCart=new ManagementCart(this);
        getBundle();
    }

    private void getBundle() {
        object= (FoodDomain) getIntent().getSerializableExtra("object");

        binding.feeTxt.setText("$"+object.getFee());
        binding.descTxt.setText(object.getDescription());
        binding.titleText.setText(object.getTitle());
        binding.numberOrder.setText(String.valueOf(numOrder));
        binding.minusBtn.setOnClickListener(v -> {
            if (numOrder>1) {
                numOrder = numOrder - 1;

            }
            binding.numberOrder.setText(String.valueOf(numOrder));
        });
        binding.plusBtn.setOnClickListener(v -> {
            numOrder=numOrder+1;
            binding.numberOrder.setText(String.valueOf(numOrder));
        });

        binding.addToCart.setOnClickListener(v -> {
            object.setNumberInCart(numOrder);
            managementCart.insertFood(object);
        });

    }
}