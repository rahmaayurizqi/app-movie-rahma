package com.example.uasrahma;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

public class Movie implements Parcelable {
    private String title;
    private String poster_path;
    private String adult;
    private String popularity;
    private String vote_count;
    private int genre_ids[];
    private String urlgambar;



    public Movie(String title, String poster_path, String adult, String popularity, String vote_count, int genre_ids[], String urlgambar) {
        this.title = title;
        this.poster_path = poster_path;
        this.adult = adult;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.genre_ids = genre_ids;
        this.urlgambar = urlgambar;
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        adult = in.readString();
        popularity = in.readString();
        vote_count = in.readString();
        genre_ids = in.createIntArray();
        urlgambar = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getUrlgambar() {
        return urlgambar;
    }

    public void setUrlgambar(String urlgambar) {
        this.urlgambar = urlgambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeString(adult);
        parcel.writeString(popularity);
        parcel.writeString(vote_count);
        parcel.writeIntArray(genre_ids);
        parcel.writeString(urlgambar);
    }
}
