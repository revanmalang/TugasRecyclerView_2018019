package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview1.models.Food;

public class MakananDetailActivity extends AppCompatActivity {

    ImageView iv_food;
    TextView Makanan, Makanan_price;
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        iv_food = findViewById(R.id.food_image);
        Makanan = findViewById(R.id.tv_title_detail);
        Makanan_price = findViewById(R.id.tv_price_detail);

        Food food = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(food != null) {
            Glide.with(this)
                    .load(food.getLogo())
                    .into(iv_food);
            Makanan.setText(food.getName());
            Makanan_price.setText(food.getPrice());
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Makanan Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}