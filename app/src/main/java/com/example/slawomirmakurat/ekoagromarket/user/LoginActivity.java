package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slawomirmakurat.ekoagromarket.MainActivity;
import com.example.slawomirmakurat.ekoagromarket.R;
import com.example.slawomirmakurat.ekoagromarket.apiClient.ApiManager;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Login;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.LoginResponse;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.Status;
import com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ApiManager.OnLoginListener {

//    private static final String TAG = "LoginActivity";
//    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.login_button)
    Button login_button;
    @BindView(R.id.cancel_button_login)
    Button cancel_button_login;
    @BindView(R.id.btn_new_user)
    Button btn_new_user;
    @BindView(R.id.btn_user_facebook)
    Button btn_user_facebook;
    @BindView(R.id.btn_user_google)
    Button btn_user_google;

    @BindView(R.id.email_log_edittext)
    TextInputEditText emailInput;
    @BindView(R.id.password_log_edittext)
    TextInputEditText passwordInput;

    @BindView(R.id.email_log_layout)
    TextInputLayout loginInputLayout;
    @BindView(R.id.password_log_layout)
    TextInputLayout passwordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        final TextInputLayout loginInputLayout = (TextInputLayout) findViewById(R.id.email_log_layout);
        final TextInputLayout passwordInputLayout = (TextInputLayout) findViewById(R.id.password_log_layout);
        setTextWatcher(passwordInput, passwordInputLayout);

        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean error = false;

                if (TextUtils.isEmpty(emailInput.getText().toString())) {
                    loginInputLayout.setError(getString(R.string.empty_email_error));
                    error = true;
                }

                if (TextUtils.isEmpty(passwordInput.getText().toString())) {
                    passwordInputLayout.setError(getString(R.string.empty_password_error));
                    error = true;
                }

                if (!error) {
                    login();
                }

            }
        });


        btn_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        cancel_button_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
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

//    public void login() {
//        Log.d(TAG, "Login");
//
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }
//
//
//        login_button.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage(getString(R.string.autoryzation));
//        progressDialog.show();
//
//        String email = emailInput.getText().toString();
//        String password = passwordInput.getText().toString();
//
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//
//                        onLoginSuccess();
//
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }


    private void login() {
//        if (!validate()) {
            Login login = new Login(emailInput.getText().toString(), passwordInput.getText().toString());
            ApiManager.login(login, this);
//        }
    }

    @Override
    public void onLogin(LoginResponse response) {
        Status status = response.getStatus();
        switch (status) {
            case OK:
                Toast.makeText(this, getString(R.string.succes), Toast.LENGTH_SHORT).show();
                onLoggedIn(response.getId());
                break;
            case UNAUTHORISED:
                Toast.makeText(this, getString(R.string.wrong_password), Toast.LENGTH_SHORT).show();
                break;
            case NO_USER:
                Toast.makeText(this, getString(R.string.wrong_login), Toast.LENGTH_SHORT).show();
                break;
        }

    }
    private void onLoggedIn(Long user) {
        Toast.makeText(this,getString(R.string.welcome),Toast.LENGTH_SHORT).show();
//        SessionManager.getInstance().setUser(user);
        startActivity(new Intent(this,MainActivity.class));
    }

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_SIGNUP) {
//            if (resultCode == RESULT_OK) {
//
//                this.finish();
//            }
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//
//        moveTaskToBack(true);
//    }
//
//    public void onLoginSuccess() {
//        login_button.setEnabled(true);
//        finish();
//    }
//
//    public void onLoginFailed() {
//        Toast.makeText(getBaseContext(), getString(R.string.login_failed), Toast.LENGTH_LONG).show();
//
//        login_button.setEnabled(true);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String email = emailInput.getText().toString();
//        String password = passwordInput.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailInput.setError(getString(R.string.enter_a_valid));
//            valid = false;
//        } else {
//            emailInput.setError(null);
//        }
//
//        return valid;
//    }


}
