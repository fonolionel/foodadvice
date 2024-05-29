package com.example.foodadvices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodadvices.Adapter.CategoryAdapter;
import com.example.foodadvices.Adapter.PapularAdapter;
import com.example.foodadvices.activity.CartListActivity;
import com.example.foodadvices.databinding.ActivityMainBinding;
import com.example.foodadvices.domain.CategoryDomain;
import com.example.foodadvices.domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecyclerView.Adapter adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerCategory();
        recyclerPopular();

        binding.floatingHome.setOnClickListener(v -> {
            startActivity(new Intent(this, CartListActivity.class));
        });
    }

    private void recyclerCategory() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.recyclerViewCategoryList.setLayoutManager(layoutManager);

        ArrayList<CategoryDomain> categoryDomainArrayList=new ArrayList<>();
        categoryDomainArrayList.add(new CategoryDomain("Koki","cat_1"));
        categoryDomainArrayList.add(new CategoryDomain("Ekwang","cat_2"));
        categoryDomainArrayList.add(new CategoryDomain("Ndole","cat_3"));
        categoryDomainArrayList.add(new CategoryDomain("Poulet DG","cat_4"));
        categoryDomainArrayList.add(new CategoryDomain("Drinks","cat_5"));

        adapter=new CategoryAdapter(categoryDomainArrayList);
        binding.recyclerViewCategoryList.setAdapter(adapter);

    }

    private void recyclerPopular(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvPopular.setLayoutManager(layoutManager);
        ArrayList<FoodDomain> foodDomains=new ArrayList<>();
        foodDomains.add(new FoodDomain("Ekwang","pizza1","toamto, sorty food, vernob, dirgenarty",5.5));
        foodDomains.add(new FoodDomain("PoletDG","pizza1","toamto, sorty food, vernob, dirgenarty",9.0));
        foodDomains.add(new FoodDomain("Koki","pizza1","toamto, sorty food, vernob, dirgenarty",12.2));
        foodDomains.add(new FoodDomain("soup","pizza1","toamto, sorty food, vernob, dirgenarty",8.2));
        foodDomains.add(new FoodDomain("apple","pizza1","toamto, sorty food, vernob, dirgenarty",15.6));
        foodDomains.add(new FoodDomain("bannana","pizza1","toamto, sorty food, vernob, dirgenarty",20.0));

        adapter2 = new PapularAdapter(foodDomains);
        binding.rvPopular.setAdapter(adapter2);
    }
}