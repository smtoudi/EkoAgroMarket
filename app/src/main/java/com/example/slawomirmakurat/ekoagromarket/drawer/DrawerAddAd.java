package com.example.slawomirmakurat.ekoagromarket.drawer;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.slawomirmakurat.ekoagromarket.R;

//import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.AddProduct;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.view.ProductDetails;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DrawerAddAd extends AppCompatActivity {

    private static final int REQUEST_TAKE_PHOTO = 999;
    public static ArrayList<String> fragments = new ArrayList<>();
    private final int REQUEST_CODE = 1;

    public ImageButton camera_imageButton;
    public ImageView photoView;
    public Spinner spinner_category;
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

    private int REQUEST_CAMERA = 1, SELECT_FILE = 1;
    private Button btnSelect;
    private ImageView Image;
    private String userChosenTask;

//    private AddProduct product;
    private String photoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_add_ad);
        ButterKnife.bind(this);

        final TextInputLayout title_ad_layout = (TextInputLayout) findViewById(R.id.add_title_ad_layout);
        final TextInputLayout text_ad_layout = (TextInputLayout) findViewById(R.id.add_text_ad_layout);
        final TextInputEditText title_Ad_editText = (TextInputEditText) findViewById(R.id.title_Ad_editText);
        final TextInputEditText text_Ad_editText = (TextInputEditText) findViewById(R.id.text_Ad_editText);
        setTextWatcher(title_Ad_editText, title_ad_layout);
        setTextWatcher(text_Ad_editText, text_ad_layout);

        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        button_seeAd_product = (Button) findViewById(R.id.button_seeAd_product);
        button_add_product = (Button) findViewById(R.id.button_ad_product);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            camera_imageButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

        camera_imageButton = (ImageButton) findViewById(R.id.camera_imageButton);
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

    private void seeAdd() {

        Intent intent = new Intent(DrawerAddAd.this, ProductDetails.class);
        intent.putExtra("title", titleAd_editText.getText().toString());
        intent.putExtra("text", textAd_editText.getText().toString());
        intent.putExtra("price", price_editText.getText().toString());
        intent.putExtra("spinner", String.valueOf(spinner_category.getSelectedItem()));


        startActivity(intent);

    }

    private void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox_season:
                if (checked) {

                } else {

                }
                break;
            case R.id.checkBox_year:
                if (checked) {

                } else {

                }
                break;
            case R.id.checkBox_detail:
                if (checked) {

                } else {

                }
                break;
            case R.id.checkBox_wholesale:
                if (checked) {

                } else {

                }
                break;
        }
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


    // APARAT

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 1234);
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode == RESULT_OK && requestCode == REQUEST_TAKE_PHOTO) {
//            product.setPhotoPatch(photoPath);
//            updatePhoto();
//        } else if (resultCode == RESULT_CANCELED) {
//            Toast.makeText(this, "Anulowano", Toast.LENGTH_SHORT).show();
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//
//    private void updatePhoto() {
//
//        if (product != null && product.getPhotoPatch() != null) {
//            camera_imageButton.setVisibility(View.GONE);
//            photoView.setVisibility(View.VISIBLE);
//            String photoPath = product.getPhotoPatch();
//            Glide.with(this).load(photoPath).fitCenter().into(photoView);
//        } else {
//            camera_imageButton.setVisibility(View.VISIBLE);
//            photoView.setVisibility(View.GONE);
//            camera_imageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dispatchTakePictureIntent();
//                }
//            });
//        }
//    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            photoFile = createImageFile();
            photoPath = photoFile.getAbsolutePath();

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }
    private File createImageFile() {

        String randomName = UUID.randomUUID().toString();

        File storageDir = new File(getExternalFilesDir(null), "product");
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }

        File image = null;
        image = new File(storageDir, randomName);

        return image;
    }


    // GALERIA


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

//    private void onCaptureImageResult(Intent data) {
//        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
//        File destination = new File(Environment.getExternalStorageDirectory(),
//                System.currentTimeMillis() + ".jpg");
//        FileOutputStream fo;
//        try {
//            destination.createNewFile();
//            fo = new FileOutputStream(destination);
//            fo.write(bytes.toByteArray());
//            fo.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Image.setImageBitmap(thumbnail);
//    }
}