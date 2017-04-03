package com.example.slawomirmakurat.ekoagromarket.drawer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.slawomirmakurat.ekoagromarket.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

public class DrawerAddAd extends AppCompatActivity  {

    private Post_add post_add = new Post_add();

    public static ArrayList<String> fragments = new ArrayList<>();


    private ImageButton camera_imageButton;
    private Spinner spinner_category;
    private Button button_seeAd_product;
    private Button button_add_product;

    @BindView(R.id.title_Ad_editText)
    EditText titleAd_editText;

    @BindView(R.id.text_Ad_editText)
    EditText textAd_editText;

    @BindView(R.id.price_editText)
    EditText price_editText;

    @BindView(R.id.checkBox_season)
    CheckBox checkBox_season;

    @BindView(R.id.checkBox_year)
    CheckBox checkBox_year;

    @BindView(R.id.checkBox_detail)
    CheckBox checkBox_detail;

    @BindView(R.id.checkBox_wholesale)
    CheckBox checkBox_whoLesale;

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button btnSelect;
    private ImageView Image;
    private String userChosenTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_add_ad);

        final TextInputLayout title_ad_layout = (TextInputLayout) findViewById(R.id.add_title_ad_layout);
        final TextInputLayout text_ad_layout = (TextInputLayout) findViewById(R.id.add_text_ad_layout);

        final TextInputEditText title_Ad_editText = (TextInputEditText) findViewById(R.id.title_Ad_editText);
        final TextInputEditText text_Ad_editText = (TextInputEditText) findViewById(R.id.text_Ad_editText);

        setTextWatcher(title_Ad_editText, title_ad_layout);
        setTextWatcher(text_Ad_editText, text_ad_layout);

        camera_imageButton = (ImageButton) findViewById(R.id.camera_imageButton);
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        button_seeAd_product = (Button) findViewById(R.id.button_seeAd_product);
        button_add_product = (Button) findViewById(R.id.button_ad_product);

        camera_imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        button_seeAd_product.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean error = false;

                if (TextUtils.isEmpty(title_Ad_editText.getText().toString())) {
                    title_ad_layout.setError(getString(R.string.empty_field));
                    error = true;
                }
                if (TextUtils.isEmpty(text_Ad_editText.getText().toString())) {
                    text_ad_layout.setError(getString(R.string.empty_field));
                    error = true;
                }

                if (!error) {
                    seeAdd();
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fragments, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter);
    }

    private void setTextWatcher(final TextInputEditText editText, final TextInputLayout inputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (inputLayout.isErrorEnabled()) {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void seeAdd() {

    }

    private void selectImage() {
        final CharSequence[] items = {"Zrób zdjęcie", "Wybierz z katalogu", "Anuluj"};
        AlertDialog.Builder builder = new AlertDialog.Builder(DrawerAddAd.this);
        builder.setTitle("Dodaj zdjęcie");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(DrawerAddAd.this);
                if (items[item].equals("Zrób zdjęcie")) {
                    userChosenTask = "Zrób zdjęcie";
                    if (result)
                        cameraIntent();
                } else if (items[item].equals("Wybierz z katalogu")) {
                    userChosenTask = "Wybierz z katalogu";
                    if (result)
                        galleryIntent();
                } else if (items[item].equals("Anuluj")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Wybierz plik"), SELECT_FILE);
    }


    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Image.setImageBitmap(bm);
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image.setImageBitmap(thumbnail);
    }
}