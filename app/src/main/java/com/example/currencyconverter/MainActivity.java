package com.example.currencyconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.NumberKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

//import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

//import java.text.DecimalFormat;
//import java.util.Scanner;

public class MainActivity extends Activity {

    Button btnConvert;

    EditText numUSD;
    EditText numOther;

    TextView tvOther1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numUSD = findViewById(R.id.numUSD);
        numOther = findViewById(R.id.numOther);

        tvOther1 = findViewById(R.id.tvOther);

        tvOther1.setText("Euro");

        btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener(){
            //double conversion = 0;

            @Override
            public void onClick(View v) {
                if (tvOther1.getText() == "Euro") {
                    //double usd = Double.parseDouble(numUSD.getText().toString());
                    //conversion.usd = Double.parseDouble(numUSD.getText().toString());
                    ConversionRate cr = new ConversionRate();
                    cr.url = "https://www.google.com/search?ei=UCE7XvC_OMSttQbc9YGwBQ&q=currency+conversions&oq=currency+conversions&gs_l=psy-ab.3..0i131j0l6j0i10j0l2.45306.54628..54749...0.7..0.109.1513.19j1......0....1..gws-wiz.......0i71j0i67j0i131i67j0i273j0i273i70i258.PcSDKkNO4bo&ved=0ahUKEwjwp_SInLvnAhXEVs0KHdx6AFYQ4dUDCAs&uact=5";
                    cr.execute();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.currency_options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //int id = R.id.miEuro;

        TextView tvOther = (TextView)findViewById(R.id.tvOther);
        numOther = findViewById(R.id.numOther);
        int id = item.getItemId();

        //tvOther.setText(miEuro.getTitle());

        if (id == R.id.miEuro){
            tvOther.setText("Euro");
            tvOther.setTextSize(36);
            numOther.setText("");
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




class ConversionRate extends AsyncTask<Void, Void, Void> {
    String strConversion;
    double usd = 0;
    double conversionRate = 0;
    double conversion;
    String url;

    protected void onPreExecute() {
        super.onPreExecute();
        //usd = Double.parseDouble(numUSD.getText().toString());
    }

    protected Void doInBackground(Void... params) {

        try {

            Document document = Jsoup.connect(url).get();

            Elements rate = document.select("[data-value]");

            conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            url = document.title();

            //double usd = Double.parseDouble(numUSD.getText().toString());


            //numOther.setText(strConversion);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        usd = Double.parseDouble(numUSD.getText().toString());
        conversion = usd * conversionRate;
        strConversion = Double.toString(Math.round(conversion * 100.0) / 100.0);

        numOther.setText(strConversion);
    }
  }
}
