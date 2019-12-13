package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnreview;
    private Button btnKomen;
    private Button btnAbout;
    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnreview = findViewById(R.id.btn_review);
        btnKomen = findViewById(R.id.btn_komentar);
        btnAbout = findViewById(R.id.btn_about);
        btnlogout = findViewById(R.id.btnlogout);

        btnreview.setOnClickListener(this);
        btnKomen.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnlogout.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btn_review:
                startActivity(new Intent(this, Review.class));
                break;
            case R.id.btn_komentar:
                startActivity(new Intent(this,Komentar.class));
                break;
            case R.id.btn_about:
                startActivity(new Intent(this, About.class));
                break;
            case R.id.btnlogout:
                startActivity(new Intent(this, Login.class));
        }
    }
}
