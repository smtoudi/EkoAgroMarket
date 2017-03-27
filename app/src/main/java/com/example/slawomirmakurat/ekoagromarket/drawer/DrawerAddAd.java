package com.example.slawomirmakurat.ekoagromarket.drawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.slawomirmakurat.ekoagromarket.R;

import java.util.ArrayList;

import static com.example.slawomirmakurat.ekoagromarket.R.styleable.View;

public class DrawerAddAd extends AppCompatActivity {

    private Post_add post_add = new Post_add();

    public static ArrayList<String> fragments = new ArrayList<>();

    private ImageButton camera_imageButton;
    private Spinner spinner_category;
    private EditText titleAd_editText;
    private EditText textAd_editText;
    private CheckBox checkBox_season;
    private CheckBox checkBox_year;
    private CheckBox checkBox_ask;
    private Button seeAd_button;
    private Button addd_Ad_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_add_ad);
//        addListenerOnButtonClick();

        camera_imageButton = (ImageButton) findViewById(R.id.camera_imageButton);
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        titleAd_editText = (EditText) findViewById(R.id.titleAd_editText);
        textAd_editText = (EditText) findViewById(R.id.textAd_editText);

        seeAd_button = (Button) findViewById(R.id.seeAd_button);
        addd_Ad_button = (Button) findViewById(R.id.addd_Ad_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fragments, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter);


    }

//    public void addListenerOnButtonClick() {
//        checkBox_season = (CheckBox) findViewById(R.id.checkBox_season);
//        checkBox_year = (CheckBox) findViewById(R.id.checkBox_year);
//        checkBox_ask = (CheckBox) findViewById(R.id.checkBox_ask);
//
//
//    }
}