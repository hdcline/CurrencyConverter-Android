package com.example.currencyconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

//import java.text.DecimalFormat;
//import java.util.Scanner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOther1 = (TextView)findViewById(R.id.tvOther);

        tvOther1.setText("Euro");
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.currency_options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //int id = R.id.miEuro;

        TextView tvOther = (TextView)findViewById(R.id.tvOther);
        int id = item.getItemId();

        //tvOther.setText(miEuro.getTitle());

        if (id == R.id.miEuro){
            tvOther.setText(item.getTitle());
            tvOther.setTextSize(36);
        }

        else if (id == R.id.miYen){
            tvOther.setText("Japanese\nYen");
            tvOther.setTextSize(20);
        }

        else if (id == R.id.miPound){
            tvOther.setText("British\nPound");
            tvOther.setTextSize(22);
        }

        else if (id == R.id.miCanadianDollar){
            tvOther.setText("Canadian\nDollar");
            tvOther.setTextSize(20);
        }

        else if (id == R.id.miSwissFranc){
            tvOther.setText("Swiss\nFranc");
            tvOther.setTextSize(27);
        }

        else if (id == R.id.miAustralianDollar){
            tvOther.setText("Australian\nDollar");
            tvOther.setTextSize(20);
        }

        else if (id == R.id.miPeso){
            tvOther.setText("Mexican\nPeso");
            tvOther.setTextSize(22);
        }

        return super.onOptionsItemSelected(item);
    }
}
