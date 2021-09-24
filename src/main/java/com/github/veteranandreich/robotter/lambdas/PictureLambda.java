package com.github.veteranandreich.robotter.lambdas;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.veteranandreich.robotter.bot.RobOtter;
import com.github.veteranandreich.robotter.dto.PictureDto;

/**
 * Lambda for sending picture to telegram chat
 */
public class PictureLambda implements RequestHandler<PictureDto, Object> {

    @Override
    public Object handleRequest(PictureDto pictureDto, Context context) {
        RobOtter robOtter = new RobOtter();
        robOtter.sendPicture(pictureDto.getUrl(), pictureDto.getChatId(), pictureDto.getCaption());

        return null;
    }
}
