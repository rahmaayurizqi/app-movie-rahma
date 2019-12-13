package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detail_review extends AppCompatActivity {
    private TextView mytitle;
    private ImageView gambar;
    private TextView adult;
    private TextView popularity;
    private TextView voteCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_review);
        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("MyData");

        String nama = movie.getTitle();
        String poster = movie.getPoster_path();
        String adultt = movie.getAdult();
        String popular = movie.getPopularity();
        String vote = movie.getVote_count();

        System.out.println("Judulnya nah : " + nama);

        mytitle = findViewById(R.id.title);
        gambar = findViewById(R.id.poster);
        adult = findViewById(R.id.adult);
        popularity = findViewById(R.id.popularity);
        voteCount = findViewById(R.id.vote_count);

        mytitle.setText(nama);
        Glide.with(getApplicationContext())
                .asBitmap()
                .load(movie.getUrlgambar())
                .into(gambar);
        adult.setText(adultt);
        popularity.setText(popular);
        voteCount.setText(popular);
    }
}
