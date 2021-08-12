package com.secure.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.secure.news.News;
import com.secure.news.NewsItemClicked;
import com.secure.news.R;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder>{
    ArrayList<News> items = new ArrayList<News>();
    private NewsItemClicked listener;
    public NewsListAdapter(NewsItemClicked newsItemClicked) {
        this.listener = newsItemClicked;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(items.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News currentItem = items.get(position);
        holder.textView.setText(currentItem.title);
        if(currentItem.author.equals("null")){
            holder.author.setText("Unknown Source");
        }
        else{
            holder.author.setText(currentItem.author);
        }
        Glide.with(holder.itemView.getContext()).load(currentItem.imageUrl).into(holder.image);
    }

    public void updatedNews(ArrayList<News> updateNews){
        items.clear();
        items.addAll(updateNews);

        notifyDataSetChanged();
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView textView, author;
    ImageView image;
    public NewsViewHolder(@NonNull View view) {
        super(view);
        textView = view.findViewById(R.id.title);
        author = view.findViewById(R.id.author);
        image = view.findViewById(R.id.image);
    }
}

