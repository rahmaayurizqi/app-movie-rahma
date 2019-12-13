package com.example.uasrahma;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList <Movie> list_movie;
    private Context context;


    public RecyclerViewAdapter(ArrayList<Movie> list_movie, Context context) {
        this.list_movie = list_movie;
        this.context = context;
    }

    public ArrayList<Movie> getList_movie() {return list_movie; }

    public void setList_movie(ArrayList<Movie> list_movie) {
        this.list_movie = list_movie;
    }

    @NotNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_film,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
     final Movie movie = list_movie.get(position);
     String judul = movie.getTitle();
     String poster = movie.getPoster_path();

     holder.title.setText(judul);
        Glide.with(context)
                .asBitmap()
                .load(movie.getUrlgambar())
                .into(holder.show_image);
    }

    @Override
    public int getItemCount() {
        return list_movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, short_desc;
        private ImageView show_image;
        private CardView mylayout;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.judul);
            show_image = itemView.findViewById(R.id.gambar);
            mylayout = itemView.findViewById(R.id.card);
            mylayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Movie movie2 = list_movie.get(getAdapterPosition());
                    Intent intent = new Intent(context,detail_review.class);
                    intent.putExtra("MyData",movie2);
                    context.startActivity(intent);
                }
            });
        }
    }


}
