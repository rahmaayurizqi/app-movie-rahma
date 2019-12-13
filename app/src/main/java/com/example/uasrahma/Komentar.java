package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Komentar extends AppCompatActivity implements View.OnClickListener {
    private Button btnback;
    private EditText mEditTextTo;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komentar);

        btnback = findViewById(R.id.btn_back2);
        mEditTextTo = findViewById(R.id.et_to);
        mEditTextMessage = findViewById(R.id.et_message);

        btnback.setOnClickListener(this);

        Button butttonSend = findViewById(R.id.btn_send);
        butttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void sendMail(){
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        //rahmaayurizqi1@gmail.com

        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfe822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.btn_back2:
                finish();
        }
    }
}
