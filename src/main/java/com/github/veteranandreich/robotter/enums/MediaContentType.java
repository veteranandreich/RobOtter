package com.github.veteranandreich.robotter.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum representing content types of reddit memes
 */
public enum MediaContentType {
    JPG("jpg"),
    GIF("gif"),
    PNG("png");

    String extension;

    MediaContentType(String extension) {
        this.extension = extension;
    }

    /**
     * Get content type based on content url
     * @param url content url
     */
    public static Optional<MediaContentType> getContentType(String url) {
        return Arrays.stream(values())
                .filter(v -> url.endsWith(v.extension))
                .findFirst();
    }


}
