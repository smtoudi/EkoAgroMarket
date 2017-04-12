package com.example.slawomirmakurat.ekoagromarket.user;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.slawomirmakurat.ekoagromarket.R;

public class SendMessage extends Activity {


    private TextView Adress_emailTextView;
    private TextView Adress_email_User_TextView;
    private TextView textView_text_msg;
    private TextView Title;


    private EditText editText_Title_msg;
    private EditText editText_text_msg;

    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Adress_email_User_TextView = (TextView) findViewById(R.id.Adress_email_User_TextView);

        editText_Title_msg = (EditText) findViewById(R.id.editText_text_msg);
        editText_text_msg = (EditText) findViewById(R.id.editText_text_msg);

        btn_send = (Button) findViewById(R.id.button_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                composeEmail(Adress_email_User_TextView.getText().toString()
                        , editText_Title_msg.getText().toString()
                        ,editText_text_msg.getText().toString() );
            }
        });


    }

    public void composeEmail(String to, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
