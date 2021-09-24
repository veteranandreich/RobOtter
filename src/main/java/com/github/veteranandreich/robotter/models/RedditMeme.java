package com.github.veteranandreich.robotter.models;

import java.util.Optional;

import com.github.veteranandreich.robotter.enums.MediaContentType;

/**
 * Reddit meme representation
 */
public class RedditMeme {
    String title;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<MediaContentType> getContentType() {
        return MediaContentType.getContentType(url);
    }

    @Override
    public String toString() {
        return "RedditMeme{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
