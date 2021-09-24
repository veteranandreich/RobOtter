package com.github.veteranandreich.robotter.models;

import java.util.List;

/**
 * Container for {@link RedditMeme}
 */
public class RedditMemeContainer {
    List<RedditMeme> memes;

    public List<RedditMeme> getMemes() {
        return memes;
    }

    public void setMemes(List<RedditMeme> memes) {
        this.memes = memes;
    }

    @Override
    public String toString() {
        return "RedditMemeContainer{" +
                "memes=" + memes +
                '}';
    }
}
