package com.example.uasrahma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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

public class Review extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnBack;
    private String TAG = "Check";
    private ArrayList <String> words = new ArrayList<>();
    private int [] id_genre = new int[19];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=a94f441d95816197d94bcdf09f409367";
        JsonObjectRequest jsonReq = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arr = response.getJSONArray("genres");

                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        String genre = obj.getString("name");
                        int id = obj.getInt("id");
                        words.add(genre);
                        id_genre[i] = id;
                    }
                    itemsAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: Error volley");
            }
        });
        queue.add(jsonReq);
        System.out.println("View hasil : " + words.size());

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       // Toast.makeText(getApplicationContext(),"position "+id_genre[i],Toast.LENGTH_SHORT).show();
        Log.d("CLICK", "onItemClick: " + adapterView.getItemAtPosition(i));
        Intent intent = new Intent(Review.this, view_movie.class);
        intent.putExtra("GenreId", id_genre[i]);
        startActivity(intent);


    }
}
