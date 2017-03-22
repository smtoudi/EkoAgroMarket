package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.slawomirmakurat.ekoagromarket.R;

public class Register extends Activity {


        private Button btn_cancel;
        private Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                intent.putExtra(Login.KEY_ACCOUNT_CREATED, true);
                startActivity(intent);
            }
        });
    }
}
