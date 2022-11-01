package com.example.recyclerview1.datas;

import com.example.recyclerview1.R;
import com.example.recyclerview1.models.Food;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodData {
    private static String [] foodName = {
            "Burger",
            "Kentang",
            "Roti",
            "Coca Cola",
            "Burger Jumbo",
            "Kentang Pedas",
            "Kentang Manis",
    };

    private static String [] foodPrice = {
            "2000",
            "5000",
            "10000",
            "2000",
            "5000",
            "10000",
            "10000",
            "10000"
    };

    private static int [] foodImage = {
            R.drawable.bizza,
            R.drawable.kentang,
            R.drawable.roti,
            R.drawable.cocacola,
            R.drawable.bizza,
            R.drawable.kentang,
            R.drawable.kentang,
            R.drawable.kentang,
    };

    public static ArrayList<Food> getDataFood() {
        ArrayList<Food> list = new ArrayList<>();
        for(int i=0;i<foodName.length;i++){
            Food food = new Food(foodName[i],"Rp " + foodPrice[i], foodImage[i]);
            list.add(food);
        }
        return list;
    }
}
