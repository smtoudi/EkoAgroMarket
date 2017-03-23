package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.slawomirmakurat.ekoagromarket.MainActivity;
import com.example.slawomirmakurat.ekoagromarket.R;

import static com.example.slawomirmakurat.ekoagromarket.user.Login.KEY_ACCOUNT_CREATED;

public class Register extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        CardView cardView = (CardView) findViewById(R.id.register_panel);
        TextView new_user_textView = (TextView) findViewById(R.id.new_user_textView);


        Button btn_cancel = (Button) findViewById(R.id.cancel);
        Button btn_add = (Button) findViewById(R.id.register_button);

        final CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.activity_register);
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
        setTextWatcher(password_editText, password_register);
        setTextWatcher(checkPasswordRegister_editText, password_register_check);
        setTextWatcher(postcodeRegister_editText, post_code_register);
        setTextWatcher(phoneNumberRegister_editText, number_phone_register);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                intent.putExtra(KEY_ACCOUNT_CREATED, true);
                startActivity(intent);

                boolean error = false;

                if (TextUtils.isEmpty(loginRegister_editText.getText().toString())) {
                    user_name.setError(getString(R.string.empty_email_error));
                    error = true;
                }
                if (TextUtils.isEmpty(emailRegister_editText.getText().toString())) {
                    email_layout.setError(getString(R.string.empty_password_error));
                    error = true;
                }
                if (TextUtils.isEmpty(postcodeRegister_editText.getText().toString())) {
                    post_code_register.setError(getString(R.string.empty_password_error));
                    error = true;
                }
                if (TextUtils.isEmpty(password_editText.getText().toString())) {
                    password_register.setError(getString(R.string.empty_password_error));
                    error = true;
                }
                if (TextUtils.isEmpty(checkPasswordRegister_editText.getText().toString())) {
                    password_register_check.setError(getString(R.string.empty_password_error));
                    error = true;
                }
                if (TextUtils.isEmpty(phoneNumberRegister_editText.getText().toString())) {
                    number_phone_register.setError(getString(R.string.empty_password_error));
                    error = true;
                }
                if (!error) {
                    startActivity(new Intent(Register.this, MainActivity.class));
                }

            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        boolean accountCreated = getIntent().getBooleanExtra(KEY_ACCOUNT_CREATED, false);

        if (accountCreated) {
            Snackbar.make(container, R.string.account_created, Snackbar.LENGTH_LONG).show();
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


}
