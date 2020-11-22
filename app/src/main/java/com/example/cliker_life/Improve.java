package com.example.cliker_life;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Improve extends AppCompatActivity {
    Button laptop, home_price, city_price;
    public static int price1 = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        laptop = (Button) findViewById(R.id.laptop);
        home_price = (Button) findViewById(R.id.home_price);
        city_price = (Button) findViewById(R.id.city_price);
        laptop.setText("Zwiększyć moc komputera, " + price1 + "PLN");
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= price1) {
                    MainActivity.money += 100;
                    MainActivity.coutmoney -= price1;
                    price1+=200;
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    laptop.setText("Zwiększyć moc komputera, " + price1 + " PLN");
                    new Saved().save();
                }
            }
        });
        city_price.setText("Zapłać podatki " + MainActivity.city_money);
        city_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.city_money){
                    MainActivity.coutmoney -= MainActivity.city_money;
                    MainActivity.city_money = 0;
                    MainActivity.city.setText("Podatek\n" + MainActivity.city_money);
                    city_price.setText("Zapłać podatki " + MainActivity.city_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
        home_price.setText("Zapłać za potrzeby " + MainActivity.home_money * 2);
        home_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.home_money){
                    MainActivity.coutmoney -= MainActivity.home_money * 2;
                    MainActivity.home_money = 0;
                    home_price.setText("Zapłać za potrzeby " + MainActivity.home_money * 2);
                    MainActivity.home.setText("Potrzeby" +  MainActivity.home_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
    }
}
