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

    TextView numUSD;
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

        //Event handler for the convert button being clicked.
        btnConvert.setOnClickListener(new View.OnClickListener(){
            //double conversion = 0;

            @Override
            public void onClick(View v) {
                //Creates new ConversionRate object which is a class for the html scraping.
                ConversionRate cr = new ConversionRate();

                //Conditionals for each possible currency. Change the object's url and execute it.
                if (tvOther1.getText() == "Euro") {
                    cr.url = "https://www.google.com/search?ei=UCE7XvC_OMSttQbc9YGwBQ&q=currency+conversions&oq=currency+conversions&gs_l=psy-ab.3..0i131j0l6j0i10j0l2.45306.54628..54749...0.7..0.109.1513.19j1......0....1..gws-wiz.......0i71j0i67j0i131i67j0i273j0i273i70i258.PcSDKkNO4bo&ved=0ahUKEwjwp_SInLvnAhXEVs0KHdx6AFYQ4dUDCAs&uact=5";
                    cr.execute();
                }

                else if (tvOther1.getText() == "Japanese\nYen") {
                    cr.url = "https://www.google.com/search?ei=tVI7Xpn0JY-DtQa1hbPwDA&q=usd+to+japanese+yen&oq=usd+to+japa&gs_l=psy-ab.3.0.0l10.77559070.77561651..77563772...0.4..0.109.916.10j1......0....1..gws-wiz.......0i71j0i67j0i131j0i67i70i258j0i131i67j0i273j0i10.DgJiUajmXZE";
                    cr.execute();
                }

                else if (tvOther1.getText() == "British\nPound") {
                    cr.url = "https://www.google.com/search?ei=44I8Xv3HEoS3tAay3YXwCA&q=usd+to+british+pound&oq=usd+to+british+pound&gs_l=psy-ab.3..0i70i258j0l9.247154.250338..252754...0.2..0.194.1091.12j1......0....1..gws-wiz.......0i71j0i131j0i10.wI31i_nUkxM&ved=0ahUKEwi9xcOh7b3nAhWEG80KHbJuAY4Q4dUDCAs&uact=5";
                    cr.execute();
                }

                else if (tvOther1.getText() == "Canadian\nDollar") {
                    cr.url = "https://www.google.com/search?ei=4IM8XtvLMcuztAbJ_ZQo&q=usd+to+canadian+dollar&oq=usd+to+canadian+dollar&gs_l=psy-ab.3..0i70i258j0l9.410795.414050..414275...0.2..0.144.1205.14j1......0....1..gws-wiz.......0i71j0i67j0i131j0i10j0i131i70i258.t-bKIyD5I-M&ved=0ahUKEwjbu7Sa7r3nAhXLGc0KHck-BQUQ4dUDCAs&uact=5";
                    cr.execute();
                }

                else if (tvOther1.getText() == "Swiss\nFranc") {
                    cr.url = "https://www.google.com/search?ei=f4U8XrSFO47PtQai4bqICQ&q=usd+to+swiss+franc&oq=usd+to+swiss+franc&gs_l=psy-ab.3..0i70i258j0l6j0i22i30l3.115979.117340..117718...0.2..0.102.910.10j1......0....1..gws-wiz.......0i71j0i273j0i131i273j0i131j0i273i70i258.VBuynx0ZsQI&ved=0ahUKEwj0wK_g773nAhWOZ80KHaKwDpEQ4dUDCAs&uact=5";
                    cr.execute();
                }

                else if (tvOther1.getText() == "Australian\nDollar") {
                    cr.url = "https://www.google.com/search?ei=9oU8XpSjI8u7tAbdmp-YDQ&q=usd+to+australian+dollar&oq=usd+to+australian+dollar&gs_l=psy-ab.3..0i70i258j0l9.106281.109424..109618...0.2..0.92.1270.17......0....1..gws-wiz.......0i71j0i67j0i131j0i10i70i258.V_ruxcMPV-c&ved=0ahUKEwiU9vaY8L3nAhXLHc0KHV3NB9MQ4dUDCAs&uact=5";
                    cr.execute();
                }

                else if (tvOther1.getText() == "Mexican\nPeso") {
                    cr.url = "https://www.google.com/search?ei=ZIY8XsjkPIW2tAaezZqQDA&q=usd+to+mexican+peso&oq=usd+to+mexican+peso&gs_l=psy-ab.3..0i70i258j0l9.161205.162748..162990...0.2..2.187.1019.10j2......0....1..gws-wiz.......0i71.RsNMdju0bAw&ved=0ahUKEwjIpsrN8L3nAhUFG80KHZ6mBsIQ4dUDCAs&uact=5";
                    cr.execute();
                }
            }
        });
    }

    //Method to create the currency optoins menu.
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.currency_options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Method that controls what happens when each of the currency options are chosen.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Sets a TextView object named tvOther equal to the TextView with the id of tvOther
        TextView tvOther = (TextView)findViewById(R.id.tvOther);

        //Sets the numOther variable equal to the View with the id of numOther
        numOther = findViewById(R.id.numOther);
        //Integer variable named id that is equal to the id of the parameter item.
        int id = item.getItemId();

        //Change the TextView tvOther text to match the menu item's text.
        //Adjust the text size depending on which menu item is selected.
        //Clear the numbers of the EditText numOther when a new menu item is selected.
        if (id == R.id.miEuro){
            tvOther.setText("Euro");
            tvOther.setTextSize(36);
            tvOther.setTextColor(getColor(R.color.euro));
            numOther.setText("");
        }

        else if (id == R.id.miYen){
            tvOther.setText("Japanese\nYen");
            tvOther.setTextSize(20);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.japaneseYen));
        }

        else if (id == R.id.miPound){
            tvOther.setText("British\nPound");
            tvOther.setTextSize(22);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.britishPound));
        }

        else if (id == R.id.miCanadianDollar){
            tvOther.setText("Canadian\nDollar");
            tvOther.setTextSize(20);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.canadianDollar));
        }

        else if (id == R.id.miSwissFranc){
            tvOther.setText("Swiss\nFranc");
            tvOther.setTextSize(27);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.swissFranc));
        }

        else if (id == R.id.miAustralianDollar){
            tvOther.setText("Australian\nDollar");
            tvOther.setTextSize(20);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.australianDollar));
        }

        else if (id == R.id.miPeso){
            tvOther.setText("Mexican\nPeso");
            tvOther.setTextSize(22);
            numOther.setText("");
            tvOther.setTextColor(getColor(R.color.mexicanPeso));
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


        if (numUSD.getText().toString().length() > 0){
            usd = Double.parseDouble(numUSD.getText().toString());
            conversion = usd * conversionRate;
            strConversion = Double.toString(Math.round(conversion * 100.0) / 100.0);

            numOther.setText(strConversion);
        }
        else{
            numOther.setText("0.00");
        }
    }
  }
}
