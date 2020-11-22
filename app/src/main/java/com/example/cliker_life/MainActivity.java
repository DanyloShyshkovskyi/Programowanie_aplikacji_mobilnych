package com.example.cliker_life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public int coutmoney = 0;
    static public int money = 100;
    static public int home_money = 0, city_money = 0;
    Button next_day, improve;
    static public TextView textmoney, home, city;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_day = (Button)findViewById(R.id.next_day);
        improve = (Button)findViewById(R.id.improve);
        textmoney = (TextView)findViewById(R.id.money);
        home = (TextView)findViewById(R.id.home);
        city = (TextView)findViewById(R.id.city);
        Saved.init(getApplicationContext());
        new Saved().load_save();
        Next_day();
    }
    void Next_day(){
        next_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coutmoney += money;
                textmoney.setText(coutmoney + "");
                home_money += 25;
                city_money += 50;
                home.setText("Potrzeby\n" + home_money);
                city.setText("Podatek\n" + city_money);
                new Saved().save();
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });
    }

}
