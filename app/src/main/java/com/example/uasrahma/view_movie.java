package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class view_movie extends AppCompatActivity {
    private ArrayList <Movie> myMovie = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int id_genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movie);

        recyclerView = findViewById(R.id.recycler);
        recyclerViewAdapter = new RecyclerViewAdapter(myMovie, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        id_genre = intent.getIntExtra("GenreId", 0);

        MyArrayList();
    }
    private void MyArrayList(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=a94f441d95816197d94bcdf09f409367&with_genres="+id_genre;
        final JsonObjectRequest jsonReq = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arr = response.getJSONArray("results");
                    for (int i=0; i<arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        String title = obj.getString("title");
                        String poster_path = obj.getString("poster_path");
                        String adult = obj.getString("adult");
                        String popularity = obj.getString("popularity");
                        String vote_count = obj.getString("vote_count");
                        JSONArray genrearr = obj.getJSONArray("genre_ids");
                        int genre_ids[] = new int[genrearr.length()];
                        for(int j=0 ; j<genre_ids.length ; j++){
                            genre_ids[j] = genrearr.getInt(j);
                        }
                        String url_movie = "https://image.tmdb.org/t/p/w500" + poster_path;
                        myMovie.add(new Movie(title, poster_path, adult, popularity, vote_count, genre_ids, url_movie));
                    }
                    recyclerViewAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonReq);
    }
}
