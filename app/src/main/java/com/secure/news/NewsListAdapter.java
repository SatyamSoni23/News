package com.secure.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

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
        String currentItem = items.get(position).title;
        holder.textView.setText(currentItem);
    }

    void updatedNews(ArrayList<News> updateNews){
        items.clear();
        items.addAll(updateNews);

        notifyDataSetChanged();
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public NewsViewHolder(@NonNull View view) {
        super(view);
        textView = view.findViewById(R.id.title);
    }
}

interface NewsItemClicked {
    void onItemClicked(News item);
}
