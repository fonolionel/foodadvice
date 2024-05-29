package com.example.foodadvices.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.foodadvices.R;

public class CartListActivity extends AppCompatActivity {
private ProgressBar fats,proteins,carbohydrate;
int i=0;
private TextView progress_text,protein_text,carbohydrate_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_list);
        proteins=findViewById(R.id.protein);
        carbohydrate=findViewById(R.id.carbohydrate);
        fats=findViewById(R.id.fats);
        progress_text=findViewById(R.id.fats_text);
        protein_text=findViewById(R.id.protein_text);
        carbohydrate_text=findViewById(R.id.carbohydrate_text);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            if(i<=100){
                fats.setProgress(i-25);
                progress_text.setText("Fats "+(i-25)+"%");
                i++;
                handler.postDelayed(this,200);
                proteins.setProgress(i-35);
                carbohydrate.setProgress(i-10);
                carbohydrate_text.setText("Carbohydrate "+(i-10)+"%");
                protein_text.setText("Proteins "+(i-35)+"%");
            }
            }
        },150);
   }
}