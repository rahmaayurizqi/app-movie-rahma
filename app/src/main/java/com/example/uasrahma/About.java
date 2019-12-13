package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends FragmentActivity implements View.OnClickListener {

    Button btnAbout, btnGenre, btnExit;
    AboutView aboutView;
    GenreView genreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnGenre = (Button) findViewById(R.id.btn_Genree);
        btnAbout = (Button) findViewById(R.id.btn_Aboutt);
        btnExit = (Button) findViewById(R.id.btn_exit);

        btnGenre.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    void mGenreView(){
        genreView = new GenreView();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.container, genreView);
        ft.commit();
    }
    void mAboutView(){
        aboutView = new AboutView();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutView);
        ft.commit();
    }
    void  mExit(){
        finish();
    }

    @Override
    public void onClick(View v){
        if (v == btnGenre){
            mGenreView();
        }
        if (v == btnAbout){
            mAboutView();
        }
        if (v == btnExit){
            mExit();
        }
    }
}
