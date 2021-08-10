package com.secure.news;

public class News {
    String title;
    String author;
    String url;
    String imageUrl;

    public News(String title, String author, String url, String urlToImage) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.imageUrl = urlToImage;
    }
}
