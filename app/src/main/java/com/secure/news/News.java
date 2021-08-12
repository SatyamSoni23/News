package com.secure.news;

public class News {
    public String title;
    public String author;
    public String url;
    public String imageUrl;

    public News(String title, String author, String url, String urlToImage) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.imageUrl = urlToImage;
    }
}
