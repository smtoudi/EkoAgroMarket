package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.slawomirmakurat.ekoagromarket.R;

public class Register extends AppCompatActivity {

    private CardView cardView = (CardView) findViewById(R.id.register_panel);
    private TextView textAppName = (TextView) findViewById(R.id.app_name);


    private Button btn_cancel = (Button) findViewById(R.id.cancel);
    private Button btn_add = (Button) findViewById(R.id.register_button);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final TextInputLayout user_name = (TextInputLayout) findViewById(R.id.user_name);
        final TextInputLayout email_layout = (TextInputLayout) findViewById(R.id.email_layout);
        final TextInputLayout password_register = (TextInputLayout) findViewById(R.id.passwordRegister);
        final TextInputLayout post_code_register = (TextInputLayout) findViewById(R.id.post_codee_register);
        final TextInputLayout password_register_check = (TextInputLayout) findViewById(R.id.password_register);
        final TextInputLayout number_phone_register = (TextInputLayout) findViewById(R.id.number_phone_register);
        final TextInputEditText loginRegister_editText = (TextInputEditText) findViewById(R.id.loginRegister_editText);
        final TextInputEditText emailRegister_editText = (TextInputEditText) findViewById(R.id.emailRegister_editText);
        final TextInputEditText password_editText = (TextInputEditText) findViewById(R.id.passwordRegister_editText);
        final TextInputEditText checkPasswordRegister_editText = (TextInputEditText) findViewById(R.id.checkPasswordRegister_editText);
        final TextInputEditText postcodeRegister_editText = (TextInputEditText) findViewById(R.id.postcodeRegister_editText);
        final TextInputEditText phoneNumberRegister_editText = (TextInputEditText) findViewById(R.id.phoneNumberRegister_editText);


        // setTextWatcher(TextInputEditText, TextInputLayout);
        setTextWatcher(loginRegister_editText, user_name);
        setTextWatcher(emailRegister_editText, email_layout);
        setTextWatcher(postcodeRegister_editText, post_code_register);
        setTextWatcher(password_editText, password_register);
        setTextWatcher(checkPasswordRegister_editText, password_register_check);
        setTextWatcher(phoneNumberRegister_editText, number_phone_register);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                intent.putExtra(Login.KEY_ACCOUNT_CREATED, true);
                startActivity(intent);
            }
        });

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


}
