package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.slawomirmakurat.ekoagromarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Register extends AppCompatActivity {

    private static final String TAG = "register";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.loginRegister_editText)
    EditText loginEditText;
    @BindView(R.id.emailRegister_editText)
    EditText emailEditText;
    @BindView(R.id.passwordRegister_editText)
    EditText passwordEditText;
    @BindView(R.id.checkPasswordRegister_editText)
    EditText checkPasswordEditText;
    @BindView(R.id.postcodeRegister_editText)
    EditText postcodeEditText;
    @BindView(R.id.phoneNumberRegister_editText)
    EditText phoneNumberEditText;

    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.cancel_button_register)
    Button cancelButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

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

        setTextWatcher(loginRegister_editText, user_name);
        setTextWatcher(emailRegister_editText, email_layout);
        setTextWatcher(password_editText, password_register);
        setTextWatcher(checkPasswordRegister_editText, password_register_check);
        setTextWatcher(postcodeRegister_editText, post_code_register);
        setTextWatcher(phoneNumberRegister_editText, number_phone_register);

        cancelButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
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
                    register();
                }
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

    public void register() {
        Log.d(TAG, "Register");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        registerButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Register.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getString(R.string.register_dialog));
        progressDialog.show();

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String chceckpassword = checkPasswordEditText.getText().toString();
        String postcode = postcodeEditText.getText().toString();
        String phone = phoneNumberEditText.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        onLoginSuccess();

                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        registerButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), getString(R.string.login_failed), Toast.LENGTH_LONG).show();

        registerButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String chceckpassword = checkPasswordEditText.getText().toString();
        String postcode = postcodeEditText.getText().toString();
        String phone = phoneNumberEditText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError(getString(R.string.enter_a_valid));
            valid = false;
        } else {
            emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordEditText.setError(getString(R.string.password_a_valid));
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        if (!(password.equals(chceckpassword))) {
            checkPasswordEditText.setError(getString(R.string.check_password));
            valid = false;
        } else {
            checkPasswordEditText.setError(null);
        }

//        if (!(checkPasswordEditText.equals(new String(passwordEditText)) {
//            checkPasswordEditText.setError(getString(R.string.password_a_valid));
//            valid = false;
//        } else {
//            checkPasswordEditText.setError(null);
//        }

        if (postcode.isEmpty() || postcode.length() <5 || postcode.length()> 6 ) {
            postcodeEditText.setError(getString(R.string.post_code));
            valid = false;
        } else {
            postcodeEditText.setError(null);
        }

        if (phone.isEmpty() || postcode.length() == 9) {
            phoneNumberEditText.setError(getString(R.string.phone_number_register));
            valid = false;
        } else {
            phoneNumberEditText.setError(null);
        }
        return valid;
    }
}

