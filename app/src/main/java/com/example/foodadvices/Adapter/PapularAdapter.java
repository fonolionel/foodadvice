package com.example.foodadvices.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodadvices.R;
import com.example.foodadvices.activity.ShowDetailActivity;
import com.example.foodadvices.databinding.ViewholderPupolarBinding;
import com.example.foodadvices.domain.FoodDomain;

import java.util.ArrayList;

public class PapularAdapter extends RecyclerView.Adapter<PapularAdapter.ViewHolder> {


    private ArrayList<FoodDomain> foodDomains;

    public PapularAdapter(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewholderPupolarBinding binding= DataBindingUtil.inflate(inflater, R.layout.viewholder_pupolar,parent,false);



        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.binding.titlePop.setText(foodDomains.get(position).getTitle());



    holder.binding.btnAdd.setOnClickListener(v -> {
        Intent intent=new Intent(holder.binding.getRoot().getContext(), ShowDetailActivity.class);
        intent.putExtra("object",foodDomains.get(position));
        holder.itemView.getContext().startActivity(intent);
    });
    }




    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewholderPupolarBinding binding;
        public ViewHolder(@NonNull ViewholderPupolarBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
