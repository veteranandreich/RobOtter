package com.github.veteranandreich.robotter.dto;

/**
 * DTO for pictures
 */
public class PictureDto extends ChatDto{
    String url;
    String caption;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
