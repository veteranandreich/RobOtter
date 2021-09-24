package com.github.veteranandreich.robotter.lambdas;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.veteranandreich.robotter.bot.RobOtter;
import com.github.veteranandreich.robotter.dto.ChatDto;
import com.github.veteranandreich.robotter.enums.MediaContentType;
import com.github.veteranandreich.robotter.models.RedditMeme;
import com.github.veteranandreich.robotter.models.RedditMemeContainer;
import com.github.veteranandreich.robotter.services.RedditService;

/**
 * Lambda for sending reddit random meme to telegram chat
 */
public class RandomRedditLambda implements RequestHandler<ChatDto, Object> {
    @Override
    public Object handleRequest(ChatDto chatDto, Context context) {
        RedditService service = new RedditService();
        RobOtter robOtter = new RobOtter();

        RedditMemeContainer memeContainer = service.getMemes(1).orElseThrow();
        RedditMeme meme = memeContainer.getMemes().get(0);
        MediaContentType mediaContentType = meme.getContentType().orElseThrow();

        switch (mediaContentType) {
            case PNG:
            case JPG:
                robOtter.sendPicture(meme.getUrl(), chatDto.getChatId(), meme.getTitle());
                break;
            case GIF:
                robOtter.sendAnimation(meme.getUrl(), chatDto.getChatId(), meme.getTitle());
                break;
            default:
                throw new IllegalArgumentException("Not supported media content");
        }

        return null;
    }
}
