package com.example.slawomirmakurat.ekoagromarket.model.POJO.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.slawomirmakurat.ekoagromarket.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProductDetails extends AppCompatActivity {

    private TextView title, text, price, actualdate, spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = (TextView) findViewById(R.id.title_textView);
        text = (TextView) findViewById(R.id.text_textView);
        price = (TextView) findViewById(R.id.price_textView);
        actualdate = (TextView) findViewById(R.id.actualdate_textView);
        spinner = (TextView) findViewById(R.id.spinner_category);


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Intent intent = getIntent();

        String title_textView = intent.getStringExtra("title");
        String text_textView = intent.getStringExtra("text");
        String price_textView = intent.getStringExtra("price");
//        String actualdate_textView = intent.getStringExtra();
        String spinner_category = intent.getStringExtra("spinner");

        title.setText(title_textView);
        title.setText(title_textView);
        text.setText(text_textView);
        price.setText(price_textView);
//        actualdate.setText(actualdate_textView);
        spinner.setText(spinner_category);

//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = sdf.format(c.getTime());


    }

}
