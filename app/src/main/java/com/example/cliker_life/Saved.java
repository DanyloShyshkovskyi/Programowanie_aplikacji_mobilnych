package com.example.cliker_life;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import static com.example.cliker_life.MainActivity.city;
import static com.example.cliker_life.MainActivity.home;
import static com.example.cliker_life.MainActivity.textmoney;

public class Saved extends AppCompatActivity {
    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;
    public Saved(){};
    public static void init(Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }
    void save(){
        editor.putInt("money", MainActivity.coutmoney);
        editor.putInt("price1", Improve.price1);
        editor.putInt("moneyplus", MainActivity.money);
        editor.putInt("home_price", MainActivity.home_money);
        editor.putInt("city_price", MainActivity.city_money);
        editor.commit();
    }
    void load_save(){
        MainActivity.coutmoney = preferences.getInt("money", 0);
        Improve.price1 = preferences.getInt("price1", 500);
        MainActivity.money = preferences.getInt("moneyplus", 100);
        MainActivity.city_money = preferences.getInt("city_price", 0);
        MainActivity.home_money = preferences.getInt("home_price", 0);
        textmoney.setText(MainActivity.coutmoney + "");
        home.setText("Potrzeby\n" +  MainActivity.home_money);
        city.setText("Podatek\n" + MainActivity.city_money);
    }
}
