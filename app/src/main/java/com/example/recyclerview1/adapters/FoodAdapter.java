package com.example.recyclerview1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview1.R;
import com.example.recyclerview1.models.Food;

import org.w3c.dom.Text;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    List<Food> foodList;
    OnItemClickCallback onItemClickCallback;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View foodView = layoutInflater.inflate(R.layout.item_food,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(foodView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getName());
        holder.foodPrice.setText(food.getPrice());
        Glide.with(holder.itemView.getContext())
                .load(food.getLogo())
                .apply(new RequestOptions().override(80,80))
                .into(holder.foodPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(foodList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
//        return 0;
        return (foodList != null) ? foodList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView foodName, foodPrice;
        public ImageView foodPhoto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.tv_title);
            foodPrice = itemView.findViewById(R.id.tv_price);
            foodPhoto = itemView.findViewById(R.id.image_logo);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Food data);
    }
}
